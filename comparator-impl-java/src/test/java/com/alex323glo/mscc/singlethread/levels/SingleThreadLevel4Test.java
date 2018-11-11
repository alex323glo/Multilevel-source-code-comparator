package com.alex323glo.mscc.singlethread.levels;

import com.alex323glo.mscc.api.data.SourceCode;
import com.alex323glo.mscc.api.data.StringListSourceCode;
import com.alex323glo.mscc.api.levels.ExtendedComparisonLevel;
import com.alex323glo.mscc.api.result.ExtendedPartialResult;
import com.alex323glo.mscc.api.result.PartialResult;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class SingleThreadLevel4Test {
    private ExtendedComparisonLevel level4;

    private SourceCode testSourceCode1;
    private SourceCode testSourceCode2;
    private PartialResult expectedResult;

    private static final String PREPROCESSED_SOURCE_CODE_PATH_1 =
            "build/resources/test/levels/level4/preprocessed_source_code_1.java";
    private static final String PREPROCESSED_SOURCE_CODE_PATH_2 =
            "build/resources/test/levels/level4/preprocessed_source_code_2.java";
    private static final String EXPECTED_SOURCE_CODE_PATH_1 =
            "build/resources/test/levels/level4/result_source_code_1.java";
    private static final String EXPECTED_SOURCE_CODE_PATH_2 =
            "build/resources/test/levels/level4/result_source_code_2.java";

    private static final int TEST_L1 = 29;
    private static final int TEST_L2 = 29;
    private static final int TEST_C1 = 0;
    private static final int TEST_C2 = 0;
    private static final int TEST_CN = 0;

    @Before
    public void setUp() throws IOException {
        StringListSourceCode expectedSourceCode1 = StringListSourceCode.ofFile(EXPECTED_SOURCE_CODE_PATH_1);
        StringListSourceCode expectedSourceCode2 = StringListSourceCode.ofFile(EXPECTED_SOURCE_CODE_PATH_2);
        expectedResult = new ExtendedPartialResult(TEST_L1, TEST_L2, TEST_C1, TEST_C2, TEST_CN,
                expectedSourceCode1, expectedSourceCode2);

        level4 = new SingleThreadLevel4();
        testSourceCode1 = StringListSourceCode.ofFile(PREPROCESSED_SOURCE_CODE_PATH_1);
        testSourceCode2 = StringListSourceCode.ofFile(PREPROCESSED_SOURCE_CODE_PATH_2);
    }

    @Test
    public void testCompare() {
        PartialResult actualResult = level4.compare(testSourceCode1, testSourceCode2);
        assertEquals(expectedResult, actualResult);
    }
}