package com.alex323glo.mscc.singlethread;

import com.alex323glo.mscc.api.result.ExtendedPartialResult;
import com.alex323glo.mscc.api.result.PartialResult;
import com.alex323glo.mscc.api.levels.ComparisonLevel;
import com.alex323glo.mscc.api.SrcComparator;
import com.alex323glo.mscc.api.data.SourceCode;
import com.alex323glo.mscc.api.exception.SrcComparisonException;
import com.alex323glo.mscc.api.levels.ExtendedComparisonLevel;
import com.alex323glo.mscc.api.result.ComparisonResult;
import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * A single-thread implementation of Source Code Comparator service interface
 * (see more in SrcComparator docs.)
 *
 * @author Alexey_O
 * @version 0.1
 *
 * @see SrcComparator
 */
@AllArgsConstructor
public class SingleThreadSrcComparator implements SrcComparator {

    @NonNull private ComparisonLevel level1;
    @NonNull private ExtendedComparisonLevel level2;
    @NonNull private ComparisonLevel level3;
    @NonNull private ExtendedComparisonLevel level4;
    @NonNull private ComparisonLevel level5;

    /**
     * Compares 2 source codes and generates detailed comparison result data.
     *
     * @param text1 first target source code.
     * @param text2 second target source code.
     * @return detailed comparison result data (see ComparisonResult class docs).
     * @throws SrcComparisonException if some problems were occurred during comparison process.
     */
    @Override
    public ComparisonResult compare(SourceCode text1, SourceCode text2) throws SrcComparisonException {
        PartialResult firstLevelResult = level1.compare(text1, text2);

        ExtendedPartialResult secondLevelExtendedResult = level2.compare(text1, text2);

        PartialResult thirdLevelResult = level3.compare(secondLevelExtendedResult.getChangedText1(),
                secondLevelExtendedResult.getChangedText2());

        ExtendedPartialResult fourthLevelExtendedResult = level4.compare(secondLevelExtendedResult.getChangedText1(),
                secondLevelExtendedResult.getChangedText2());

        PartialResult fifthLevelResult = level5.compare(fourthLevelExtendedResult.getChangedText1(),
                fourthLevelExtendedResult.getChangedText2());

        return new ComparisonResult(
                firstLevelResult,
                secondLevelExtendedResult,
                thirdLevelResult,
                fourthLevelExtendedResult,
                fifthLevelResult
        );
    }
}
