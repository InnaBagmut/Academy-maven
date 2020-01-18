package com.academy.selenide;

import com.academy.selenide.page.HomePage;
import com.academy.selenide.page.SubscribersPage;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class AddSubscriberThroughArray {
    @BeforeClass
    public void setUp() {
        baseUrl = "http://localhost:8081";
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }
    @Test
    public void createSubscriber() {
        SubscribersPage subscribers = open(baseUrl, HomePage.class)
                .goToSubscribers()
                .clickAdd()
                .fillFirstName("Test")
                .fillLastName("Simple")
                .submit();
    }

    @AfterClass
    public void tearDown() {
        closeWebDriver();
    }

}
