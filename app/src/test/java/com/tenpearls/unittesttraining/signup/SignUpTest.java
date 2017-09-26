package com.tenpearls.unittesttraining.signup;

import com.tenpearls.unittesttraining.R;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by asher.ali on 9/20/2017.
 */


public class SignUpTest {

    private SignUpPresenter signUpPresenter;

    @Mock
    SignUpContract.View signUpView;

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

        Mockito.verify(signUpView).showUsernameError();
    }

    @Test
    public void showErrorMessage_PasswordInvalid() throws Exception
    {
        Mockito.when((signUpView.getUsername())).thenReturn("asher@10p.com");
        Mockito.when(signUpView.getPassword()).thenReturn("123test");
        Mockito.when(signUpView.getConfirmPassword()).thenReturn("123test");

        signUpPresenter.onSignUpClicked();

        Mockito.verify(signUpView).showPasswordError();
    }

    @Test
    public void showErrorMessage_ConfirmPasswordInvalid() throws Exception
    {
        Mockito.when((signUpView.getUsername())).thenReturn("asher@10p.com");
        Mockito.when(signUpView.getPassword()).thenReturn("Test@123");
        Mockito.when(signUpView.getConfirmPassword()).thenReturn("Test123");

        signUpPresenter.onSignUpClicked();

        Mockito.verify(signUpView).showConfirmPasswordError();
    }

    @Test
    public void showErrorMessage_PasswordsDontMatch() throws Exception
    {
        Mockito.when((signUpView.getUsername())).thenReturn("asher@10p.com");
        Mockito.when(signUpView.getPassword()).thenReturn("Test@123");
        Mockito.when(signUpView.getConfirmPassword()).thenReturn("123@Test");

        signUpPresenter.onSignUpClicked();

        Mockito.verify(signUpView).showConfirmPasswordError();
    }


    @Test
    public void showErrorMessage_loginFailed() throws Exception
    {


        Mockito.when((signUpView.getUsername())).thenReturn("asher@10p.com");
        Mockito.when(signUpView.getPassword()).thenReturn("123@Test");
        Mockito.when(signUpView.getConfirmPassword()).thenReturn("123@Test");

        signUpPresenter.onSignUpClicked();

        Mockito.verify(signUpView).onSignUpFailure(R.string.signup_failed);
    }

    @Test
    public void showErrorMessage_loginSuccess() throws Exception
    {


        Mockito.when((signUpView.getUsername())).thenReturn("asher@10p.com");
        Mockito.when(signUpView.getPassword()).thenReturn("Test@123");
        Mockito.when(signUpView.getConfirmPassword()).thenReturn("Test@123");

        signUpPresenter.onSignUpClicked();

        Mockito.verify(signUpView).onSignUpSuccess();
    }
}
