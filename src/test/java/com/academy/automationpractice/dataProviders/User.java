package com.academy.automationpractice.dataProviders;
import com.academy.automationpractice.properties.Properties;
//import static com.academy.automationpractice.dataProviders.User.UserList.USER_1;

public class User {

    private final UserList user;

    public User(UserList user) {
        this.user = user;
    }

    public enum UserList {
        USER_1,
        USER_2,
        USER_3
    }

   public String getLogin() {
        switch (user) {
            case USER_1: return Properties.props.user1Login();
            default: return null;
        }
    }

    public String getPassw() {
        switch (user) {
            case USER_1: return Properties.props.user1Passw();
            default: return null;
        }
    }
}
