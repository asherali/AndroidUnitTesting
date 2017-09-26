package com.tenpearls.unittesttraining.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tenpearls.unittesttraining.MainActivity;
import com.tenpearls.unittesttraining.R;
import com.tenpearls.unittesttraining.signup.SignUpActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View,View.OnClickListener
{

    EditText etUserName,etPassword;
    AppCompatButton btnLogin,btnSignUp ;
    LoginContract.UserActionListener loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // casting views is redundant in api 26 !
        etUserName =  findViewById(R.id.etUserName);
        etPassword =  findViewById(R.id.etPassword);
        btnLogin   =  findViewById(R.id.btnLogin);
        btnSignUp  =  findViewById(R.id.btnSignUp);


        loginPresenter = new LoginPresenter(this);
        btnLogin.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btnLogin:
               loginPresenter.onLoginClicked();

                break;
            case R.id.btnSignUp:
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
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
    public void onLoginSuccess() {
        Toast.makeText(this, getString(R.string.login_success),Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        //finish();
    }

    @Override
    public void onLoginFailure(int resId) {
        Toast.makeText(this,getString(resId),Toast.LENGTH_SHORT).show();
    }


}
