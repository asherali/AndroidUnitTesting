package com.tenpearls.unittesttraining.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by asher.ali on 8/29/2017.
 */

public class ValidationUtil
{
    public static boolean isValidEmailAddress (CharSequence emailAddress) {

        if (emailAddress == null)
        return false;

        Pattern pattern;
        Matcher matcher;
        String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile (emailPattern);
        matcher = pattern.matcher (emailAddress);
        return matcher.matches ();
    }

  /*
        ^                 # start-of-string
        (?=.*[0-9])       # a digit must occur at least once
        (?=.*[a-z])       # a lower case letter must occur at least once
        (?=.*[A-Z])       # an upper case letter must occur at least once
        (?=.*[@#$%^&+=])  # a special character must occur at least once
        (?=\S+$)          # no whitespace allowed in the entire string
        .{8,}             # anything, at least eight places though
    $                 # end-of-string

  */

    public static boolean isValidPassword (CharSequence password) {

        if (password == null)
            return false;

        Pattern pattern;
        Matcher matcher;
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        pattern = Pattern.compile (passwordPattern);
        matcher = pattern.matcher (password);
        return matcher.matches ();
    }
}
