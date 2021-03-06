package com.academy.automationpractice.homework15;

import com.academy.core.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login extends BaseTest {
    //private final static Logger LOG = LogManager.getLogger(login);

    @Test(dataProvider = "testValidMessages")
    public void login(String login, String password, String errMsg) throws InterruptedException {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(login);
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();
        WebElement validMsg = driver.findElement(By.cssSelector("#center_column > div.alert.alert-danger > ol > li"));
        String validMsgText = validMsg.getText().trim();
        Assert.assertEquals(validMsgText, errMsg);

    }

    @DataProvider(name = "testValidMessages")
    public Object[] testValidMessages() {
        return new Object[][]{
                {"qwerty", "1234", "Invalid email address."},
                {"inna_samus@mail.ru", "1234567", "Authentication failed."},
                {"weqrqwwq@mail.ru", "123456", "Authentication failed."},
                {"", "123456", "An email address required."},
                {"a@mail.ru", "", "Password is required."},
                {"", "", "An email address required."}
        };
    }

    @Override
    public void onException(Throwable err, WebDriver driver) {

    }
}
