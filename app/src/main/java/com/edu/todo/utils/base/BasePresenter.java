package com.edu.todo.utils.base;

public interface BasePresenter<V> {
    void onSetView(V view);
    void onStop();
}
