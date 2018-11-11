package com.alex323glo.mscc.api.levels;

import com.alex323glo.mscc.api.result.ExtendedPartialResult;
import com.alex323glo.mscc.api.data.SourceCode;
import lombok.NonNull;

/**
 * Extended comparison level interface, which interprets single layer of
 * source code pre-processing and comparison (with extended result data).
 * Can be used for functional interpretation of comparison process.
 *
 * @author Alexey_O
 * @version 0.1
 */
public interface ExtendedComparisonLevel {

    /**
     * Compares 2 source code instances and generates extended partial comparison result data.
     *
     * @param sourceCode1 first target source code.
     * @param sourceCode2 first target source code.
     * @return extended comparison result. See more in ExtendedPartialResult class docs.
     *
     * @see ExtendedPartialResult
     */
    ExtendedPartialResult compare(@NonNull SourceCode sourceCode1, @NonNull SourceCode sourceCode2);

}
