package com.edu.todo.data.source.datasource.remote;

import androidx.annotation.NonNull;

import com.edu.todo.data.model.BaseResponse;
import com.edu.todo.data.model.Note;
import com.edu.todo.data.model.User;
import com.edu.todo.data.source.OnDataResultListener;
import com.edu.todo.data.source.api.ApiService;
import com.edu.todo.data.source.datasource.NoteDataSource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoteRemoteDataSource implements NoteDataSource.Remote {

    private NoteRemoteDataSource() {
    }

    private static NoteRemoteDataSource instance;

    public static synchronized NoteRemoteDataSource getInstance() {
        if (instance == null) {
            instance = new NoteRemoteDataSource();
        }

        return instance;
    }

    @Override
    public void getTasks(int idUser, OnDataResultListener<List<Note>> listener) {
        ApiService.apiService.getTasks(idUser).enqueue(new Callback<BaseResponse<List<Note>>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse<List<Note>>> call,
                                   @NonNull Response<BaseResponse<List<Note>>> response) {
                BaseResponse<List<Note>> baseResponse = response.body();
                if (baseResponse != null) {
                    List<Note> notes = baseResponse.getData();
                    listener.onSuccess(notes);
                } else {
                    listener.onDataNotAvailable();
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<Note>>> call, Throwable t) {
                listener.onError();
            }
        });
    }

    @Override
    public void postTask(Note note, OnDataResultListener<String> listener) {

    }
}
