package com.edu.todo.data.model;

import com.google.gson.annotations.SerializedName;

public class BaseStatusPost {

    @SerializedName("status")
    private String status;

    public BaseStatusPost(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
