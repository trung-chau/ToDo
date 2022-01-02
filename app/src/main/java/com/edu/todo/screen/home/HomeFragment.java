package com.edu.todo.screen.home;

import android.annotation.SuppressLint;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.edu.todo.R;
import com.edu.todo.screen.task.TasksFragment;
import com.edu.todo.screen.user.UserFragment;
import com.edu.todo.utils.base.BaseFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeFragment extends BaseFragment {

    private BottomNavigationView bottomNavigationView;

    public HomeFragment() {}

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View rootView) {
        replaceFragment(new TasksFragment());
        bottomNavigationView = rootView.findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigationHome:
                        replaceFragment(new TasksFragment());
                        return true;
                    case R.id.navigationUser:
                        replaceFragment(new UserFragment());
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void initData() {

    }

    private void replaceFragment(Fragment fragment) {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, fragment)
                .commit();
    }
}
