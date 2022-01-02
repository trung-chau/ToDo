package com.edu.todo.data.source;

public interface LoadCallback<T> {
    void onLoaded(T data);

    void onDataNotAvailable();

    void onError();
}
