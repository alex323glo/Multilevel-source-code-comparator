package com.alex323glo.mscc.singlethread

import com.alex323glo.mscc.api.SrcComparator
import com.alex323glo.mscc.api.SrcProjectComparator
import com.alex323glo.mscc.api.data.SourceCode
import com.alex323glo.mscc.api.data.StringListSourceCode
import com.alex323glo.mscc.api.data.project.options.ProjectOptions
import com.alex323glo.mscc.api.data.project.SrcProject
import com.alex323glo.mscc.api.result.ComparisonResult
import com.alex323glo.mscc.api.result.project.PairDiffKey

class SingleThreadSrcProjectComparator (
        private val srcComparator: SrcComparator
): SrcProjectComparator {

    override fun compareAsAllFilePairs(srcProject1: SrcProject, srcProject2: SrcProject,
            options: MutableSet<ProjectOptions>): MutableMap<PairDiffKey, ComparisonResult> {
        val resultMap = srcProject1.files.asSequence()
                .flatMap { (thatSrcPos, thatSrc) ->
                    val map = srcProject2.files.asSequence()
                            .associate { (thisSrcPos, thisSrc) ->
                                val comparisonResult = srcComparator.compare(thisSrc, thatSrc)
                                (PairDiffKey(thisSrcPos, thatSrcPos) to comparisonResult)
                            }
                    map.asSequence()
                }
                .associate { Pair(it.key, it.value) }

        return resultMap.toMutableMap()
    }

    override fun compareAsDocuments(
            srcProject1: SrcProject,
            srcProject2: SrcProject,
            options: MutableSet<ProjectOptions>
    ): ComparisonResult {
        val superDocument1 = wrapSupperDocument(srcProject1)
        val superDocument2 = wrapSupperDocument(srcProject2)
        return srcComparator.compare(superDocument1, superDocument2)
    }

    private fun wrapSupperDocument(srcProject: SrcProject): SourceCode =
            StringListSourceCode(assembleSuperDocumentLines(srcProject))

    private fun assembleSuperDocumentLines(srcProject: SrcProject): List<String> {
        return srcProject.files.asSequence()
                .map { (srcPos, src) ->
                    val srcLineList = mutableListOf(
                            separatorStart(),
                            "name: ${srcPos.fileName}",
                            "package: ${srcPos.filePackage}",
                            "path: ${srcPos.fullFilePath}",
                            separatorEnd()
                    )
                    srcLineList.addAll(src.list)
                    srcLineList
                }
                .reduce { acc, result ->
                    acc.addAll(result)
                    acc
                }
    }

    companion object {
        @JvmStatic
        fun basic(): SingleThreadSrcProjectComparator = SingleThreadSrcProjectComparator(
                SingleThreadSrcComparator.basic()
        )

        @JvmStatic
        private fun separatorStart(): String = ">".repeat(70)

        @JvmStatic
        private fun separatorEnd(): String = "<".repeat(70)
    }
}