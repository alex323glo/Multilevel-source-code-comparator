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
public class ComparisonResult {

    PartialResult resultFromLevel1;
    PartialResult resultFromLevel2;
    PartialResult resultFromLevel3;
    PartialResult resultFromLevel4;
    PartialResult resultFromLevel5;

}
