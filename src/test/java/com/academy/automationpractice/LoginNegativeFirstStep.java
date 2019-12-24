package com.academy.automationpractice;


import java.util.Properties;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginNegativeFirstStep {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("automationpractice.properties"));
        System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver"));
        driver = new ChromeDriver();
        baseUrl = "http://automationpractice.com/index.php";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("rtretyrer@mail.tu");
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("erewtrwt");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Forgot your password?'])[1]/following::span[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Authentication'])[2]/following::li[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Authentication'])[2]/following::p[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Authentication'])[2]/following::div[1]")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | xpath=(.//*[normalize-space(text()) and normalize-space(.)='Authentication'])[2]/following::div[1] | ]]
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Authentication'])[2]/following::div[1]")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}

