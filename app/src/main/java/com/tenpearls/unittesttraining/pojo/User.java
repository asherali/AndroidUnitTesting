package com.tenpearls.unittesttraining.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by asher.ali on 9/26/2017.
 */

public class User implements Parcelable {

    private String userName;
    private String password;

    public User() {

    }


    public User(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }

     public User(Parcel in) {
        userName = in.readString();
        password = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(userName);
        parcel.writeString(password);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
