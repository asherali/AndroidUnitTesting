package com.tenpearls.unittesttraining.signup;

import android.os.Handler;

import com.tenpearls.unittesttraining.R;
import com.tenpearls.unittesttraining.utils.ValidationUtil;

/**
 * Created by asher.ali on 9/18/2017.
 */

public class SignUpPresenter implements SignUpContract.UserActionListener {

    private SignUpContract.View signUpView;
    private SignUpService signUpService;
    private Handler handler;

    public SignUpPresenter(SignUpContract.View view)
    {
        signUpView = view;
        signUpService = new SignUpService();
        handler = new Handler();
    }

    @Override
    public void onSignUpClicked() {
        String userName = signUpView.getUsername();
        String password = signUpView.getPassword();
        String confirmPassword = signUpView.getConfirmPassword();

        if (!ValidationUtil.isValidEmailAddress(userName))
        {
            signUpView.showUsernameError();
            return;
        }

        if (!ValidationUtil.isValidPassword(password))
        {
            signUpView.showPasswordError();
            return;
        }

        if (!ValidationUtil.isValidPassword(confirmPassword) || !password.equals(confirmPassword))
        {
            signUpView.showConfirmPasswordError();
            return;
        }

        signUp(userName,password);
    }

    private void signUp(final String userName, final String password)
    {
        signUpView.showProgressBar(true);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                boolean isLoginSuccess = signUpService.signUp(userName,password);
                signUpView.showProgressBar(false);

                if (isLoginSuccess)
                    signUpView.onSignUpSuccess();
                else
                    signUpView.onSignUpFailure(R.string.signup_failed);
            }
        }, 1000);
    }
}
