package com.alex323glo.mscc.api.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of Source code data model interface.
 * Is based on ArrayList data structure.
 *
 * @author Alexey_O
 * @version 0.1
 */
@Data
public class StringListSourceCode implements SourceCode {

    private List<String> lineList;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private String[] lineArray;

    private StringListSourceCode() {
        lineList = new ArrayList<>();
        lineArray = null;
    }

    public StringListSourceCode(@NonNull List<String> lineList) {
        this.lineList = lineList;
        lineArray = null;
    }

    @Override
    public int rowsCount() {
        return lineList.size();
    }

    @Override
    public String getString() {
        return String.join("\n", lineList);
    }

    @Override
    public void setString(String text) {
        lineList = Arrays.asList(text.split("\n"));
    }

    @Override
    public List<String> getList() {
        return lineList;
    }

    @Override
    public void setList(List<String> text) {
        lineList = text;
        lineArray = null;
    }

    @Override
    public String[] getArray() {
        if (lineArray == null) {
            lineArray = (String[]) lineList.toArray();
        }
        return lineArray;
    }

    @Override
    public void setArray(String[] text) {
        lineList = Arrays.asList(text);
        lineArray = text;
    }

    @Override
    public StringListSourceCode copy() {
        ArrayList<String> newList = new ArrayList<>();
        lineList.forEach(el -> newList.add(el.substring(0)));
        return new StringListSourceCode(newList);
    }

    @Override
    public String toString() {
        return "StringListSourceCode{" +
                "lineList=" +
                lineList.stream().collect(Collectors.joining("\n", "\n[\n", "\n]\n")) +
                '}';
    }

    public static StringListSourceCode ofLines(@NonNull String text) {
        String[] lines = text.split("\n");
        StringListSourceCode sourceCode = new StringListSourceCode();
        sourceCode.setArray(lines);
        return sourceCode;
    }

    public static StringListSourceCode ofFile(@NonNull String fileName) throws IOException {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))
        ) {
            List<String> linesList = bufferedReader.lines().collect(Collectors.toList());
            return new StringListSourceCode(linesList);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
