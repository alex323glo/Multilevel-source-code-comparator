package com.alex323glo.mscc.singlethread;

import com.alex323glo.mscc.api.SrcComparator;
import com.alex323glo.mscc.api.data.SourceCode;
import com.alex323glo.mscc.api.data.StringListSourceCode;
import com.alex323glo.mscc.api.exception.SrcComparisonException;
import com.alex323glo.mscc.api.levels.ComparisonLevel;
import com.alex323glo.mscc.api.levels.ExtendedComparisonLevel;
import com.alex323glo.mscc.api.result.ComparisonResult;
import com.alex323glo.mscc.api.result.ExtendedPartialResult;
import com.alex323glo.mscc.api.result.PartialResult;
import com.alex323glo.mscc.singlethread.levels.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class SingleThreadSrcComparatorTest {

    private SrcComparator srcComparator;

    private ComparisonLevel level1;
    private ExtendedComparisonLevel level2;
    private ComparisonLevel level3;
    private ExtendedComparisonLevel level4;
    private ComparisonLevel level5;

    private SourceCode testSourceCode1;
    private SourceCode testSourceCode2;

    private PartialResult expectedResultFromLevel1;
    private PartialResult expectedResultFromLevel2;
    private PartialResult expectedResultFromLevel3;
    private PartialResult expectedResultFromLevel4;
    private PartialResult expectedResultFromLevel5;

    private static final String TEST_SOURCE_CODE_PATH_1 = "build/resources/test/source_code_1.java";
    private static final String TEST_SOURCE_CODE_PATH_2 = "build/resources/test/source_code_2.java";
    private static final String LEVEL2_EXPECTED_SOURCE_CODE_PATH_1 =
            "build/resources/test/level2_result_source_code_1.java";
    private static final String LEVEL2_EXPECTED_SOURCE_CODE_PATH_2 =
            "build/resources/test/level2_result_source_code_2.java";
    private static final String LEVEL4_EXPECTED_SOURCE_CODE_PATH_1 =
            "build/resources/test/level4_result_source_code_1.java";
    private static final String LEVEL4_EXPECTED_SOURCE_CODE_PATH_2 =
            "build/resources/test/level4_result_source_code_2.java";

    private static final int LEVEL1_TEST_L1 = 19;
    private static final int LEVEL1_TEST_L2 = 23;
    private static final int LEVEL1_TEST_C1 = 3;
    private static final int LEVEL1_TEST_C2 = 19;
    private static final int LEVEL1_TEST_CN = 3;

    private static final int LEVEL2_TEST_L1 = 15;
    private static final int LEVEL2_TEST_L2 = 19;
    private static final int LEVEL2_TEST_C1 = 3;
    private static final int LEVEL2_TEST_C2 = 14;
    private static final int LEVEL2_TEST_CN = 3;

    private static final int LEVEL3_TEST_L1 = 15;
    private static final int LEVEL3_TEST_L2 = 19;
    private static final int LEVEL3_TEST_C1 = 3;
    private static final int LEVEL3_TEST_C2 = 14;
    private static final int LEVEL3_TEST_CN = 3;

    private static final int LEVEL4_TEST_L1 = 29;
    private static final int LEVEL4_TEST_L2 = 29;
    private static final int LEVEL4_TEST_C1 = 0;
    private static final int LEVEL4_TEST_C2 = 0;
    private static final int LEVEL4_TEST_CN = 0;

    private static final int LEVEL5_TEST_L1 = 29;
    private static final int LEVEL5_TEST_L2 = 29;
    private static final int LEVEL5_TEST_C1 = 0;
    private static final int LEVEL5_TEST_C2 = 0;
    private static final int LEVEL5_TEST_CN = 0;

    @Before
    public void setUp() throws IOException {
        StringListSourceCode level2ExpectedSourceCode1 =
                StringListSourceCode.ofFile(LEVEL2_EXPECTED_SOURCE_CODE_PATH_1);
        StringListSourceCode level2ExpectedSourceCode2 =
                StringListSourceCode.ofFile(LEVEL2_EXPECTED_SOURCE_CODE_PATH_2);
        StringListSourceCode level4ExpectedSourceCode1 =
                StringListSourceCode.ofFile(LEVEL4_EXPECTED_SOURCE_CODE_PATH_1);
        StringListSourceCode level4ExpectedSourceCode2 =
                StringListSourceCode.ofFile(LEVEL4_EXPECTED_SOURCE_CODE_PATH_2);

        expectedResultFromLevel1 = new PartialResult(LEVEL1_TEST_L1, LEVEL1_TEST_L2,
                LEVEL1_TEST_C1, LEVEL1_TEST_C2, LEVEL1_TEST_CN);
        expectedResultFromLevel2 = new ExtendedPartialResult(LEVEL2_TEST_L1, LEVEL2_TEST_L2,
                LEVEL2_TEST_C1, LEVEL2_TEST_C2, LEVEL2_TEST_CN,
                level2ExpectedSourceCode1, level2ExpectedSourceCode2);
        expectedResultFromLevel3 = new PartialResult(LEVEL3_TEST_L1, LEVEL3_TEST_L2,
                LEVEL3_TEST_C1, LEVEL3_TEST_C2, LEVEL3_TEST_CN);
        expectedResultFromLevel4 = new ExtendedPartialResult(LEVEL4_TEST_L1, LEVEL4_TEST_L2,
                LEVEL4_TEST_C1, LEVEL4_TEST_C2, LEVEL4_TEST_CN,
                level4ExpectedSourceCode1, level4ExpectedSourceCode2);
        expectedResultFromLevel5 = new PartialResult(LEVEL5_TEST_L1, LEVEL5_TEST_L2,
                LEVEL5_TEST_C1, LEVEL5_TEST_C2, LEVEL5_TEST_CN);

        level1 = new SingleThreadLevel1();
        level2 = new SingleThreadLevel2();
        level3 = new SingleThreadLevel3();
        level4 = new SingleThreadLevel4();
        level5 = new SingleThreadLevel5();

        srcComparator = new SingleThreadSrcComparator(level1, level2, level3, level4, level5);

        testSourceCode1 = StringListSourceCode.ofFile(TEST_SOURCE_CODE_PATH_1);
        testSourceCode2 = StringListSourceCode.ofFile(TEST_SOURCE_CODE_PATH_2);
    }

    @Test
    public void testCompare() throws SrcComparisonException {
        ComparisonResult actualResult = srcComparator.compare(testSourceCode1, testSourceCode2);

        assertEquals(expectedResultFromLevel1, actualResult.getResultFromLevel1());
        assertEquals(expectedResultFromLevel2, actualResult.getResultFromLevel2());
        assertEquals(expectedResultFromLevel3, actualResult.getResultFromLevel3());
        assertEquals(expectedResultFromLevel4, actualResult.getResultFromLevel4());
        assertEquals(expectedResultFromLevel5, actualResult.getResultFromLevel5());
    }
}