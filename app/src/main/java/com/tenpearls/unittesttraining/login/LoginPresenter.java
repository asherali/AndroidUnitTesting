package com.tenpearls.unittesttraining.login;

import android.os.Handler;

import com.tenpearls.unittesttraining.R;
import com.tenpearls.unittesttraining.utils.ValidationUtil;

/**
 * Class Created by asher.ali on 8/21/2017.
 */

public class LoginPresenter implements LoginContract.UserActionListener
{

    private LoginContract.View loginView;
    private LoginService loginService;
    private Handler handler;


    public LoginPresenter(LoginContract.View loginView)
    {
        this.loginView = loginView;
        loginService = new LoginService();
        handler = new Handler();
    }

    @Override
    public void onLoginClicked(String username, String password) {
        login(username,password);
}

    @Override
    public boolean isValidLoginCredentials(String username, String password) {

        if (!ValidationUtil.isValidEmailAddress(username))
        {
            loginView.showUsernameError();
            return false;
        }

        if (!ValidationUtil.isValidPassword(password))
        {
            loginView.showPasswordError();
            return false;
        }

        return true;
    }

    private void login(final String userName, final String password)
    {
        loginView.showProgressBar(true);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                boolean isLoginSuccess = loginService.login(userName,password);
                loginView.showProgressBar(false);

                if (isLoginSuccess)
                    loginView.onLoginSuccess();
                else
                    loginView.onLoginFailure(R.string.login_failed);
            }
        }, 1000);
    }

}
