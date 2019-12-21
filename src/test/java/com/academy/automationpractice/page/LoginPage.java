package com.academy.automationpractice.page;

import com.academy.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwInput;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLogin;

    @FindBy(css="#center_column > div.alert.alert-danger > ol > li")
    private WebElement errMsgElement;


    public LoginPage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
        //PageFactory.initElements(driver, this);
    }

    public LoginPage fillEmail(String email) {
        //emailInput.click();
        //emailInput.clear();
        //emailInput.sendKeys(email);
        fillImput(emailInput, email); //now it's just one basic method in BasePage class
        return this;
    }

    public LoginPage fillPassw(String passw) {
        //submitLogin.click();
        fillImput(passwInput, passw);
        return this;
    }

    public LoginPage clickSubmit() {
        submitLogin.click();
        return this;
    }

    //empty constructor - can be used in test for example like using the cucumber scenario
    public LoginPage and() {
        return this;
    }

    public String getErrMsg() {
        return errMsgElement.getText().trim();
    }
}
