package com.alex323glo.mscc.singlethread.levels;

import com.alex323glo.mscc.api.data.SourceCode;
import com.alex323glo.mscc.api.data.StringListSourceCode;

import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Realisation of first level of source code comparison level abstraction.
 *
 * Main logic is to remove all "null" lines on pre-processing stage and then
 * compare 2 source code instances (see more on comparison process in AnalysisUtils class docs).
 *
 * @author Alexey_O
 * @version 0.1
 *
 * @see com.alex323glo.mscc.singlethread.util.AnalysisUtils
 */
public class SingleThreadLevel1 extends AbstractSingleThreadLevel {

    /**
     * Pre-processes source code before comparison process.
     * Can be specific for concrete level implementation.
     *
     * @param sourceCode target rows list for pre-processing.
     * @return preprocessed copy of target source code.
     */
    @Override
    protected SourceCode preProcessSourceCode(SourceCode sourceCode) {
        return new StringListSourceCode(sourceCode.getList().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
    }
}
