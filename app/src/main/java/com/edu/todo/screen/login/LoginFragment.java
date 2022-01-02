package com.edu.todo.screen.login;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.navigation.Navigation;

import com.edu.todo.R;
import com.edu.todo.data.model.User;
import com.edu.todo.data.source.datasource.local.UserLocalDataSource;
import com.edu.todo.data.source.datasource.remote.UserRemoteDataSource;
import com.edu.todo.data.source.repository.userRepository.UserRepositoryLocal;
import com.edu.todo.data.source.repository.userRepository.UserRepositoryRemote;
import com.edu.todo.utils.base.BaseFragment;

public class LoginFragment extends BaseFragment implements LoginContract.View {

    private Button buttonLogin;
    private Button buttonSignUp;
    private EditText editTexEmail;
    private EditText editTextPassword;

    public LoginFragment() {}

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initView(View view) {
        buttonLogin = view.findViewById(R.id.buttonLogin);
        buttonSignUp = view.findViewById(R.id.buttonSignUp);
        editTexEmail = view.findViewById(R.id.editTextUserName);
        editTextPassword = view.findViewById(R.id.editTextPassword);

        LoginPresenter loginPresenter = new LoginPresenter(
                UserRepositoryRemote.getInstance(UserRemoteDataSource.getInstance()
                ), UserRepositoryLocal.getInstance(UserLocalDataSource.getInstance())
        );
        loginPresenter.onSetView(this);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View onClickView) {
//                loginPresenter.userLogin(editTexEmail.getText().toString().trim(),
//                        editTextPassword.getText().toString().trim());
                Navigation.findNavController(requireView()).navigate(R.id.action_fragmentLogin_to_fragmentHome);
            }
        });
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentLogin_to_fragmentSignUp);
            }
        });
    }

    @Override
    protected void initData() {
        if (getArguments() != null) {
            String email = LoginFragmentArgs.fromBundle(getArguments()).getEmail();
            editTexEmail.setText(email);
        }
    }

    @Override
    public void onEmailValidate() {
        Toast.makeText(requireContext(),
                requireContext().getResources().getString(R.string.message_email_not_validate),
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void onBlankData() {
        Toast.makeText(requireContext(),
                requireContext().getResources().getString(R.string.message_blank_data),
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void onLoginFail() {
        Toast.makeText(requireContext(),
                requireContext().getResources().getString(R.string.message_login_un_success),
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void onLoginSuccess(User user) {
        Navigation.findNavController(requireView()).navigate(R.id.action_fragmentLogin_to_fragmentHome);
    }

    @Override
    public void onLoginError() {
        Toast.makeText(requireContext(),
                requireContext().getResources().getString(R.string.message_login_error),
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void onSaveUserSuccess() {

    }

    @Override
    public void onSaveUserFail() {

    }

    @Override
    public void onUserLogged(User user) {

    }
}
