package com.tenpearls.unittesttraining.signup;

/**
 * Created by asher.ali on 9/18/2017.
 */

public class SignUpPresenter implements SignUpContract.UserActionListener {

    private SignUpContract.View signUpView;

    public SignUpPresenter(SignUpContract.View view)
    {
        signUpView = view;

    }

    @Override
    public void onSignUpClicked() {
            //// TODO: 9/18/2017

    }
}
