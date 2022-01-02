package com.edu.todo.screen.user;

import android.view.View;
import android.widget.Button;

import com.edu.todo.R;
import com.edu.todo.screen.addtask.AddTaskFragment;
import com.edu.todo.screen.changpassword.ChangePasswordFragment;
import com.edu.todo.utils.base.BaseFragment;

public class UserFragment extends BaseFragment {

    private Button buttonChangePassword;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_user;
    }

    @Override
    protected void initView(View rootView) {
        buttonChangePassword = rootView.findViewById(R.id.buttonChangePassword);

        buttonChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragmentContainerView, new ChangePasswordFragment())
                        .commit();
            }
        });
    }

    @Override
    protected void initData() {

    }
}
