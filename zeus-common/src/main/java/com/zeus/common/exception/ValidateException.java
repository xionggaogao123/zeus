package com.zeus.common.exception;

/**
 * @author keven
 * @date 2018-01-10 下午10:23
 * @Description
 */
public class ValidateException extends RuntimeException{

    private static final long serialVersionUID = -8381089107433026015L;

    private int status = 500;

    private String message = "unknown exception";

    public ValidateException() {
    }

    public ValidateException(String message) {
        this.message = message;
    }

    public ValidateException(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ValidateException(int status, String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.status = status;
    }

    public ValidateException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public ValidateException(int status, Throwable cause) {
        super(cause);
        this.message = cause.getMessage();
        this.status = status;
    }

    public ValidateException(Throwable cause) {
        super(cause);
        this.message = cause.getMessage();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
