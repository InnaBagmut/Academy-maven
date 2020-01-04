package com.academy.automationpractice;

import com.academy.automationpractice.page.HomePage;
import com.academy.automationpractice.page.LoginPage;
import com.academy.automationpractice.page.MyAddressPage;
import com.academy.core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddAddress extends BaseTest {
    @Override
    public void onException(Throwable err, WebDriver driver) {
    }

    @Test
    public void addAddressTest() {

        LoginPage myObject1 = new HomePage(driver, baseUrl)
                .goToHome()
                .clickSignIn()
                .fillEmail("innasamus@gmail.com")
                .fillPassw("123456")
                .clickSubmit();

        MyAddressPage myObject2 = new MyAddressPage(driver)
                .clickOnMyAddresses()
                .clickAddAddress()
                .clickOnSubmit();

        BaseTest myObject3 = new BaseTest() {
            @Override
            public void onException(Throwable err, WebDriver driver) {
            }
        };
        // myObject3.clickOnElement();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
