package com.tenpearls.unittesttraining;

import com.tenpearls.unittesttraining.utils.ValidationUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by asher.ali on 8/21/2017.
 *
 *
 */

public class LoginTest {


    //// Email Validation ////


    @Test
    public void emailValidation_CorrectEmailSimple_ReturnsTrue() {
        Assert.assertTrue(ValidationUtil.isValidEmailAddress("asher@email.com"));
    }

    @Test
    public void emailValidation_CorrectEmailSubDomain_ReturnsTrue() {
        Assert.assertTrue(ValidationUtil.isValidEmailAddress("asher@email.co.uk"));
    }

    @Test
    public void emailValidation_InvalidEmailNoTld_ReturnsFalse() {
        Assert.assertFalse(ValidationUtil.isValidEmailAddress("asher@email"));
    }

    @Test
    public void emailValidation_InvalidEmailDoubleDot_ReturnsFalse() {
        Assert.assertFalse(ValidationUtil.isValidEmailAddress("asher@email..com"));
    }

    @Test
    public void emailValidation_InvalidEmailNoUsername_ReturnsFalse() {
        Assert.assertFalse(ValidationUtil.isValidEmailAddress("@email.com"));
    }

    @Test
    public void emailValidation_EmptyString_ReturnsFalse() {
        Assert.assertFalse(ValidationUtil.isValidEmailAddress(""));
    }

    @Test
    public void emailValidation_NullEmail_ReturnsFalse() {
        Assert.assertFalse(ValidationUtil.isValidEmailAddress(null));
    }

    // Password validation //

    @Test
    public void passwordValidation_correctPassword_ReturnsTrue()
    {
        Assert.assertTrue(ValidationUtil.isValidPassword("Test@123"));
    }
    @Test
    public void passwordValidation_noDigit_ReturnsFalse()
    {
        Assert.assertFalse(ValidationUtil.isValidPassword("Test@abc"));
    }
    @Test
    public void passwordValidation_noLowerCaseLetter_ReturnsFalse()
    {
        Assert.assertFalse(ValidationUtil.isValidPassword("TEST@123"));
    }
    @Test
    public void passwordValidation_noUpperCaseLetter_ReturnsFalse()
    {
        Assert.assertFalse(ValidationUtil.isValidPassword("test@123"));
    }
    @Test
    public void passwordValidation_noSpecialCharacter_ReturnsFalse()
    {
        Assert.assertFalse(ValidationUtil.isValidPassword("Test1234"));
    }
    @Test
    public void passwordValidation_whitespaceExist_returnsFalse()
    {
        Assert.assertFalse(ValidationUtil.isValidPassword("Test @123"));
    }

    @Test
    public void passwordValidation_passwordUnderLimit_returnsFalse()
    {
        Assert.assertFalse(ValidationUtil.isValidPassword("Test@12"));
    }

    @Test
    public void passwordValidation_passwordEmpty_returnsFalse()
    {
        Assert.assertFalse(ValidationUtil.isValidPassword(""));
    }

    @Test
    public void passwordValidation_passwordNull_returnsFalse()
    {
        Assert.assertFalse(ValidationUtil.isValidPassword(null));
    }
}
