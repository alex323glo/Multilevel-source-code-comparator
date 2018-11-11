package com.alex323glo.mscc.api.levels;

import com.alex323glo.mscc.api.result.ExtendedPartialResult;
import com.alex323glo.mscc.api.data.SourceCode;
import lombok.NonNull;

/**
 * TODO write doc!
 */
public interface ExtendedComparisonLevel {

    ExtendedPartialResult compare(@NonNull SourceCode sourceCode1, @NonNull SourceCode sourceCode2);

}
