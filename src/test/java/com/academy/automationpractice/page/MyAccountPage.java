package com.academy.automationpractice.page;

import com.academy.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class MyAccountPage extends BasePage {
    //private WebDriver driver;

    @FindBy(css = "#center_column > div > div:nth-child(1) > ul > li:nth-child(3) > a > span")
    private WebElement myAddresses;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage clickOnMyAddresses() {myAddresses.click();
        return this;
    }
}
