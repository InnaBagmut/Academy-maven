package com.academy.automationpractice.page;

import com.academy.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAddressPage extends BasePage {
    @FindBy(css = "#center_column > div > div:nth-child(1) > ul > li:nth-child(3) > a > span")
    private WebElement myAddresses;

    @FindBy(css = "#center_column > div.addresses > div > div > ul > li:nth-child(1) > h3")
    private WebElement myAddress1;

    @FindBy(css = "#center_column > div.clearfix.main-page-indent > a > span")
    private WebElement addAddressBtn;

    @FindBy(id = "company")
    private WebElement companyField;

    @FindBy(id = "submitAddress")
    private WebElement submitBtn;

    public MyAddressPage(WebDriver driver) {
        super(driver);
    }

    public MyAddressPage clickOnMyAddresses() {
        myAddresses.click();
        return this;
    }

    public MyAddressPage clickAddAddress() {
        clickOnElement(addAddressBtn);
        return this;
    }

    public MyAddressPage fillCompany() {
        fillInput(companyField, "Fairytale");
        return this;
    }

    public MyAddressPage clickOnSubmit() {
        clickOnElement(submitBtn);
        return this;
    }

    public String getMyAddress1() {
        return myAddress1.getText().trim();
    }
}
