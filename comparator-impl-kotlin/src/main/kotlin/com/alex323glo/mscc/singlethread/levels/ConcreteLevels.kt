package com.alex323glo.mscc.singlethread.levels

import com.alex323glo.mscc.api.data.SourceCode
import com.alex323glo.mscc.api.data.StringListSourceCode
import com.alex323glo.mscc.api.result.ExtendedPartialResult
import com.alex323glo.mscc.api.result.PartialResult

private const val REPEATED_SPACES_PATTERN = "^ +| +$|( )+"

private const val ALPHANUMERIC_SEQUENCES_PATTERN = "([a-zA-Z0-9]+)"
private const val SURROGATE_STRING = "X"

private const val MULTILINE_COMMENT_PATTERN = "(/\\*(.|[\\r\\n])*?\\*/)"
private const val SINGLE_LINE_COMMENT_PATTERN = "([/][/].*)"
private const val LINE_SEPARATOR = "\\s"

val runLevel1: (SourceCode, SourceCode) -> PartialResult = level { sourceCode ->
    StringListSourceCode(sourceCode.list.filter { it != null})
}

val runLevel2: (SourceCode, SourceCode) -> ExtendedPartialResult = extendedLevel { sourceCode ->
    StringListSourceCode(
            sourceCode.list
                    .filter { (it != null && !it.isEmpty()) }
                    .map { it.replace(REPEATED_SPACES_PATTERN, "") }
                    .map { it.toLowerCase() }
    )
}

val runLevel3: (SourceCode, SourceCode) -> PartialResult = level { sourceCode ->
    StringListSourceCode(
            sourceCode.list
                    .map { it.replace(ALPHANUMERIC_SEQUENCES_PATTERN.toRegex(), SURROGATE_STRING) }
    )
}

val runLevel4: (SourceCode, SourceCode) -> ExtendedPartialResult = extendedLevel { sourceCode ->
    StringListSourceCode(
            sourceCode.string
                    .replace(MULTILINE_COMMENT_PATTERN.toRegex(), "")
                    .replace(SINGLE_LINE_COMMENT_PATTERN.toRegex(), "")
                    .split(LINE_SEPARATOR.toRegex())
                    .filter { !it.isEmpty() }
    )
}

val runLevel5: (SourceCode, SourceCode) -> PartialResult = level { sourceCode ->
    StringListSourceCode(sourceCode.list.sorted())
}