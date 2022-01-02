package com.edu.todo.data.source.datasource;

import com.edu.todo.data.model.Note;
import com.edu.todo.data.source.OnDataResultListener;

import java.util.List;

public interface NoteDataSource {

    interface Local {
        //NOTHING
    }

    interface Remote {
        void getTasks(int idUser, OnDataResultListener<List<Note>> listener);

        void postTask(Note note, OnDataResultListener<String> listener);
    }
}
