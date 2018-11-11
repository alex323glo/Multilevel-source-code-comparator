package com.alex323glo.mscc.singlethread.levels;

import com.alex323glo.mscc.api.data.SourceCode;
import com.alex323glo.mscc.api.data.StringListSourceCode;

import java.util.stream.Collectors;

/**
 * Realisation of second level of source code comparison level abstraction.
 *
 * Main logic is to remove all "null" and blank lines and repeated "spaces" on pre-processing stage and then
 * compare 2 source code instances (see more on comparison process in AnalysisUtils class docs).
 *
 * @author Alexey_O
 * @version 0.1
 *
 * @see com.alex323glo.mscc.singlethread.util.AnalysisUtils
 */
public class SingleThreadLevel2 extends AbstractExtendedSingleThreadLevel {

    private static final String REPEATED_SPACES_PATTERN = "^ +| +$|( )+";

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
                .filter(row -> (row != null && !row.isEmpty()))
                .map(row -> row.replace(REPEATED_SPACES_PATTERN, " "))
                .map(String::toLowerCase)
                .collect(Collectors.toList()));
    }
}
