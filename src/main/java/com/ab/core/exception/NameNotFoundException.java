package com.ab.core.exception;

/**
 * @author Arpit Bhardwaj
 *
 * Custom Checked Exception
 *
 * Checked – Extends java.lang.Exception, for recoverable condition, try-catch the exception explicitly, compile error.
 */
public class NameNotFoundException extends Exception {
    public NameNotFoundException(String message) {
        super(message);
    }
}
