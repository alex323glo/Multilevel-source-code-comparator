package com.alex323glo.mscc.api.result.project;

import com.alex323glo.mscc.api.data.project.ProjectFileLocation;
import lombok.NonNull;

import java.util.Objects;

public class PairDiffKey  {

    @NonNull private final ProjectFileLocation location1;
    @NonNull private final ProjectFileLocation location2;

    public PairDiffKey(ProjectFileLocation location1, ProjectFileLocation location2) {
        this.location1 = location1;
        this.location2 = location2;
    }

    public ProjectFileLocation getLocation1() {
        return location1;
    }

    public ProjectFileLocation getLocation2() {
        return location2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairDiffKey that = (PairDiffKey) o;
        return Objects.equals(getLocation1(), that.getLocation1()) &&
                Objects.equals(getLocation2(), that.getLocation2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocation1(), getLocation2());
    }
}
