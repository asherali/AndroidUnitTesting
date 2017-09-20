package com.tenpearls.unittesttraining.login;

import android.support.test.annotation.UiThreadTest;
import android.support.test.runner.AndroidJUnit4;

import com.tenpearls.unittesttraining.R;
import com.tenpearls.unittesttraining.login.LoginContract;
import com.tenpearls.unittesttraining.login.LoginPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Instrumentation test, which will execute on an Android device.
 *Note that in order to use @Mock annotation you should mark your class with @RunWith(MockitoJUnitRunner.class)
 * annotation or call out MockitoAnnotations.initMocks(this); in @Before method:
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LoginInstrumentedTest {

    private LoginPresenter loginPresenter;

    @Mock
    LoginContract.View loginView;


    @UiThreadTest
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

        Mockito.verify(loginView,Mockito.timeout(1200)).showUsernameError();
    }

    @Test
    public void showErrorMessage_PasswordInvalid() throws Exception
    {
        Mockito.when((loginView.getUsername())).thenReturn("asher@ali.com");
        Mockito.when(loginView.getPassword()).thenReturn("123test");

        loginPresenter.onLoginClicked();

        Mockito.verify(loginView,Mockito.timeout(1200)).showPasswordError();
    }


    @Test
    public void showErrorMessage_loginFailed() throws Exception
    {


        Mockito.when((loginView.getUsername())).thenReturn("asher@ali.com");
        Mockito.when(loginView.getPassword()).thenReturn("123@Test");

        loginPresenter.onLoginClicked();

        Mockito.verify(loginView,Mockito.timeout(1200)).onLoginFailure(R.string.login_failed);
    }

    @Test
    public void showErrorMessage_loginSuccess() throws Exception
    {


        Mockito.when((loginView.getUsername())).thenReturn("asher@ali.com");
        Mockito.when(loginView.getPassword()).thenReturn("Test@123");

        loginPresenter.onLoginClicked();

        Mockito.verify(loginView,Mockito.timeout(1200)).onLoginSuccess();
    }

}
