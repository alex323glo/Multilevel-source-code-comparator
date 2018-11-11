package com.alex323glo.mscc.api.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * General source codes' comparison result data model.
 *
 * Contains such comparison result data:
 *  - level_1..level_5 partial comparison results
 *  - (for more details see PartialResult class docs)
 *
 * @author Alexey_O
 * @version 0.1
 *
 * @see PartialResult
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
