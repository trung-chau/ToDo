package com.edu.todo.screen.login;

import com.edu.todo.data.model.User;
import com.edu.todo.utils.base.BasePresenter;

public class LoginContract {

    interface View {
        void onEmailValidate();

        void onBlankData();

        void onLoginFail();

        void onLoginSuccess(User user);

        void onLoginError();

        void onSaveUserSuccess();

        void onSaveUserFail();

        void onUserLogged(User user);
    }

    interface Presenter extends BasePresenter<View> {
        void userLogin(String email, String password);

        void checkUserLogged();
    }
}
