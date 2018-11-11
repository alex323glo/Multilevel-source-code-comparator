package com.alex323glo.mscc.api.levels;

import com.alex323glo.mscc.api.result.PartialResult;
import com.alex323glo.mscc.api.data.SourceCode;
import lombok.NonNull;

/**
 * Simple comparison level interface, which interprets single layer of
 * source code pre-processing and comparison.
 * Can be used for functional interpretation of comparison process.
 *
 * @author Alexey_O
 * @version 0.1
 */
public interface ComparisonLevel {

    /**
     * Compares 2 source code instances and generates simple partial comparison result data.
     *
     * @param sourceCode1 first target source code.
     * @param sourceCode2 first target source code.
     * @return simple comparison result. See more in PartialResult class docs.
     *
     * @see PartialResult
     */
    PartialResult compare(@NonNull SourceCode sourceCode1, @NonNull SourceCode sourceCode2);

}
