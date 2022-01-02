package com.edu.todo.screen.signup;

import com.edu.todo.utils.base.BasePresenter;

public class SignUpContract {

    interface View {

        void onSignUpSuccess(String email);

        void onSignUpFail();

        void onEmailValidate();

        void onEnterPasswordIncorrect();

        void onBlankData();
    }

    interface Presenter extends BasePresenter<View> {

        void onUserSignUp(String email, String password, String enterPassword);
    }
}
