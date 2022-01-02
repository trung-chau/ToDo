package com.edu.todo.screen.task.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edu.todo.R;
import com.edu.todo.data.model.Note;
import com.edu.todo.utils.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private final List<Note> listNotes = new ArrayList<>();
    private final OnItemClickListener<Note> onItemClickListener;

    public TaskAdapter(OnItemClickListener<Note> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new ViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, int position) {
        holder.bind(listNotes.get(position));
    }

    @Override
    public int getItemCount() {
        return listNotes.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateData(List<Note> notes) {
        listNotes.clear();
        listNotes.addAll(notes);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final CheckBox checkboxDone;
        private final TextView textViewTitleItem;
        private final TextView textViewContentItem;
        private final TextView textViewDateTimeItem;
        private final OnItemClickListener<Note> listener;

        public ViewHolder(@NonNull View itemView, OnItemClickListener<Note> listener) {
            super(itemView);
            checkboxDone = itemView.findViewById(R.id.checkboxDone);
            textViewTitleItem = itemView.findViewById(R.id.textViewTitleItem);
            textViewContentItem = itemView.findViewById(R.id.textViewContentItem);
            textViewDateTimeItem = itemView.findViewById(R.id.textViewDateTimeItem);
            this.listener = listener;
        }

        public void bind(Note note) {
            if (note.isDone() == 1) {
                checkboxDone.setChecked(true);
            }
            textViewTitleItem.setText(note.getTitle());
            textViewContentItem.setText(note.getContent());
            textViewDateTimeItem.setText(note.getRemainderTime());
            itemView.setOnClickListener(view -> {
                listener.onItemClick(note);
            });
        }
    }
}
