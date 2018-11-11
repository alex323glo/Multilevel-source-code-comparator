package com.alex323glo.mscc.api.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO write doc!
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
