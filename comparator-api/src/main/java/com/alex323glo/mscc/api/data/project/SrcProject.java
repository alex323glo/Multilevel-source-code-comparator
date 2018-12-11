package com.alex323glo.mscc.api.data.project;

import com.alex323glo.mscc.api.data.SourceCode;

import java.util.Map;

public interface SrcProject {

    Map<ProjectFileLocation, SourceCode> getFiles();

}
