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

public class SingleThreadLevel2Test {
    private ExtendedComparisonLevel level2;

    private SourceCode testSourceCode1;
    private SourceCode testSourceCode2;
    private PartialResult expectedResult;

    private static final String SOURCE_CODE_PATH_1 = "build/resources/test/levels/level2/source_code_1.java";
    private static final String SOURCE_CODE_PATH_2 = "build/resources/test/levels/level2/source_code_2.java";
    private static final String EXPECTED_SOURCE_CODE_PATH_1 =
            "build/resources/test/levels/level2/result_source_code_1.java";
    private static final String EXPECTED_SOURCE_CODE_PATH_2 =
            "build/resources/test/levels/level2/result_source_code_2.java";


    private static final int TEST_L1 = 15;
    private static final int TEST_L2 = 19;
    private static final int TEST_C1 = 3;
    private static final int TEST_C2 = 14;
    private static final int TEST_CN = 3;

    @Before
    public void setUp() throws IOException {
        SourceCode expectedSourceCode1 = StringListSourceCode.ofFile(EXPECTED_SOURCE_CODE_PATH_1);
        SourceCode expectedSourceCode2 = StringListSourceCode.ofFile(EXPECTED_SOURCE_CODE_PATH_2);
        expectedResult = new ExtendedPartialResult(TEST_L1, TEST_L2, TEST_C1, TEST_C2, TEST_CN,
                expectedSourceCode1, expectedSourceCode2);

        level2 = new SingleThreadLevel2();
        testSourceCode1 = StringListSourceCode.ofFile(SOURCE_CODE_PATH_1);
        testSourceCode2 = StringListSourceCode.ofFile(SOURCE_CODE_PATH_2);
    }

    @Test
    public void testCompare() {
        PartialResult actualResult = level2.compare(testSourceCode1, testSourceCode2);
        assertEquals(expectedResult, actualResult);
    }
}