package com.academy.automationpractice.page;

import com.academy.automationpractice.MyAddress;
import com.academy.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MyAddressPage extends BasePage {
    @FindBy(css = "#center_column > div > div:nth-child(1) > ul > li:nth-child(3) > a > span")
    private WebElement myAddresses;

    @FindBy(css = "#center_column > div.addresses > div > div > ul > li:nth-child(1) > h3")
    private WebElement myAddress1;

    @FindBy(css = "#center_column > div.clearfix.main-page-indent > a > span")
    private WebElement addAddressBtn;

    @FindBy(id = "firstname")
    private WebElement firstNameInput;

    @FindBy(id = "lastname")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement addressMainInput;

    @FindBy(id = "address2")
    private WebElement addressAdditionalInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "id_state")
    private WebElement stateInput;

    @FindBy(id = "postcode")
    private WebElement zipCodeInput;

    @FindBy(id = "id_country")
    private WebElement countryInput;

    @FindBy(id = "phone")
    private WebElement homePhoneInput;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneInput;

    @FindBy(id = "other")
    private WebElement additionalInfoInput;

    @FindBy(id = "alias")
    private WebElement addressTitleInput;

    @FindBy(id = "submitAddress")
    private WebElement submitBtn;

    Actions actions = new Actions(driver);


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

    public MyAddressPage fillFirstName(String firstName) {
        fillInput(firstNameInput, firstName);
        return this;
    }

    public MyAddressPage fillLastName(String lastName) {
        fillInput(lastNameInput, lastName);
        return this;
    }

    public MyAddressPage fillCompany(String company) {
        fillInput(companyInput, company);
        return this;
    }

    public MyAddressPage fillAddressMain(String addressMain) {
        fillInput(addressMainInput, addressMain);
        return this;
    }

    public MyAddressPage fillAddressAdditional(String addressAdditional) {
        fillInput(addressAdditionalInput, addressAdditional);
        return this;
    }

    public MyAddressPage fillCity(String city) {
        fillInput(cityInput, city);
        return this;
    }

    public MyAddressPage chooseState() {
/*        stateInput.click();
        actions.keyDown("H")
                .perform();*/
        Select dropDown = new Select(stateInput);
        dropDown.selectByVisibleText("Colorado");
        return this;
    }

    public MyAddressPage fillZipCode(String zipCode) {
        fillInput(zipCodeInput, zipCode);
        return this;
    }

    public MyAddressPage chooseCountry() {
        Select dropDown = new Select(countryInput);
        dropDown.selectByVisibleText("United States");
        return this;
    }

    public MyAddressPage fillHomePhone(String homePhone) {
        fillInput(homePhoneInput, homePhone);
        return this;
    }

    public MyAddressPage fillMobilePhone(String mobilePhone) {
        fillInput(mobilePhoneInput, mobilePhone);
        return this;
    }

    public MyAddressPage fillAdditionalInfo(String additionalInfo) {
        fillInput(addressAdditionalInput, additionalInfo);
        return this;
    }

    public MyAddressPage fillAddressTitle(String addressTitle) {
        fillInput(addressTitleInput, addressTitle);
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
