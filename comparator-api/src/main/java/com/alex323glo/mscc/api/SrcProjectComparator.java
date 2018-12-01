package com.alex323glo.mscc.api;

import com.alex323glo.mscc.api.data.project.ProjectOptions;
import com.alex323glo.mscc.api.data.project.SrcProject;
import com.alex323glo.mscc.api.result.ComparisonResult;
import com.alex323glo.mscc.api.result.project.PairDiffKey;

import java.util.Map;
import java.util.Set;

/**
 * Main interface for Project's Src Comparator service.
 *
 * @author Alexey_O
 * @version 0.1
 *
 * @see SrcProject
 */
public interface SrcProjectComparator {

    /**
     * Compares projects by such strategy:
     *  1. Makes all possible pair combination's of projects' files
     *  (each pair must contain one file from project_1 and one file from project_2).
     *  2. Makes "pair diff" for each files pair.
     *  3. Collects comparison results for each files pair into one map, where key is
     *  pair's comparison meta (mostly contains identification data).
     *
     * @param srcProject1 first target project.
     * @param srcProject2 first target project.
     * @param options projects' options (excluded file types, additional comparison params, etc.)
     * @return map, where Key - comparison short meta (or identification) and Value - comparison result.
     */
    Map<PairDiffKey, ComparisonResult> compareAsAllFilePairs(SrcProject srcProject1,
                                                             SrcProject srcProject2,
                                                             Set<ProjectOptions> options);

    /**
     * Compares projects by such strategy:
     *  1. Combines each project's files into "super-documents"
     *  2. Compares two "super-documents" (generated in prev step) as two Source Code files.
     *  3. Collects comparison result
     *
     * @param srcProject1 first target project.
     * @param srcProject2 first target project.
     * @param options projects' options (excluded file types, additional comparison params, etc.)
     * @return comparison result of projects' "super-documents"
     */
    ComparisonResult compareAsDocuments(SrcProject srcProject1,
                                        SrcProject srcProject2,
                                        Set<ProjectOptions> options);
}
