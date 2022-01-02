package com.edu.todo.data.source.datasource.remote;

import android.util.Log;

import androidx.annotation.NonNull;

import com.edu.todo.data.model.BaseResponse;
import com.edu.todo.data.model.BaseStatusPost;
import com.edu.todo.data.model.User;
import com.edu.todo.data.source.OnDataResultListener;
import com.edu.todo.data.source.api.ApiService;
import com.edu.todo.data.source.datasource.UserDataSource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRemoteDataSource implements UserDataSource.Remote {

    private UserRemoteDataSource() {
    }

    private static UserRemoteDataSource instance;

    public static synchronized UserRemoteDataSource getInstance() {
        if (instance == null) {
            instance = new UserRemoteDataSource();
        }

        return instance;
    }

    @Override
    public void getInforUser(String email, OnDataResultListener<User> listener) {
        ApiService.apiService.getUser(email)
                .enqueue(new Callback<BaseResponse<List<User>>>() {
                    @Override
                    public void onResponse(@NonNull Call<BaseResponse<List<User>>> call, @NonNull Response<BaseResponse<List<User>>> response) {
                        BaseResponse<List<User>> baseResponse = response.body();
                        if (baseResponse != null) {
                            List<User> userList = baseResponse.getData();
                            listener.onSuccess(userList.get(0));
                        } else {
                            listener.onDataNotAvailable();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<BaseResponse<List<User>>> call, @NonNull Throwable t) {
                        listener.onError();
                    }
                });
    }

    @Override
    public void postInforUser(User user, OnDataResultListener<String> listener) {
        ApiService.apiService.postUser(user.getFirstName(),
                user.getLastName(),
                user.getBirthDay(),
                user.getEmail(),
                user.getPassword(),
                user.getGender(),
                user.getNotes()).enqueue(new Callback<BaseStatusPost>() {
            @Override
            public void onResponse(Call<BaseStatusPost> call, Response<BaseStatusPost> response) {
                BaseStatusPost statusPost = response.body();
                if (statusPost != null) {
                    Log.i("aaaa", statusPost.getStatus());
                }
            }

            @Override
            public void onFailure(Call<BaseStatusPost> call, Throwable t) {
                Log.i("aaaa", "onFailure");
            }
        });
    }
}
