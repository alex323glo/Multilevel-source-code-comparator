package com.alex323glo.mscc.singlethread.util;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Source code analysis utils container.
 *
 * @author Alexey_O
 * @version 0.1
 */
public class AnalysisUtils {
    /**
     * Searches for equal elements in list1 and list2.
     * It iterates through elements of source list (list1) and
     * tries to find equal element in list2 with order saving.
     * In each iteration it will iterate through elements of
     * target list (list2) and its current list (list1),
     * starting from the next index after the index of
     * the previous matched element.
     *
     * @param list1 source list
     * @param list2 target list
     *
     * @return total number of matches.
     */
    public static int searchEqualLinesInOrder(List<String> list1, List<String> list2,
                                              AtomicInteger nonMatchingSequencesCountOut) {

        int firstPosition = 0;
        int secondPosition = 0;
        int lineMatchesCount = 0;
        int lastMatchedSecondIndex = 0;
        int sequencesMatchesCount = 0;

        while (firstPosition < list1.size()) {

            while (secondPosition < list2.size()) {

                if (list1.get(firstPosition).equals(list2.get(secondPosition))) {

                    sequencesMatchesCount++;

                    do {
                        lastMatchedSecondIndex = secondPosition;
                        firstPosition++;
                        secondPosition++;
                        lineMatchesCount++;
                    } while (firstPosition < list1.size()
                            && secondPosition < list2.size()
                            && list1.get(firstPosition).equals(list2.get(secondPosition)));

                }

                secondPosition++;

            }

            firstPosition++;
            secondPosition = lastMatchedSecondIndex + 1;

        }

        nonMatchingSequencesCountOut.set(countNonMatchesSequence(list1, list2, sequencesMatchesCount));

        return lineMatchesCount;
    }

    /**
     * Counts number of non-matching row sequences.
     *
     * @param list1 first pre-processed row list.
     * @param list2 first pre-processed row list.
     * @param sequencesMatchesCount number of matching raw sequences.
     * @return number of non-matching row sequences
     */
    private static int countNonMatchesSequence(List<String> list1, List<String> list2, int sequencesMatchesCount) {
        if (sequencesMatchesCount < 1) {
            return 1;
        }

        int sequenceNonMatchesCount = sequencesMatchesCount - 1;

        if (!list1.get(0).equals(list2.get(0))) {
            sequenceNonMatchesCount++;
        }
        if (!list1.get(list1.size() - 1).equals(list2.get(list2.size() - 1))) {
            sequenceNonMatchesCount++;
        }

        return sequenceNonMatchesCount;
    }
}
