package com.alex323glo.mscc.singlethread

import com.alex323glo.mscc.api.SrcComparator
import com.alex323glo.mscc.api.data.SourceCode
import com.alex323glo.mscc.api.data.StringListSourceCode
import com.alex323glo.mscc.api.result.ExtendedPartialResult
import com.alex323glo.mscc.api.result.PartialResult
import com.alex323glo.mscc.singlethread.levels.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.IOException

class SingleThreadSrcComparatorTest {

    private lateinit var srcComparator: SrcComparator

    private lateinit var testSourceCode1: SourceCode
    private lateinit var testSourceCode2: SourceCode

    private lateinit var expectedResultFromLevel1: PartialResult
    private lateinit var expectedResultFromLevel2: PartialResult
    private lateinit var expectedResultFromLevel3: PartialResult
    private lateinit var expectedResultFromLevel4: PartialResult
    private lateinit var expectedResultFromLevel5: PartialResult

    @Before
    @Throws(IOException::class)
    fun setUp() {
        val level2ExpectedSourceCode1 = StringListSourceCode.ofFile(LEVEL2_EXPECTED_SOURCE_CODE_PATH_1)
        val level2ExpectedSourceCode2 = StringListSourceCode.ofFile(LEVEL2_EXPECTED_SOURCE_CODE_PATH_2)
        val level4ExpectedSourceCode1 = StringListSourceCode.ofFile(LEVEL4_EXPECTED_SOURCE_CODE_PATH_1)
        val level4ExpectedSourceCode2 = StringListSourceCode.ofFile(LEVEL4_EXPECTED_SOURCE_CODE_PATH_2)

        expectedResultFromLevel1 = PartialResult(LEVEL1_TEST_L1, LEVEL1_TEST_L2,
                LEVEL1_TEST_C1, LEVEL1_TEST_C2, LEVEL1_TEST_CN)
        expectedResultFromLevel2 = ExtendedPartialResult(LEVEL2_TEST_L1, LEVEL2_TEST_L2,
                LEVEL2_TEST_C1, LEVEL2_TEST_C2, LEVEL2_TEST_CN,
                level2ExpectedSourceCode1, level2ExpectedSourceCode2)
        expectedResultFromLevel3 = PartialResult(LEVEL3_TEST_L1, LEVEL3_TEST_L2,
                LEVEL3_TEST_C1, LEVEL3_TEST_C2, LEVEL3_TEST_CN)
        expectedResultFromLevel4 = ExtendedPartialResult(LEVEL4_TEST_L1, LEVEL4_TEST_L2,
                LEVEL4_TEST_C1, LEVEL4_TEST_C2, LEVEL4_TEST_CN,
                level4ExpectedSourceCode1, level4ExpectedSourceCode2)
        expectedResultFromLevel5 = PartialResult(LEVEL5_TEST_L1, LEVEL5_TEST_L2,
                LEVEL5_TEST_C1, LEVEL5_TEST_C2, LEVEL5_TEST_CN)

        srcComparator = SingleThreadSrcComparator(runLevel1, runLevel2, runLevel3, runLevel4, runLevel5)

        testSourceCode1 = StringListSourceCode.ofFile(TEST_SOURCE_CODE_PATH_1)
        testSourceCode2 = StringListSourceCode.ofFile(TEST_SOURCE_CODE_PATH_2)
    }

    @Test
    fun testCompare() {
        val actualResult = srcComparator.compare(testSourceCode1, testSourceCode2)

        assertEquals(expectedResultFromLevel1, actualResult.resultFromLevel1)
        assertEquals(expectedResultFromLevel2, actualResult.resultFromLevel2)
        assertEquals(expectedResultFromLevel3, actualResult.resultFromLevel3)
        assertEquals(expectedResultFromLevel4, actualResult.resultFromLevel4)
        assertEquals(expectedResultFromLevel5, actualResult.resultFromLevel5)
    }

    companion object {
        private const val TEST_SOURCE_CODE_PATH_1 = "build/resources/test/source_code_1.java"
        private const val TEST_SOURCE_CODE_PATH_2 = "build/resources/test/source_code_2.java"
        private const val LEVEL2_EXPECTED_SOURCE_CODE_PATH_1 = "build/resources/test/level2_result_source_code_1.java"
        private const val LEVEL2_EXPECTED_SOURCE_CODE_PATH_2 = "build/resources/test/level2_result_source_code_2.java"
        private const val LEVEL4_EXPECTED_SOURCE_CODE_PATH_1 = "build/resources/test/level4_result_source_code_1.java"
        private const val LEVEL4_EXPECTED_SOURCE_CODE_PATH_2 = "build/resources/test/level4_result_source_code_2.java"

        private const val LEVEL1_TEST_L1 = 19
        private const val LEVEL1_TEST_L2 = 23
        private const val LEVEL1_TEST_C1 = 3
        private const val LEVEL1_TEST_C2 = 15
        private const val LEVEL1_TEST_CN = 3

        private const val LEVEL2_TEST_L1 = 15
        private const val LEVEL2_TEST_L2 = 19
        private const val LEVEL2_TEST_C1 = 3
        private const val LEVEL2_TEST_C2 = 14
        private const val LEVEL2_TEST_CN = 3

        private const val LEVEL3_TEST_L1 = 15
        private const val LEVEL3_TEST_L2 = 19
        private const val LEVEL3_TEST_C1 = 3
        private const val LEVEL3_TEST_C2 = 14
        private const val LEVEL3_TEST_CN = 3

        private const val LEVEL4_TEST_L1 = 29
        private const val LEVEL4_TEST_L2 = 29
        private const val LEVEL4_TEST_C1 = 0
        private const val LEVEL4_TEST_C2 = 0
        private const val LEVEL4_TEST_CN = 0

        private const val LEVEL5_TEST_L1 = 29
        private const val LEVEL5_TEST_L2 = 29
        private const val LEVEL5_TEST_C1 = 0
        private const val LEVEL5_TEST_C2 = 0
        private const val LEVEL5_TEST_CN = 0
    }
}