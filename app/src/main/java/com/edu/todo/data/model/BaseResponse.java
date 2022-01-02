package com.edu.todo.data.model;

import com.google.gson.annotations.SerializedName;

public class BaseResponse<T> {

    @SerializedName("data")
    private final T data;

    public BaseResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
