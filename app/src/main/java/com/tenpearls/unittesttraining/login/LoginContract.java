package com.tenpearls.unittesttraining.login;

/**
 * Created by asher.ali on 8/21/2017.
 */

public interface LoginContract {

    // Activity/Fragment implements View, so presenter calls method from this view
     interface View
    {
        String getUsername();
        void   showUsernameError();

        String getPassword();
        void   showPasswordError();

        void onLoginSuccess();
        void onLoginFailure(int resId);

        void showProgressBar(boolean isInProgress);

    }

    // Presenter implements UserActionListener, so view calls method from this presenter
     interface UserActionListener
    {
        void onLoginClicked();
    }

}
