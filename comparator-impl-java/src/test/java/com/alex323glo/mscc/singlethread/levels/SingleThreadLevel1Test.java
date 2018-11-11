package com.alex323glo.mscc.singlethread.levels;

import com.alex323glo.mscc.api.data.SourceCode;
import com.alex323glo.mscc.api.data.StringListSourceCode;
import com.alex323glo.mscc.api.levels.ComparisonLevel;
import com.alex323glo.mscc.api.result.PartialResult;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class SingleThreadLevel1Test {

    private ComparisonLevel level1;

    private SourceCode testSourceCode1;
    private SourceCode testSourceCode2;
    private PartialResult expectedResult;

    private static final String SOURCE_CODE_PATH_1 = "build/resources/test/levels/level1/source_code_1.java";
    private static final String SOURCE_CODE_PATH_2 = "build/resources/test/levels/level1/source_code_2.java";

    private static final int TEST_L1 = 19;
    private static final int TEST_L2 = 23;
    private static final int TEST_C1 = 3;
    private static final int TEST_C2 = 15;
    private static final int TEST_CN = 3;

    @Before
    public void setUp() throws IOException {
        level1 = new SingleThreadLevel1();

        testSourceCode1 = StringListSourceCode.ofFile(SOURCE_CODE_PATH_1);
        testSourceCode2 = StringListSourceCode.ofFile(SOURCE_CODE_PATH_2);
        expectedResult = new PartialResult(TEST_L1, TEST_L2, TEST_C1, TEST_C2, TEST_CN);
    }

    @Test
    public void testCompare() {
        PartialResult actualResult = level1.compare(testSourceCode1, testSourceCode2);
        assertEquals(expectedResult, actualResult);
    }
}