package com.edu.todo.screen.task;

import android.util.Log;

import com.edu.todo.data.model.Note;
import com.edu.todo.data.source.OnDataResultListener;
import com.edu.todo.data.source.repository.noteRepository.NoteRepositoryRemote;

import java.util.List;

public class TaskPresenter implements TaskContract.Presenter {

    private final NoteRepositoryRemote remote;
    private TaskContract.View view;

    public TaskPresenter(NoteRepositoryRemote remote) {
        this.remote = remote;
    }

    @Override
    public void onGetTasks(int idUser) {
        remote.getTasks(idUser, new OnDataResultListener<List<Note>>() {

            @Override
            public void onSuccess(List<Note> data) {
                Log.d("note", "onSuccess");
            }

            @Override
            public void onDataNotAvailable() {

                Log.d("note", "onDataNotAvailable");
            }

            @Override
            public void onError() {

                Log.d("note", "onError");
            }
        });
    }

    @Override
    public void onPostTask(Note note) {

    }

    @Override
    public void onSetView(TaskContract.View view) {
        this.view = view;
    }

    @Override
    public void onStop() {

    }
}
