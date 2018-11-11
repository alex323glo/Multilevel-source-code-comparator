package com.alex323glo.mscc.singlethread.levels;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO write doc!
 */
public class SingleThreadLevel5 extends AbstractSingleThreadLevel {

    /**
     * TODO write doc!
     */
    @Override
    protected List<String> prettifyWordList(List<String> sourceList) {
        return sourceList.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
