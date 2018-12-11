package com.alex323glo.mscc.singlethread

import com.alex323glo.mscc.api.SrcProjectComparator
import com.alex323glo.mscc.api.data.project.SrcProject
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

// TODO complete ...
class SingleThreadSrcProjectComparatorTest {

    lateinit var srcProjectComparator: SrcProjectComparator
    lateinit var testProject1: SrcProject
    lateinit var testProject2: SrcProject

    @Before
    fun setUp() {
        srcProjectComparator = SingleThreadSrcProjectComparator.basic()
    }

    @Test
    fun compareAsAllFilePairs() {
    }

    @Test
    fun compareAsDocuments() {
    }
}