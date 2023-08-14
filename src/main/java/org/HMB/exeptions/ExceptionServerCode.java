package org.HMB.exeptions;

public class ExceptionServerCode extends RuntimeException{

    public ExceptionServerCode(String message) {
        super(message);
    }

    public ExceptionServerCode(String message, Throwable cause) {
        super(message, cause);
    }
}
