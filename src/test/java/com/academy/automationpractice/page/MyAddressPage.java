package com.academy.automationpractice.page;

import com.academy.core.BasePage;
import com.academy.core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAddressPage extends BasePage {
    @FindBy(css = "#center_column > div.addresses > div > div > ul > li:nth-child(1) > h3")
    private WebElement myAddress1;

    public MyAddressPage(WebDriver driver) {
        super(driver);
    }
    public String getMyAddress1() {return myAddress1.getText().trim();}
}
