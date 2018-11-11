package com.alex323glo.mscc.api.data;

import lombok.NonNull;

import java.util.List;

/**
 * Source code data model interface.
 *
 * @author Alexey_O
 * @version 0.1
 */
public interface SourceCode {

    int rowsCount();

    String getString();
    void setString(@NonNull String text);
    List<String> getList();
    void setList(@NonNull List<String> text);
    String[] getArray();
    void setArray(@NonNull String[] text);

    SourceCode copy();

}
