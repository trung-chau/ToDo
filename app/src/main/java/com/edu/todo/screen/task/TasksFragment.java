package com.edu.todo.screen.task;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edu.todo.R;
import com.edu.todo.data.model.Note;
import com.edu.todo.data.source.datasource.remote.NoteRemoteDataSource;
import com.edu.todo.data.source.repository.noteRepository.NoteRepositoryRemote;
import com.edu.todo.screen.addtask.AddTaskFragment;
import com.edu.todo.screen.task.adapter.TaskAdapter;
import com.edu.todo.utils.OnItemClickListener;
import com.edu.todo.utils.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class TasksFragment extends BaseFragment implements TaskContract.View {

    private ImageView imageViewAddTask;
    private RecyclerView recyclerViewListTask;
    private TaskAdapter taskAdapter;
    private TaskPresenter presenter;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_task;
    }

    @Override
    protected void initView(View rootView) {
        imageViewAddTask = rootView.findViewById(R.id.imageViewAddTask);
        recyclerViewListTask = rootView.findViewById(R.id.recyclerViewListTask);

        presenter = new TaskPresenter(NoteRepositoryRemote.getInstance(NoteRemoteDataSource.getInstance()));
        presenter.onSetView(this);
        taskAdapter = new TaskAdapter(new OnItemClickListener<Note>() {
            @Override
            public void onItemClick(Note data) {
                // to do
                Toast.makeText(rootView.getContext(), data.getContent(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerViewListTask.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerViewListTask.setAdapter(taskAdapter);

        imageViewAddTask.setOnClickListener(view -> {
//            requireActivity().getSupportFragmentManager().beginTransaction()
//                    .add(R.id.fragmentContainerView, new AddTaskFragment())
//                    .commit();
            presenter.onGetTasks(1);
        });
    }

    @Override
    protected void initData() {
//        List<Note> notes = new ArrayList<>();
//        notes.add(new Note(1, 1, 1, "", "Doc sach", "Doc sach 1 tieng", 0, "25/12/2021 21:00"));
//        notes.add(new Note(1, 1, 1, "", "Doc sach", "Doc sach 1 tieng", 0, "25/12/2021 21:00"));
//        notes.add(new Note(1, 1, 1, "", "Doc sach", "Doc sach 1 tieng", 0, "25/12/2021 21:00"));
//        notes.add(new Note(1, 1, 1, "", "Doc sach", "Doc sach 1 tieng", 0, "25/12/2021 21:00"));
//        notes.add(new Note(1, 1, 1, "", "Doc sach", "Doc sach 1 tieng", 0, "25/12/2021 21:00"));
//        notes.add(new Note(1, 1, 1, "", "Doc sach", "Doc sach 1 tieng", 0, "25/12/2021 21:00"));
//        notes.add(new Note(1, 1, 1, "", "Doc sach", "Doc sach 1 tieng", 0, "25/12/2021 21:00"));
//        taskAdapter.updateData(notes);
    }

    @Override
    public void onShowDataTask(List<Note> notes) {

    }
}
