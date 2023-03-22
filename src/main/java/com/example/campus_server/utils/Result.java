package com.example.campus_server.utils;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private ResultType code;
    private String message;
    private T data;
    private final long timestamp = System.currentTimeMillis();

    public Result() {
        this.code = ResultType.SUCCESS;
        this.message = "";
        this.data = null;
    }

    public ResultType getCode() {
        return code;
    }

    public void setCode(ResultType code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
