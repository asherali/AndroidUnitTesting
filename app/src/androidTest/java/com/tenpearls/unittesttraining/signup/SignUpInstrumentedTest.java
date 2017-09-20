package com.tenpearls.unittesttraining.signup;

/**
 * Created by asher.ali on 9/20/2017.
 */

import android.support.test.annotation.UiThreadTest;
import android.support.test.runner.AndroidJUnit4;

import com.tenpearls.unittesttraining.R;

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
public class SignUpInstrumentedTest {

    private SignUpPresenter signUpPresenter;

    @Mock
    SignUpContract.View signUpView;

    @UiThreadTest
    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        signUpPresenter = new SignUpPresenter(signUpView);
    }

    @Test
    public void showErrorMessage_UsernameInvalid() throws Exception
    {
        Mockito.when((signUpView.getUsername())).thenReturn("@ali.com");
        Mockito.when(signUpView.getPassword()).thenReturn("Test@123");
        Mockito.when(signUpView.getConfirmPassword()).thenReturn("Test@123");

        signUpPresenter.onSignUpClicked();

        Mockito.verify(signUpView,Mockito.timeout(1200)).showUsernameError();
    }

    @Test
    public void showErrorMessage_PasswordInvalid() throws Exception
    {
        Mockito.when((signUpView.getUsername())).thenReturn("asher@10p.com");
        Mockito.when(signUpView.getPassword()).thenReturn("123test");
        Mockito.when(signUpView.getConfirmPassword()).thenReturn("123test");

        signUpPresenter.onSignUpClicked();

        Mockito.verify(signUpView,Mockito.timeout(1200)).showPasswordError();
    }

    @Test
    public void showErrorMessage_ConfirmPasswordInvalid() throws Exception
    {
        Mockito.when((signUpView.getUsername())).thenReturn("asher@10p.com");
        Mockito.when(signUpView.getPassword()).thenReturn("Test@123");
        Mockito.when(signUpView.getConfirmPassword()).thenReturn("Test123");

        signUpPresenter.onSignUpClicked();

        Mockito.verify(signUpView,Mockito.timeout(1200)).showConfirmPasswordError();
    }

    @Test
    public void showErrorMessage_PasswordsDontMatch() throws Exception
    {
        Mockito.when((signUpView.getUsername())).thenReturn("asher@10p.com");
        Mockito.when(signUpView.getPassword()).thenReturn("Test@123");
        Mockito.when(signUpView.getConfirmPassword()).thenReturn("123@Test");

        signUpPresenter.onSignUpClicked();

        Mockito.verify(signUpView,Mockito.timeout(1200)).showConfirmPasswordError();
    }


    @Test
    public void showErrorMessage_loginFailed() throws Exception
    {


        Mockito.when((signUpView.getUsername())).thenReturn("asher@10p.com");
        Mockito.when(signUpView.getPassword()).thenReturn("123@Test");
        Mockito.when(signUpView.getConfirmPassword()).thenReturn("123@Test");

        signUpPresenter.onSignUpClicked();

        Mockito.verify(signUpView,Mockito.timeout(1200)).onSignUpFailure(R.string.signup_failed);
    }

    @Test
    public void showErrorMessage_loginSuccess() throws Exception
    {


        Mockito.when((signUpView.getUsername())).thenReturn("asher@10p.com");
        Mockito.when(signUpView.getPassword()).thenReturn("Test@123");
        Mockito.when(signUpView.getConfirmPassword()).thenReturn("Test@123");

        signUpPresenter.onSignUpClicked();

        Mockito.verify(signUpView,Mockito.timeout(1200)).onSignUpSuccess();
    }
}
