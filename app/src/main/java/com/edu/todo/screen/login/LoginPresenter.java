package com.edu.todo.screen.login;

import com.edu.todo.data.model.User;
import com.edu.todo.data.source.OnDataResultListener;
import com.edu.todo.data.source.repository.userRepository.UserRepositoryLocal;
import com.edu.todo.data.source.repository.userRepository.UserRepositoryRemote;
import com.edu.todo.utils.BaseUtils;

public class LoginPresenter implements LoginContract.Presenter {

    private final UserRepositoryRemote remote;
    private final UserRepositoryLocal local;
    private LoginContract.View view;

    public LoginPresenter(UserRepositoryRemote remote, UserRepositoryLocal local) {
        this.remote = remote;
        this.local = local;
    }

    @Override
    public void userLogin(String email, String password) {
        if (!email.isEmpty() && !password.isEmpty()) {
            if (BaseUtils.isValidEmail(email)) {
                remote.getInforUser(email, new OnDataResultListener<User>() {
                    @Override
                    public void onSuccess(User data) {
                        if (data.getPassword().equals(password)) {
                            view.onLoginSuccess(data);
                        } else {
                            view.onLoginFail();
                        }
                    }

                    @Override
                    public void onDataNotAvailable() {
                        view.onLoginFail();
                    }

                    @Override
                    public void onError() {
                        view.onLoginError();
                    }
                });
            } else {
                view.onEmailValidate();
            }
        } else {
            view.onBlankData();
        }
    }

    @Override
    public void checkUserLogged() {

    }

    @Override
    public void onSetView(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void onStop() {

    }
}
