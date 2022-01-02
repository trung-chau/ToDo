package com.edu.todo.data.source.datasource.local;

import com.edu.todo.data.model.User;
import com.edu.todo.data.source.OnDataResultListener;
import com.edu.todo.data.source.datasource.UserDataSource;

public class UserLocalDataSource implements UserDataSource.Local {

    private UserLocalDataSource() {
    }

    private static UserLocalDataSource instance;

    public static synchronized UserLocalDataSource getInstance() {
        if (instance == null) {
            instance = new UserLocalDataSource();
        }

        return instance;
    }

    @Override
    public void saveInforUserToLocal(User user, OnDataResultListener<Long> listener) {

    }

    @Override
    public void getInforUserFromLocal(OnDataResultListener<User> listener) {

    }

    @Override
    public void deleteUser(User user, OnDataResultListener<Integer> listener) {

    }
}
