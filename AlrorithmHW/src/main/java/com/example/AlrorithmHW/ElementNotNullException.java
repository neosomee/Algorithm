package com.example.AlrorithmHW;

public class ElementNotNullException extends RuntimeException {
    public ElementNotNullException() {
    }

    public ElementNotNullException(String message) {
        super(message);
    }

    public ElementNotNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElementNotNullException(Throwable cause) {
        super(cause);
    }

    public ElementNotNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
