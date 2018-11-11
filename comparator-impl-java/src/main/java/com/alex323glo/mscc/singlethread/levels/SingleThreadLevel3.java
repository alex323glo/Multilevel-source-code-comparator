package com.alex323glo.mscc.singlethread.levels;

import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO write doc!
 */
public class SingleThreadLevel3 extends AbstractSingleThreadLevel {

    private static final String ALPHANUMERIC_SEQUENCES_PATTERN = "([a-zA-Z0-9]+)";
    private static final String SURROGATE_STRING = "X";

    @Override
    protected List<String> prettifyWordList(List<String> sourceList) {
        return sourceList.stream()
                .map(row -> row.replaceAll(ALPHANUMERIC_SEQUENCES_PATTERN, SURROGATE_STRING))
                .collect(Collectors.toList());
    }
}
