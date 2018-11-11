package com.alex323glo.mscc.singlethread.levels;

import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO write doc!
 */
public class SingleThreadLevel2 extends AbstractExtendedSingleThreadLevel {

    private static final String REPEATED_SPACES_PATTERN = "^ +| +$|( )+";

    /**
     * TODO write doc!
     */
    @Override
    protected List<String> prettifyWordList(List<String> sourceList) {
        return sourceList.stream()
                .filter(row -> (row != null && !row.isEmpty()))
                .map(row -> row.replace(REPEATED_SPACES_PATTERN, " "))
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}
