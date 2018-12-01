package com.alex323glo.mscc.singlethread.levels

import com.alex323glo.mscc.api.data.SourceCode
import com.alex323glo.mscc.api.result.ExtendedPartialResult
import com.alex323glo.mscc.api.result.PartialResult
import java.lang.Math.min

fun level(preprocessor: (SourceCode) -> SourceCode): (SourceCode, SourceCode) -> PartialResult =
        { text1, text2 ->
            val extendedPartialResult = extendedLevel(preprocessor)(text1, text2)
            simpleOfExtendedPartialResult(extendedPartialResult)
        }

fun extendedLevel(preprocessor: (SourceCode) -> SourceCode): (SourceCode, SourceCode) -> ExtendedPartialResult =
        { text1, text2 ->
            val processedText1 = preprocessor(text1)
            val processedText2 = preprocessor(text2)

            val secondToFirst = compareSourceCodes(processedText1, processedText2)
            val firstToSecond = compareSourceCodes(processedText2, processedText1)

            ExtendedPartialResult(
                    processedText1.rowsCount(),
                    processedText2.rowsCount(),
                    secondToFirst.lineNonMatchesCount,
                    firstToSecond.lineNonMatchesCount,
                    min(secondToFirst.sequenceNonMatchesCount, firstToSecond.sequenceNonMatchesCount),
                    processedText1,
                    processedText2
            )
        }