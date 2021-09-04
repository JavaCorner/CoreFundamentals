package com.ab.core.exception;

/**
 * @author Arpit Bhardwaj
 *
 * Custom Runtime Exception
 * Unchecked – Extends java.lang.RuntimeException, for unrecoverable condition, like programming errors, no need try-catch, runtime error.
 */
public class ListTooLargeException extends RuntimeException {

    public ListTooLargeException(String message) {
        super(message);
    }

    public ListTooLargeException(String message,Throwable e) {
        super(message,e);
    }
}
