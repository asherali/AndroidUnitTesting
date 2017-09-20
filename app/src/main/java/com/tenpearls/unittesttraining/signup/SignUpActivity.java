package com.tenpearls.unittesttraining.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tenpearls.unittesttraining.MainActivity;
import com.tenpearls.unittesttraining.R;

public class SignUpActivity extends AppCompatActivity implements SignUpContract.View, View.OnClickListener {

    EditText etUserName,etPassword,etConfirmPassword;
    AppCompatButton btnSignUp ;
    SignUpContract.UserActionListener signUpPresenter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // casting views is redundant in api 26 !
        etUserName =  findViewById(R.id.etUserName);
        etPassword =  findViewById(R.id.etPassword);
        etConfirmPassword =  findViewById(R.id.etConfirmPassword);
        btnSignUp   =  findViewById(R.id.btnSignUp);
        progressBar = findViewById(R.id.progressBar);

        signUpPresenter = new SignUpPresenter(this);
        btnSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnSignUp:
                signUpPresenter.onSignUpClicked();

                break;
        }
    }

    @Override
    public String getUsername() {
        return etUserName.getText().toString();
    }

    @Override
    public void showUsernameError() {
        etUserName.setError(getString(R.string.username_error));
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void showPasswordError() {
        etPassword.setError(getString(R.string.password_error));
    }

    @Override
    public String getConfirmPassword() {
        return etConfirmPassword.getText().toString();
    }

    @Override
    public void showConfirmPasswordError() {
        etConfirmPassword.setError(getString(R.string.confirm_password_error));
    }

    @Override
    public void onSignUpSuccess() {
        startActivity(new Intent(SignUpActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void onSignUpFailure(int resId) {
        Toast.makeText(this,getString(resId),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar(boolean isInProgress) {
        progressBar.setVisibility(isInProgress ? View.VISIBLE : View.GONE);
    }


}
