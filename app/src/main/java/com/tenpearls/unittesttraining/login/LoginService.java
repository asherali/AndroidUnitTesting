package com.tenpearls.unittesttraining.login;

  public class LoginService {

     boolean login(String username, String password)
    {
        return "asher@ali.com".equals(username) && "Test@123".equals(password);
    }
}
