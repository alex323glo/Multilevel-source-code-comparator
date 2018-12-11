package com.alex323glo.mscc.api.data.project;

import com.alex323glo.mscc.api.data.SourceCode;
import com.alex323glo.mscc.api.data.StringListSourceCode;
import com.alex323glo.mscc.api.data.project.options.ProjectOptions;
import com.alex323glo.mscc.api.exception.SrcComparisonException;
import lombok.NonNull;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MappedSrcProject implements SrcProject {

    private final Map<ProjectFileLocation, SourceCode> innerMap;

    private MappedSrcProject(@NonNull Map<ProjectFileLocation, SourceCode> innerMap) {
        this.innerMap = innerMap;
    }

    @Override
    public Map<ProjectFileLocation, SourceCode> getFiles() {
        return innerMap;
    }

    // TODO add ProjectOptions support
    public static MappedSrcProject of(@NonNull File projectRoot, @NonNull ProjectOptions options)
            throws SrcComparisonException {
        if (!projectRoot.exists()) {
            throw new SrcComparisonException("Root of compared doesn't exist!");
        }
        if (projectRoot.isFile()) {
            List<String> lines = readLinesFromFile(projectRoot);
            HashMap<ProjectFileLocation, SourceCode> resultMap = new HashMap<>();
            resultMap.put(
                    new ProjectFileLocation(projectRoot.getName(), "", projectRoot.getAbsolutePath()),
                    new StringListSourceCode(lines)
            );
            return new MappedSrcProject(resultMap);
        }

        Map<ProjectFileLocation, SourceCode> projectMap = runAndDive(projectRoot, MappedSrcProject::fileToSrc);
        return new MappedSrcProject(projectMap);
    }

    private static Map<ProjectFileLocation, SourceCode> runAndDive(File root, Function<File, SourceCode> action) {
        if (root.isFile()) {
            HashMap<ProjectFileLocation, SourceCode> map = new HashMap<>();
            SourceCode sourceCode = action.apply(root);
            if (sourceCode != null) {
                ProjectFileLocation location = new ProjectFileLocation(root.getName(),
                        "", root.getAbsolutePath());
                map.put(location, sourceCode);
            }
            return map;
        }
        return Arrays.stream(Objects.requireNonNull(root.listFiles()))
                .filter(file -> file != null && file.exists() && file.canRead())
                .map(file -> runAndDive(file, action))
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static SourceCode fileToSrc(File file) {
        try {
            List<String> lines = readLinesFromFile(file);
            return new StringListSourceCode(lines);
        } catch (SrcComparisonException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<String> readLinesFromFile(File file) throws SrcComparisonException {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()))
        ) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new SrcComparisonException("Some problems with file reading: " +
                    file.getAbsolutePath(), e);
        }
    }
}
