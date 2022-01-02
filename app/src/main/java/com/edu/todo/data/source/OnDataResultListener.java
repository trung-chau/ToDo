package com.edu.todo.data.source;

public interface OnDataResultListener<T> {
    void onSuccess(T data);

    void onDataNotAvailable();

    void onError();
}
