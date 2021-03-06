package com.zeus.common.exception;

/**
 * @author keven
 * @date 2018-01-10 下午10:18
 * @Description
 */
public class ParseException extends RuntimeException{

    private static final long serialVersionUID = -1912628225792148883L;

    private int status = 500;

    private String message = "unknown exception";

    public ParseException() {
    }

    public ParseException(String message) {
        this.message = message;
    }

    public ParseException(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ParseException(int status, String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.status = status;
    }

    public ParseException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public ParseException(int status, Throwable cause) {
        super(cause);
        this.message = cause.getMessage();
        this.status = status;
    }

    public ParseException(Throwable cause) {
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
