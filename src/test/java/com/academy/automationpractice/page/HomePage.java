package com.academy.automationpractice.page;

import com.academy.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(linkText = "Sign in")
    private WebElement signInButton;

    public HomePage(WebDriver driver, String baseUrl) {
        super(driver, baseUrl);
    }

    public HomePage goToHome() {
        driver.get(baseUrl);
        return this;
    }

    public LoginPage clickSignIn() {
        signInButton.click();
        return new LoginPage(driver);
    }

    //empty constructor - can be used in test for example like using the cucumber scenario
    public HomePage then() {
        return this;
    }
}
