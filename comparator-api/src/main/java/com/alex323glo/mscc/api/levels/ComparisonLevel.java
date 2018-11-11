package com.alex323glo.mscc.api.levels;

import com.alex323glo.mscc.api.result.PartialResult;
import com.alex323glo.mscc.api.data.SourceCode;
import lombok.NonNull;

/**
 * TODO write doc!
 */
public interface ComparisonLevel {

    /**
     * TODO write doc!
     *
     * @param sourceCode1
     * @param sourceCode2
     * @return
     */
    PartialResult compare(@NonNull SourceCode sourceCode1, @NonNull SourceCode sourceCode2);

}
