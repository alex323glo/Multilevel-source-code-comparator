package com.alex323glo.mscc.api.data.project;

import lombok.NonNull;

import java.util.Objects;

public class ProjectFileLocation {

    @NonNull private final String fileName;
    @NonNull private final String filePackage;
    @NonNull private final String fullFilePath;

    public ProjectFileLocation(String fileName, String filePackage, String fullFilePath) {
        this.fileName = fileName;
        this.filePackage = filePackage;
        this.fullFilePath = fullFilePath;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePackage() {
        return filePackage;
    }

    public String getFullFilePath() {
        return fullFilePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectFileLocation that = (ProjectFileLocation) o;
        return Objects.equals(getFileName(), that.getFileName()) &&
                Objects.equals(getFilePackage(), that.getFilePackage()) &&
                Objects.equals(getFullFilePath(), that.getFullFilePath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFileName(), getFilePackage(), getFullFilePath());
    }
}
