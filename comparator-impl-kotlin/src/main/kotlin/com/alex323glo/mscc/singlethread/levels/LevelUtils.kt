package com.alex323glo.mscc.singlethread.levels

import com.alex323glo.mscc.api.data.SourceCode
import com.alex323glo.mscc.api.result.ExtendedPartialResult
import com.alex323glo.mscc.api.result.PartialResult

/**
 * Searches for equal elements in list1 and list2.
 * It iterates through elements of source list (list1) and
 * tries to find equal element in list2 with order saving.
 * In each iteration it will iterate through elements of
 * target list (list2) and its current list (list1),
 * starting from the next index after the index of
 * the previous matched element.
 *
 * @param sourceCode1 first source code.
 * @param sourceCode2 second source code.
 *
 * @return match result (line matches number and sequence non-matches number).
 */
fun compareSourceCodes(sourceCode1: SourceCode, sourceCode2: SourceCode): MatchResult {
    val lineList1 = sourceCode1.list
    val lineList2 = sourceCode2.list

    var firstPosition = 0
    var secondPosition = 0
    var lineMatchesCount = 0
    var lastMatchedSecondIndex = 0
    var sequencesMatchesCount = 0

    while (firstPosition < lineList1.size) {

        while (secondPosition < lineList2.size) {

            if (lineList1[firstPosition] == lineList2[secondPosition]) {

                sequencesMatchesCount++

                do {
                    lastMatchedSecondIndex = secondPosition
                    firstPosition++
                    secondPosition++
                    lineMatchesCount++
                } while (firstPosition < lineList1.size
                        && secondPosition < lineList2.size
                        && lineList1[firstPosition] == lineList2[secondPosition])

            }

            secondPosition++

        }

        firstPosition++
        secondPosition = lastMatchedSecondIndex + 1

    }

    return MatchResult(
            sourceCode1.rowsCount() - lineMatchesCount,
            countNonMatchesSequence(lineList1, lineList2, sequencesMatchesCount)
    )
}

/**
 * Counts number of non-matching row sequences.
 *
 * @param list1 first pre-processed row list.
 * @param list2 first pre-processed row list.
 * @param sequencesMatchesCount number of matching raw sequences.
 * @return number of non-matching row sequences
 */
private fun countNonMatchesSequence(list1: List<String>, list2: List<String>, sequencesMatchesCount: Int): Int {
    if (sequencesMatchesCount < 1) {
        return 1
    }

    var sequenceNonMatchesCount = sequencesMatchesCount - 1

    if (list1[0] != list2[0]) {
        sequenceNonMatchesCount++
    }
    if (list1[list1.size - 1] != list2[list2.size - 1]) {
        sequenceNonMatchesCount++
    }

    return sequenceNonMatchesCount
}

fun simpleOfExtendedPartialResult(extendedPartialResult: ExtendedPartialResult): PartialResult =
        PartialResult(
                extendedPartialResult.linesNumberInText1,
                extendedPartialResult.linesNumberInText2,
                extendedPartialResult.changesNumberInText1,
                extendedPartialResult.changesNumberInText2,
                extendedPartialResult.sequentialChangesNumber
        )

/**
 * Stores result of match check.
 */
data class MatchResult(val lineNonMatchesCount: Int, val sequenceNonMatchesCount: Int)