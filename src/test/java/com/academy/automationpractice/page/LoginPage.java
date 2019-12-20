package com.academy.automationpractice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passw")
    private WebElement passwInput;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLogin;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage fillEmail(String email) {
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage fillPassw(String passw) {
        submitLogin.click();
        return this;
    }
}
