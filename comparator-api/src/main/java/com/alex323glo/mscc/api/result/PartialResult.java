package com.alex323glo.mscc.api.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Partial (level-scaled) result data model.
 *
 * Contains such comparison result data:
 *  - number of lines, received after pre-processing of first text
 *  - number of lines, received after pre-processing of second text
 *  - number of changes, needed to be done in first text (to be equal to second text)
 *  - number of changes, needed to be done in second text (to be equal to first text)
 *  - efficient number of sequential changes (number of line sequences to change), needed
 *  to be done to make texts equal
 *
 * @author Alexey_O
 * @version 0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartialResult {

    private int linesNumberInText1;
    private int linesNumberInText2;
    private int changesNumberInText1;
    private int changesNumberInText2;
    private int sequentialChangesNumber;

}
