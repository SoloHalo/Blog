package com.cql.blog.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by CQL on 2017/8/23.
 */

public class BlogResponse<T> {
    private int code;
    @SerializedName(value = "result" ,alternate = "data")
    private T result;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return result != null && code == 0;
    }
}
