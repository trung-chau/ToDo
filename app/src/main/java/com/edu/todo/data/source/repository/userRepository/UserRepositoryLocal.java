package com.edu.todo.data.source.repository.userRepository;

import com.edu.todo.data.model.User;
import com.edu.todo.data.source.OnDataResultListener;
import com.edu.todo.data.source.datasource.UserDataSource;

public class UserRepositoryLocal {

    private final UserDataSource.Local local;

    private UserRepositoryLocal(UserDataSource.Local local) {
        this.local = local;
    }

    public void getInforUserFromLocal(OnDataResultListener<User> listener) {
        local.getInforUserFromLocal(listener);
    }

    public void saveInforUserToLocal(User user, OnDataResultListener<Long> listener) {
        local.saveInforUserToLocal(user, listener);
    }

    public void deleteUser(User user, OnDataResultListener<Integer> listener) {
        local.deleteUser(user, listener);
    }

    public static UserRepositoryLocal instance = null;

    public static synchronized UserRepositoryLocal getInstance(UserDataSource.Local local) {
        if (instance == null) {
            instance = new UserRepositoryLocal(local);
        }
        return instance;
    }
}
