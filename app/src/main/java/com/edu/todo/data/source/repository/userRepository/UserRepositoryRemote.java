package com.edu.todo.data.source.repository.userRepository;


import com.edu.todo.data.model.User;
import com.edu.todo.data.source.OnDataResultListener;
import com.edu.todo.data.source.datasource.UserDataSource;

public class UserRepositoryRemote {

    private static UserRepositoryRemote instance = null;
    private final UserDataSource.Remote remote;

    private UserRepositoryRemote(UserDataSource.Remote remote) {
        this.remote = remote;
    }

    public static synchronized UserRepositoryRemote getInstance(UserDataSource.Remote remote) {
        if (instance == null) {
            instance = new UserRepositoryRemote(remote);
        }
        return instance;
    }

    public void getInforUser(String email, OnDataResultListener<User> listener) {
        remote.getInforUser(email, listener);
    }

    public void postInforUser(User user, OnDataResultListener<String> listener) {
        remote.postInforUser(user, listener);
    }
}
