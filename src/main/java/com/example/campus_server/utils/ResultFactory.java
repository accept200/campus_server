package com.example.campus_server.utils;

public class ResultFactory {

    public static <T> Result<T> getSuccessResult() {
        Result<T> result = new Result<>();
        result.setCode(ResultType.SUCCESS);
        return result;
    }

    public static <T> Result<T> getSuccessResult(String message) {
        Result<T> result = new Result<>();
        result.setCode(ResultType.SUCCESS);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> getSuccessResult(String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultType.SUCCESS);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> getErrorResult() {
        Result<T> result = new Result<>();
        result.setCode(ResultType.ERROR);
        return result;
    }

    public static <T> Result<T> getErrorResult(String message) {
        Result<T> result = new Result<>();
        result.setCode(ResultType.ERROR);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> getErrorResult(String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultType.ERROR);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> getWarningResult() {
        Result<T> result = new Result<>();
        result.setCode(ResultType.WARNING);
        return result;
    }

    public static <T> Result<T> getWarningResult(String message) {
        Result<T> result = new Result<>();
        result.setCode(ResultType.WARNING);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> getWarningResult(String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultType.WARNING);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
