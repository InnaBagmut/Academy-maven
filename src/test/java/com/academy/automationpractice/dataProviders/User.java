package com.academy.automationpractice.dataProviders;

public class User {

    private final User user;

    public User(User user) {
        this.user = user;
    }

    public enum Users {
        USER_1,
        USER_2,
        USER_3
    }

/*    public String getCreds() {
        switch (user) {
            //case Users.USER_1: return Propetries.props.user1Login();
        }
    }*/
}
