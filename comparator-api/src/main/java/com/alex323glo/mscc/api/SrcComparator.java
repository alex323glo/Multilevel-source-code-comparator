package com.alex323glo.mscc.api;

import com.alex323glo.mscc.api.data.SourceCode;
import com.alex323glo.mscc.api.result.ComparisonResult;
import com.alex323glo.mscc.api.exception.SrcComparisonException;
import lombok.NonNull;

/**
 * Main interface for Source Code Comparator service.
 *
 * @author Alexey_O
 * @version 0.1
 *
 * @see SourceCode
 * @see ComparisonResult
 * @see SrcComparisonException
 */
public interface SrcComparator {

    /**
     * Compares 2 source codes and generates detailed comparison result data.
     *
     * @param text1 first target source code.
     * @param text2 second target source code.
     * @return detailed comparison result data (see ComparisonResult class docs).
     * @throws SrcComparisonException if some problems were occurred during comparison process.
     */
    ComparisonResult compare(@NonNull SourceCode text1, @NonNull SourceCode text2)
            throws SrcComparisonException;

}
