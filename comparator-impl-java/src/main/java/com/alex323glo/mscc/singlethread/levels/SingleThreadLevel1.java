package com.alex323glo.mscc.singlethread.levels;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * TODO write doc!
 */
public class SingleThreadLevel1 extends AbstractSingleThreadLevel {

    /**
     * Makes a copy of source list, with non-null "trimmed" elements.
     *
     * @param sourceList input List.
     * @return result copy.
     */
    @Override
    protected List<String> prettifyWordList(List<String> sourceList) {
        return sourceList.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
