package com.alex323glo.mscc.singlethread.levels;

import com.alex323glo.mscc.api.data.SourceCode;

/**
 * Source code preprocessor abstraction.
 *
 * @author Alexey_O
 * @version 0.1
 */
public abstract class AbstractSourceCodePreprocessor {

    /**
     * Pre-processes source code before comparison process.
     * Can be specific for concrete level implementation.
     *
     * @param sourceCode target rows list for pre-processing.
     * @return preprocessed copy of target source code.
     */
    protected abstract SourceCode preProcessSourceCode(SourceCode sourceCode);

}
