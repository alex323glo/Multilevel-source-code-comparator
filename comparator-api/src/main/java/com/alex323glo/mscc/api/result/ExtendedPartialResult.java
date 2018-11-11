package com.alex323glo.mscc.api.result;

import com.alex323glo.mscc.api.data.SourceCode;
import lombok.*;

/**
 * Extended partial (level-scaled) result data model.
 *
 * Contains such comparison result data:
 *  - simple partial result data (see PartialResult class docs)
 *  - preprocessed variant of first text
 *  - preprocessed variant of second text
 *
 * @author Alexey_O
 * @version 0.1
 *
 * @see PartialResult
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ExtendedPartialResult extends PartialResult {

    private SourceCode changedText1;
    private SourceCode changedText2;

    public ExtendedPartialResult(int linesNumberInText1, int linesNumberInText2,
                                 int changesNumberInText1, int changesNumberInText2, int sequentialChangesNumber,
                                 SourceCode changedText1, SourceCode changedText2) {
        super(linesNumberInText1, linesNumberInText2, changesNumberInText1,
                changesNumberInText2, sequentialChangesNumber);
        this.changedText1 = changedText1;
        this.changedText2 = changedText2;
    }

    @Override
    public String toString() {
        return "ExtendedPartialResult{" +
                "changedText1=" + changedText1 +
                ", changedText2=" + changedText2 +
                "} " + super.toString();
    }
}
