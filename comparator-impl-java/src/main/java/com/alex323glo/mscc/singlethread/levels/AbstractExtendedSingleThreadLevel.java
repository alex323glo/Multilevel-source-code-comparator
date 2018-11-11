package com.alex323glo.mscc.singlethread.levels;

import com.alex323glo.mscc.api.data.SourceCode;
import com.alex323glo.mscc.api.levels.ExtendedComparisonLevel;
import com.alex323glo.mscc.api.result.ExtendedPartialResult;

import java.util.concurrent.atomic.AtomicInteger;

import static com.alex323glo.mscc.singlethread.util.AnalysisUtils.searchEqualLinesInOrder;

/**
 * More concrete extended comparison level model.
 * Is a partial implementation of Extended Comparison Level (see ExtendedComparisonLevel class docs) and
 * extends logic of Source Code Preprocessor (see AbstractSourceCodePreprocessor class docs).
 *
 * @author Alexey_O
 * @version 0.1
 *
 * @see ExtendedComparisonLevel
 * @see AbstractSourceCodePreprocessor
 */
public abstract class AbstractExtendedSingleThreadLevel
        extends AbstractSourceCodePreprocessor
        implements ExtendedComparisonLevel {

    /**
     * Compares 2 source code instances and generates extended partial comparison result data.
     *
     * @param sourceCode1 first target source code.
     * @param sourceCode2 first target source code.
     * @return extended comparison result. See more in ExtendedPartialResult class docs.
     * @see ExtendedPartialResult
     */
    @Override
    public ExtendedPartialResult compare(SourceCode sourceCode1, SourceCode sourceCode2) {
        SourceCode text1 = preProcessSourceCode(sourceCode1);
        SourceCode text2 = preProcessSourceCode(sourceCode2);

        AtomicInteger sequencesCount1 = new AtomicInteger(0);
        AtomicInteger sequencesCount2 = new AtomicInteger(0);

        int differencesNumber1 =
                text1.rowsCount() - searchEqualLinesInOrder(text1.getList(), text2.getList(), sequencesCount1);

        int differencesNumber2 =
                text2.rowsCount() - searchEqualLinesInOrder(text2.getList(), text1.getList(), sequencesCount2);

        return new ExtendedPartialResult(
                text1.rowsCount(),
                text2.rowsCount(),
                differencesNumber1,
                differencesNumber2,
                sequencesCount1.get() < sequencesCount2.get() ? sequencesCount1.get() : sequencesCount2.get(),
                text1,
                text2
        );
    }
}
