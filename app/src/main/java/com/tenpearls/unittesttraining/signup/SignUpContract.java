package com.tenpearls.unittesttraining.signup;

/**
 * Created by asher.ali on 9/18/2017.
 */

public class SignUpContract {

    interface View
    {
        String getUsername();
        void   showUsernameError();

        String getPassword();
        void   showPasswordError();

        String getConfirmPassword();
        void   showConfirmPasswordError();

        void onSignUpSuccess();
        void onSignUpFailure(int resId);

        void showProgressBar(boolean isInProgress);
    }

    interface UserActionListener
    {
        void onSignUpClicked();
    }
}
