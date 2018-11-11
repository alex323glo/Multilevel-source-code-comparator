package com.alex323glo.mscc.singlethread.levels;

import com.alex323glo.mscc.api.data.SourceCode;
import com.alex323glo.mscc.api.levels.ComparisonLevel;
import com.alex323glo.mscc.api.result.PartialResult;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.alex323glo.mscc.singlethread.util.AnalysisUtils.searchEqualLinesInOrder;

public abstract class AbstractSingleThreadLevel implements ComparisonLevel {

    @Override
    public PartialResult compare(SourceCode sourceCode1, SourceCode sourceCode2) {
        List<String> text1 = prettifyWordList(sourceCode1.getList());
        List<String> text2 = prettifyWordList(sourceCode2.getList());

        AtomicInteger sequencesCount1 = new AtomicInteger(0);
        AtomicInteger sequencesCount2 = new AtomicInteger(0);

        int differencesNumber1 = text1.size() - searchEqualLinesInOrder(text1, text2, sequencesCount1);
        int differencesNumber2 = text2.size() - searchEqualLinesInOrder(text2, text1, sequencesCount2);

        return new PartialResult(
                text1.size(),
                text2.size(),
                differencesNumber1,
                differencesNumber2,
                sequencesCount1.get() < sequencesCount2.get() ? sequencesCount1.get() : sequencesCount2.get()
        );
    }

    protected abstract List<String> prettifyWordList(List<String> sourceList);
}
