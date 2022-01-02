package com.edu.todo.data.source.datasource;


import com.edu.todo.data.model.User;
import com.edu.todo.data.source.OnDataResultListener;

public interface UserDataSource {

    interface Local {
        void saveInforUserToLocal(User user, OnDataResultListener<Long> listener);

        void getInforUserFromLocal(OnDataResultListener<User> listener);

        void deleteUser(User user, OnDataResultListener<Integer> listener);
    }

    interface Remote {
        void getInforUser(String email, OnDataResultListener<User> listener);

        void postInforUser(User user, OnDataResultListener<String> listener);
    }
}
