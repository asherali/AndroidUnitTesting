package com.tenpearls.unittesttraining.login;

import android.content.Intent;

import com.tenpearls.unittesttraining.BuildConfig;
import com.tenpearls.unittesttraining.MainActivity;

import org.apache.tools.ant.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static org.robolectric.Shadows.shadowOf;

/**
 * Created by tahir.mahmood on 9/20/2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class RobolectricLoginActivityTest {

    LoginActivity loginActivity;

    @Before
    public void setUp() throws Exception {

        loginActivity = Robolectric.setupActivity(LoginActivity.class);
    }

    @Test
    public void credential_Validation_Correct_Credentials() throws Exception {

        Assert.assertTrue(loginActivity.isValidLoginCredentials("asher@email.com", "Test@123"));
    }

    @Test
    public void credential_Validation_Wrong_Email_Credentials() throws Exception {

        Assert.assertFalse(loginActivity.isValidLoginCredentials("ashe r@email.com", "Test@123"));
    }

    @Test
    public void clickingLogin_shouldStartMainActivity() {

        loginActivity.startNextActivity();
        Intent expectedIntent = new Intent(loginActivity, MainActivity.class);
        Assert.assertTrue(shadowOf(loginActivity).getNextStartedActivity().filterEquals(expectedIntent));
    }
}