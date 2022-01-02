package com.edu.todo.screen.signup;

import com.edu.todo.data.model.User;
import com.edu.todo.data.source.OnDataResultListener;
import com.edu.todo.data.source.repository.userRepository.UserRepositoryRemote;

public class SignUpPresenter implements SignUpContract.Presenter {

    private final UserRepositoryRemote remote;
    private SignUpContract.View view;

    public SignUpPresenter(UserRepositoryRemote remote) {
        this.remote = remote;
    }

    @Override
    public void onUserSignUp(String email, String password, String enterPassword) {
        User user = new User();
        user.setFirstName("a");
        user.setLastName("b");
        user.setEmail("email");
        user.setPassword("password");
        user.setGender("Nam");
        user.setNotes("abc");
        user.setBirthDay("a123");
        remote.postInforUser(user, new OnDataResultListener<String>() {
            @Override
            public void onSuccess(String data) {
                view.onSignUpSuccess(user.getEmail());
            }

            @Override
            public void onDataNotAvailable() {
                // Method blank
            }

            @Override
            public void onError() {
                view.onSignUpFail();
            }
        });
//        if (!email.isEmpty() && !password.isEmpty() && !enterPassword.isEmpty()) {
//            if (BaseUtils.isValidEmail(email)) {
//                if (password.equals(enterPassword)) {
//                    User user = new User();
//                    user.setFirstName("a");
//                    user.setLastName("b");
//                    user.setEmail("email");
//                    user.setPassword("password");
//                    user.setGender("Nam");
//                    user.setNotes("abc");
//                    remote.postInforUser(user, new OnDataResultListener<String>() {
//                        @Override
//                        public void onSuccess(String data) {
//                            view.onSignUpSuccess(user.getEmail());
//                        }
//
//                        @Override
//                        public void onDataNotAvailable() {
//                            // Method blank
//                        }
//
//                        @Override
//                        public void onError() {
//                            view.onSignUpFail();
//                        }
//                    });
//                } else {
//                    view.onEnterPasswordIncorrect();
//                }
//            } else {
//                view.onEmailValidate();
//            }
//        } else {
//            view.onBlankData();
//        }
    }

    @Override
    public void onSetView(SignUpContract.View view) {
        this.view = view;
    }

    @Override
    public void onStop() {

    }
}
