package com.alex323glo.mscc.api.data.project.options;

import java.util.*;

public class ProjectOptions extends AbstractSet<Option> {

    private final AbstractSet<Option> innerSet;

    public ProjectOptions(Option...options) {
        if (options == null || options.length < 1) {
            innerSet = new HashSet<>();
        } else {
            innerSet = (options.length == 1) ? EnumSet.of(options[0])
                    : EnumSet.of(options[0], Arrays.copyOfRange(options, 1, options.length - 1));
        }
    }

    @Override
    public Iterator<Option> iterator() {
        return innerSet.iterator();
    }

    @Override
    public int size() {
        return innerSet.size();
    }

    public static ProjectOptions noOptions() {
        return new ProjectOptions();
    }
}
