package com.tenpearls.unittesttraining.signup;

  public class SignUpService {

     boolean signUp(String username, String password)
    {
        return "asher@10p.com".equals(username) && "Test@123".equals(password);
    }
}
