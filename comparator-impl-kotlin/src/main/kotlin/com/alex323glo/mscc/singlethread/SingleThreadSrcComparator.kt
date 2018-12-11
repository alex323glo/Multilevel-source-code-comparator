package com.alex323glo.mscc.singlethread

import com.alex323glo.mscc.api.SrcComparator
import com.alex323glo.mscc.api.data.SourceCode
import com.alex323glo.mscc.api.exception.SrcComparisonException
import com.alex323glo.mscc.api.result.ComparisonResult
import com.alex323glo.mscc.api.result.ExtendedPartialResult
import com.alex323glo.mscc.api.result.PartialResult
import com.alex323glo.mscc.singlethread.levels.*

class SingleThreadSrcComparator (private val level1: (SourceCode, SourceCode) -> PartialResult,
                                 private val level2: (SourceCode, SourceCode) -> ExtendedPartialResult,
                                 private val level3: (SourceCode, SourceCode) -> PartialResult,
                                 private val level4: (SourceCode, SourceCode) -> ExtendedPartialResult,
                                 private val level5: (SourceCode, SourceCode) -> PartialResult): SrcComparator {
    /**
     * Compares 2 source codes and generates detailed comparison result data.
     *
     * @param text1 first target source code.
     * @param text2 second target source code.
     * @return detailed comparison result data (see ComparisonResult class docs).
     * @throws SrcComparisonException if some problems were occurred during comparison process.
     */
    override fun compare(text1: SourceCode, text2: SourceCode): ComparisonResult {
        val result1 = level1(text1, text2)
        val result2 = level2(text1, text2)
        val result3 = level3(result2.changedText1, result2.changedText2)
        val result4 = level4(result2.changedText1, result2.changedText2)
        val result5 = level5(result4.changedText1, result4.changedText2)
        return ComparisonResult(result1, result2, result3, result4, result5)
    }

    companion object {
        @JvmStatic
        fun basic(): SingleThreadSrcComparator = SingleThreadSrcComparator(
                runLevel1,
                runLevel2,
                runLevel3,
                runLevel4,
                runLevel5
        )
    }
}