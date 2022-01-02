package com.edu.todo.screen.signup;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.Navigation;

import com.edu.todo.R;
import com.edu.todo.data.source.datasource.remote.UserRemoteDataSource;
import com.edu.todo.data.source.repository.userRepository.UserRepositoryRemote;
import com.edu.todo.screen.login.LoginFragmentArgs;
import com.edu.todo.utils.base.BaseFragment;

public class SignupFragment extends BaseFragment implements SignUpContract.View {

    private EditText editTextEmailSignUp;
    private EditText editTextPasswordSignUp;
    private EditText editTextEnterPasswordSignUp;
    private EditText editTextFirstNameSignUp;
    private EditText editTextLastNameSignUp;
    private TextView textViewBirthDateSignUp;
    private DatePickerDialog datePickerDialog;
    private int selectedYear = 2000;
    private int selectedMonth = 5;
    private int selectedDayOfMonth = 10;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_sign_up;
    }

    @SuppressLint("DefaultLocale")
    @Override
    protected void initView(View view) {
        editTextEmailSignUp = view.findViewById(R.id.editTextEmailSignUp);
        editTextPasswordSignUp = view.findViewById(R.id.editTextPasswordSignUp);
        editTextEnterPasswordSignUp = view.findViewById(R.id.editTextEnterPasswordSignUp);
        editTextFirstNameSignUp = view.findViewById(R.id.editTextFirstNameSignUp);
        editTextLastNameSignUp = view.findViewById(R.id.editTextLastNameSignUp);
        textViewBirthDateSignUp = view.findViewById(R.id.textViewBirthDateProfile);

        Button buttonConfirmSignUp = view.findViewById(R.id.buttonConfirmSignUp);

        SignUpPresenter signUpPresenter = new SignUpPresenter(UserRepositoryRemote.getInstance(UserRemoteDataSource.getInstance()));

        signUpPresenter.onSetView(this);
        buttonConfirmSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View onClickView) {
                String email = editTextEmailSignUp.getText().toString().trim();
                String password = editTextPasswordSignUp.getText().toString().trim();
                String enterPassword = editTextEnterPasswordSignUp.getText().toString().trim();
//                signUpPresenter.onUserSignUp(email, password, enterPassword);
//                userSignUp(view);
            }
        });

//        textViewBirthDateSignUp.setText(String.format("%d/%d/%d", selectedDayOfMonth, selectedMonth, selectedYear));
//        setDatePickerDialog();
//        textViewBirthDateSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                datePickerDialog.show();
//            }
//        });
    }

    private void setDatePickerDialog() {

        // Date Select Listener.
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onDateSet(DatePicker datePicker,  int year, int monthOfYear, int dayOfMonth) {
                selectedYear = year;
                selectedMonth = monthOfYear;
                selectedDayOfMonth = dayOfMonth;
                textViewBirthDateSignUp.setText(String.format("%d/%d/%d", selectedDayOfMonth, selectedMonth, selectedYear));
            }
        };

        // Create DatePickerDialog (Spinner Mode):
        datePickerDialog = new DatePickerDialog(requireContext(),
                dateSetListener, selectedYear, selectedMonth, selectedDayOfMonth);
    }

    @Override
    protected void initData() {

    }

    private void userSignUp(View view) {
        String email = editTextEmailSignUp.getText().toString().trim();
        String password = editTextPasswordSignUp.getText().toString().trim();
        String enterPassword = editTextEnterPasswordSignUp.getText().toString().trim();

        if (!email.isEmpty() && !password.isEmpty() && !enterPassword.isEmpty()) {
            if (password.equals(enterPassword)) {
                LoginFragmentArgs.Builder builder = new LoginFragmentArgs.Builder();
                builder.setEmail(email);
                Navigation.findNavController(view).navigate(R.id.action_fragmentSignUp_to_fragmentLogin,
                        builder.build().toBundle());
            } else {
                Toast.makeText(getContext(), getString(R.string.message_enter_password_wrong), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getContext(), getString(R.string.message_blank_data), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onSignUpSuccess(String email) {
        LoginFragmentArgs.Builder builder = new LoginFragmentArgs.Builder();
        builder.setEmail(email);
        Navigation.findNavController(requireView()).navigate(R.id.action_fragmentSignUp_to_fragmentLogin,
                builder.build().toBundle());
    }

    @Override
    public void onSignUpFail() {

    }

    @Override
    public void onEmailValidate() {
        Toast.makeText(getContext(), getString(R.string.message_email_not_validate), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEnterPasswordIncorrect() {
        Toast.makeText(getContext(), getString(R.string.message_enter_password_wrong), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBlankData() {
        Toast.makeText(getContext(), getString(R.string.message_blank_data), Toast.LENGTH_SHORT).show();
    }
}
