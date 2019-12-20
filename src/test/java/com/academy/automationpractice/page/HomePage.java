package com.academy.automationpractice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;
    private String baseUrl;

    public HomePage(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
        PageFactory.initElements(driver, this);
    }

    public HomePage goToHome() {
        driver.get(baseUrl);
        return this;
    }

/*    public LoginPage loginPage() {

    }*/


}
