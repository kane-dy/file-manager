package com.file.manager.utils;

public class Result<T>{
    private int code;      // 200 成功, 500 失败
    private String msg;    // 提示信息
    private T data;        // 实际数据


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS, data);
    }

    // 2. 灵活的错误方法：可以根据不同情况传不同的枚举
    public static <T> Result<T> error(ResultCode resultCode) {
        return new Result<>(resultCode, null);
    }


    public static <T> Result<T> messageInfor(int code, String message) {
        return new Result<>(code,message, null);
    }

    public static <T> Result<T> messageInfor(int code, String message, T data) {
        return new Result<>(code,message, data);
    }
    // 私有构造器，强制使用静态方法创建
    private Result(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
        this.data = data;
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
