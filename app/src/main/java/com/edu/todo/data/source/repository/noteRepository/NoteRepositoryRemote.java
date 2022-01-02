package com.edu.todo.data.source.repository.noteRepository;

import com.edu.todo.data.model.Note;
import com.edu.todo.data.model.User;
import com.edu.todo.data.source.OnDataResultListener;
import com.edu.todo.data.source.datasource.NoteDataSource;

import java.util.List;

public class NoteRepositoryRemote {
    private static NoteRepositoryRemote instance = null;
    private final NoteDataSource.Remote remote;

    private NoteRepositoryRemote(NoteDataSource.Remote remote) {
        this.remote = remote;
    }

    public static synchronized NoteRepositoryRemote getInstance(NoteDataSource.Remote remote) {
        if (instance == null) {
            instance = new NoteRepositoryRemote(remote);
        }
        return instance;
    }

    public void getTasks(int idUser, OnDataResultListener<List<Note>> listener) {
        remote.getTasks(idUser, listener);
    }

    public void postTask(Note note, OnDataResultListener<String> listener) {
        remote.postTask(note, listener);
    }
}
