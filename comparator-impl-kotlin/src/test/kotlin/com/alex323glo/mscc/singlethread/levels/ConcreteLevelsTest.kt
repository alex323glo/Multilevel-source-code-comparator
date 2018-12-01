package com.alex323glo.mscc.singlethread.levels

import com.alex323glo.mscc.api.data.SourceCode
import com.alex323glo.mscc.api.data.StringListSourceCode
import com.alex323glo.mscc.api.result.ExtendedPartialResult
import com.alex323glo.mscc.api.result.PartialResult
import org.junit.Assert.assertEquals
import org.junit.Test

class ConcreteLevelsTest {

    private lateinit var testSourceCode1: SourceCode
    private lateinit var testSourceCode2: SourceCode
    private lateinit var expectedSourceCode1: SourceCode
    private lateinit var expectedSourceCode2: SourceCode
    private lateinit var expectedResult: PartialResult
    private lateinit var actualResult: PartialResult

    @Test
    fun testRunLevel1() {
        testSourceCode1 = StringListSourceCode.ofFile(Level1Constants.SOURCE_CODE_PATH_1)
        testSourceCode2 = StringListSourceCode.ofFile(Level1Constants.SOURCE_CODE_PATH_2)
        expectedResult = PartialResult(
                Level1Constants.TEST_L1,
                Level1Constants.TEST_L2,
                Level1Constants.TEST_C1,
                Level1Constants.TEST_C2,
                Level1Constants.TEST_CN)
        actualResult = runLevel1(testSourceCode1, testSourceCode2)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun testRunLevel2() {
        testSourceCode1 = StringListSourceCode.ofFile(Level2Constants.SOURCE_CODE_PATH_1)
        testSourceCode2 = StringListSourceCode.ofFile(Level2Constants.SOURCE_CODE_PATH_2)
        expectedSourceCode1 = StringListSourceCode.ofFile(Level2Constants.EXPECTED_SOURCE_CODE_PATH_1)
        expectedSourceCode2 = StringListSourceCode.ofFile(Level2Constants.EXPECTED_SOURCE_CODE_PATH_2)
        expectedResult = ExtendedPartialResult(
                Level2Constants.TEST_L1,
                Level2Constants.TEST_L2,
                Level2Constants.TEST_C1,
                Level2Constants.TEST_C2,
                Level2Constants.TEST_CN,
                expectedSourceCode1,
                expectedSourceCode2)
        actualResult = runLevel2(testSourceCode1, testSourceCode2)
        assertEquals(expectedResult, actualResult)
        assertEquals(expectedSourceCode1, (actualResult as ExtendedPartialResult).changedText1)
        assertEquals(expectedSourceCode2, (actualResult as ExtendedPartialResult).changedText2)
    }

    @Test
    fun testRunLevel3() {
        testSourceCode1 = StringListSourceCode.ofFile(Level3Constants.PREPROCESSED_SOURCE_CODE_PATH_1)
        testSourceCode2 = StringListSourceCode.ofFile(Level3Constants.PREPROCESSED_SOURCE_CODE_PATH_2)
        expectedResult = PartialResult(
                Level3Constants.TEST_L1,
                Level3Constants.TEST_L2,
                Level3Constants.TEST_C1,
                Level3Constants.TEST_C2,
                Level3Constants.TEST_CN)
        actualResult = runLevel3(testSourceCode1, testSourceCode2)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun testRunLevel4() {
        testSourceCode1 = StringListSourceCode.ofFile(Level4Constants.PREPROCESSED_SOURCE_CODE_PATH_1)
        testSourceCode2 = StringListSourceCode.ofFile(Level4Constants.PREPROCESSED_SOURCE_CODE_PATH_2)
        expectedSourceCode1 = StringListSourceCode.ofFile(Level4Constants.EXPECTED_SOURCE_CODE_PATH_1)
        expectedSourceCode2 = StringListSourceCode.ofFile(Level4Constants.EXPECTED_SOURCE_CODE_PATH_2)
        expectedResult = ExtendedPartialResult(
                Level4Constants.TEST_L1,
                Level4Constants.TEST_L2,
                Level4Constants.TEST_C1,
                Level4Constants.TEST_C2,
                Level4Constants.TEST_CN,
                expectedSourceCode1,
                expectedSourceCode2)
        actualResult = runLevel4(testSourceCode1, testSourceCode2)
        assertEquals(expectedResult, actualResult)
        assertEquals(expectedSourceCode1, (actualResult as ExtendedPartialResult).changedText1)
        assertEquals(expectedSourceCode2, (actualResult as ExtendedPartialResult).changedText2)
    }

    @Test
    fun testRunLevel5() {
        testSourceCode1 = StringListSourceCode.ofFile(Level5Constants.PREPROCESSED_SOURCE_CODE_PATH_1)
        testSourceCode2 = StringListSourceCode.ofFile(Level5Constants.PREPROCESSED_SOURCE_CODE_PATH_2)
        expectedResult = PartialResult(
                Level5Constants.TEST_L1,
                Level5Constants.TEST_L2,
                Level5Constants.TEST_C1,
                Level5Constants.TEST_C2,
                Level5Constants.TEST_CN)
        actualResult = runLevel5(testSourceCode1, testSourceCode2)
        assertEquals(expectedResult, actualResult)
    }

    private object Level1Constants {
        const val SOURCE_CODE_PATH_1 = "build/resources/test/levels/level1/source_code_1.java"
        const val SOURCE_CODE_PATH_2 = "build/resources/test/levels/level1/source_code_2.java"
        const val TEST_L1 = 19
        const val TEST_L2 = 23
        const val TEST_C1 = 3
        const val TEST_C2 = 15
        const val TEST_CN = 3
    }

    private object Level2Constants {
        const val SOURCE_CODE_PATH_1 = "build/resources/test/levels/level2/source_code_1.java"
        const val SOURCE_CODE_PATH_2 = "build/resources/test/levels/level2/source_code_2.java"
        const val EXPECTED_SOURCE_CODE_PATH_1 ="build/resources/test/levels/level2/result_source_code_1.java"
        const val EXPECTED_SOURCE_CODE_PATH_2 ="build/resources/test/levels/level2/result_source_code_2.java"
        const val TEST_L1 = 15
        const val TEST_L2 = 19
        const val TEST_C1 = 3
        const val TEST_C2 = 14
        const val TEST_CN = 3
    }

    private object Level3Constants {
        const val PREPROCESSED_SOURCE_CODE_PATH_1 =
                "build/resources/test/levels/level3/preprocessed_source_code_1.java"
        const val PREPROCESSED_SOURCE_CODE_PATH_2 =
                "build/resources/test/levels/level3/preprocessed_source_code_2.java"
        const val TEST_L1 = 15
        const val TEST_L2 = 19
        const val TEST_C1 = 3
        const val TEST_C2 = 14
        const val TEST_CN = 3
    }

    private object Level4Constants {
        const val PREPROCESSED_SOURCE_CODE_PATH_1 =
                "build/resources/test/levels/level4/preprocessed_source_code_1.java"
        const val PREPROCESSED_SOURCE_CODE_PATH_2 =
                "build/resources/test/levels/level4/preprocessed_source_code_2.java"
        const val EXPECTED_SOURCE_CODE_PATH_1 =
                "build/resources/test/levels/level4/result_source_code_1.java"
        const val EXPECTED_SOURCE_CODE_PATH_2 =
                "build/resources/test/levels/level4/result_source_code_2.java"
        const val TEST_L1 = 29
        const val TEST_L2 = 29
        const val TEST_C1 = 0
        const val TEST_C2 = 0
        const val TEST_CN = 0
    }

    private object Level5Constants {
        const val PREPROCESSED_SOURCE_CODE_PATH_1 =
                "build/resources/test/levels/level5/preprocessed_source_code_1.java"
        const val PREPROCESSED_SOURCE_CODE_PATH_2 =
                "build/resources/test/levels/level5/preprocessed_source_code_2.java"
        const val TEST_L1 = 29
        const val TEST_L2 = 29
        const val TEST_C1 = 0
        const val TEST_C2 = 0
        const val TEST_CN = 0
    }
}