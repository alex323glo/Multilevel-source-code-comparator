package com.alex323glo.mscc.api.data;

import lombok.NonNull;

import java.util.List;

/**
 * TODO write doc!
 */
public interface SourceCode {

    String getString();
    void setString(@NonNull String text);
    List<String> getList();
    void setList(@NonNull List<String> text);
    String[] getArray();
    void setArray(@NonNull String[] text);

    SourceCode copy();

}
