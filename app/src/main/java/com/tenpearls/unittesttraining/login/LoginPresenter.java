package com.tenpearls.unittesttraining.login;

import com.tenpearls.unittesttraining.R;
import com.tenpearls.unittesttraining.pojo.User;
import com.tenpearls.unittesttraining.utils.ValidationUtil;

/**
 * Class Created by asher.ali on 8/21/2017.
 */

public class LoginPresenter implements LoginContract.UserActionListener
{

    private LoginContract.View loginView;
    private LoginService loginService;
    private User user;

    public LoginPresenter(LoginContract.View loginView)
    {
        this.loginView = loginView;
        loginService = new LoginService();
        user = new User();
    }

    @Override
    public void onLoginClicked() {

        user.setUserName(loginView.getUsername());
        user.setPassword(loginView.getPassword());

        if (!ValidationUtil.isValidEmailAddress(user.getUserName()))
        {
            loginView.showUsernameError();
            return;
        }

        if (!ValidationUtil.isValidPassword(user.getPassword()))
        {
            loginView.showPasswordError();
            return;
        }
        login(user.getUserName(),user.getPassword());
}

    private void login(final String userName, final String password)
    {

        boolean isLoginSuccess = loginService.login(userName,password);
        if (isLoginSuccess)
            loginView.onLoginSuccess();
        else
            loginView.onLoginFailure(R.string.login_failed);

    }

}
