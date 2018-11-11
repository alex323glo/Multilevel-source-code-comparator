package com.alex323glo.mscc.api.exception;

/**
 * Special checked exception related to Source Code comparison operations.
 *
 * @author Alexey_O
 * @version 0.1
 */
public class SrcComparisonException extends Exception {

    public SrcComparisonException(String message) {
        super(message);
    }

    public SrcComparisonException(String message, Throwable cause) {
        super(message, cause);
    }

    public SrcComparisonException(Throwable cause) {
        super(cause);
    }
}
