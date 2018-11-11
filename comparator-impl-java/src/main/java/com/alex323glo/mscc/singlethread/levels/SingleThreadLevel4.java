package com.alex323glo.mscc.singlethread.levels;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO write doc!
 */
public class SingleThreadLevel4 extends AbstractExtendedSingleThreadLevel {

    private static final String MULTILINE_COMMENT_PATTERN = "(/\\*(.|[\\r\\n])*?\\*/)";
    private static final String SINGLE_LINE_COMMENT_PATTERN = "([/][/].*)";

    /**
     * TODO write doc!
     */
    @Override
    protected List<String> prettifyWordList(List<String> sourceList) {
        String[] words = String.join("\n", sourceList)
                .replaceAll(MULTILINE_COMMENT_PATTERN, "")
                .replaceAll(SINGLE_LINE_COMMENT_PATTERN, "")
                .split("\\s");

        return Arrays.stream(words)
                .filter(word -> (word != null && !word.isEmpty()))
                .collect(Collectors.toList());
    }
}
