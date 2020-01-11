package com.academy.automationpractice;

import com.academy.automationpractice.dataProviders.User;
import com.academy.automationpractice.page.HomePage;
import com.academy.automationpractice.page.LoginPage;
import com.academy.automationpractice.page.MyPersonalInfoPage;
import com.academy.core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class MyPersonalInfo extends BaseTest {

    private final User user = new User(User.UserList.USER_1);

    @Override
    public void onException(Throwable err, WebDriver driver) {
    }

    @Test
    public void myPersonalInfoTest() {
        LoginPage myObject1 = new HomePage(driver, baseUrl)
                .goToHome()
                .clickSignIn()
                .autрorize(user);

        MyPersonalInfoPage myObject2 = new MyPersonalInfoPage(driver)
                .clickMyInfoBtn()
                .clickMyMrBtn();
    }

}
