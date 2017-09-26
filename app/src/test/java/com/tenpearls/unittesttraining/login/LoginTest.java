package com.tenpearls.unittesttraining.login;

import com.tenpearls.unittesttraining.R;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class LoginTest {

    private LoginPresenter loginPresenter;

    @Mock
    LoginContract.View loginView;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        loginPresenter = new LoginPresenter(loginView);

    }

    @Test
    public void showErrorMessage_UsernameInvalid() throws Exception
    {
        Mockito.when((loginView.getUsername())).thenReturn("@ali.com");
        Mockito.when(loginView.getPassword()).thenReturn("Test@123");

        loginPresenter.onLoginClicked();

        Mockito.verify(loginView).showUsernameError();
    }

    @Test
    public void showErrorMessage_PasswordInvalid() throws Exception
    {
        Mockito.when((loginView.getUsername())).thenReturn("asher@ali.com");
        Mockito.when(loginView.getPassword()).thenReturn("123test");

        loginPresenter.onLoginClicked();

        Mockito.verify(loginView).showPasswordError();
    }


    @Test
    public void showErrorMessage_loginFailed() throws Exception
    {


        Mockito.when((loginView.getUsername())).thenReturn("asher@ali.com");
        Mockito.when(loginView.getPassword()).thenReturn("123@Test");

        loginPresenter.onLoginClicked();

        Mockito.verify(loginView).onLoginFailure(R.string.login_failed);
    }

    @Test
    public void showErrorMessage_loginSuccess() throws Exception
    {


        Mockito.when((loginView.getUsername())).thenReturn("asher@10p.com");
        Mockito.when(loginView.getPassword()).thenReturn("Test@123");

        loginPresenter.onLoginClicked();

        Mockito.verify(loginView).onLoginSuccess();
    }

}
