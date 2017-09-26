package com.tenpearls.unittesttraining.pojo;

import android.os.Parcel;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by asher.ali on 9/26/2017.
 */
@RunWith(AndroidJUnit4.class)
public class UserInstrumentedTest {

    User user;

    @Before
    public void setUp() throws Exception {
        user = new User("asherali@10p.com", "Test@123");
    }

    @Test
    public void test_is_user_parcelable()
    {
        // Obtain a Parcel object and write the parcelable object to it
        Parcel parcel = Parcel.obtain();
        user.writeToParcel(parcel, user.describeContents());

        // After you're done with writing, you need to reset the parcel for reading
        parcel.setDataPosition(0);

        // Reconstruct object from parcel and asserts for confirmation
        User createdFromParcel = User.CREATOR.createFromParcel(parcel);
        assertThat(createdFromParcel.getUserName(), is("asherali@10p.com"));
        assertThat(createdFromParcel.getPassword(), is("Test@123"));
    }


    @After
    public void tearDown() throws Exception {
        user = null;
    }

}