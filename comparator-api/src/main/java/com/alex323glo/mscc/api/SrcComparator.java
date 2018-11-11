package com.alex323glo.mscc.api;

import com.alex323glo.mscc.api.data.SourceCode;
import com.alex323glo.mscc.api.result.ComparisonResult;
import com.alex323glo.mscc.api.exception.SrcComparisonException;
import lombok.NonNull;

/**
 * TODO write doc!
 */
public interface SrcComparator {

    ComparisonResult compare(@NonNull SourceCode text1, @NonNull SourceCode text2)
            throws SrcComparisonException;

}
