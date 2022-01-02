package com.edu.todo.screen.task;

import com.edu.todo.data.model.Note;
import com.edu.todo.screen.signup.SignUpContract;
import com.edu.todo.utils.base.BasePresenter;

import java.util.List;

public class TaskContract {

    interface View {

        void onShowDataTask(List<Note> notes);
    }

    interface Presenter extends BasePresenter<TaskContract.View> {

        void onGetTasks(int idUser);

        void onPostTask(Note note);
    }
}
