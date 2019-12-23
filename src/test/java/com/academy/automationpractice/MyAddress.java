package com.academy.automationpractice;

import com.academy.automationpractice.page.HomePage;
import com.academy.automationpractice.page.LoginPage;
import com.academy.automationpractice.page.MyAccountPage;
import com.academy.automationpractice.page.MyAddressPage;
import com.academy.core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAddress extends BaseTest {

    @Override
    public void onException(Throwable err, WebDriver driver) {
    }

    @Test
    public void myAddressTest() {
        LoginPage myObject1 = new HomePage(driver, baseUrl)
                .goToHome()
                .clickSignIn()
                .fillEmail("innasamus@gmail.com")
                .fillPassw("123456")
                .clickSubmit();
        MyAccountPage myObject2 = new MyAccountPage(driver)
                .clickOnMyAddresses();

        MyAddressPage myObject3 = new MyAddressPage(driver);
        String actualAddress1 = myObject3.getMyAddress1();
        Assert.assertEquals(actualAddress1, "HAHARINA AVENUE");
    }
}
