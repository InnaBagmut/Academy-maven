package com.academy.automationpractice.page;

import com.academy.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyPersonalInfoPage extends BasePage {

    private WebDriver driver;

    @FindBy(css = "#center_column > div > div:nth-child(1) > ul > li:nth-child(4) > a > span")
    private WebElement myPersonalInfoBtn;

    @FindBy(id = "id_gender1")
    private WebElement genderMaleRadioBtn;

    @FindBy(id = "id_gender2")
    private WebElement genderFemaleRadioBtn;

    public MyPersonalInfoPage(WebDriver driver) {
        super(driver);
    }

    public MyPersonalInfoPage(WebDriver driver, String baseUrl) {
        super(driver, baseUrl);
    }

    public MyPersonalInfoPage clickMyInfoBtn() {
        myPersonalInfoBtn.click();
        return this;
    }

    public MyPersonalInfoPage clickMyMrBtn() {
        genderMaleRadioBtn.click();
        return this;
    }

}
