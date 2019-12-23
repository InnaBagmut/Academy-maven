package com.academy.automationpractice;

import com.academy.automationpractice.page.HomePage;
import com.academy.automationpractice.page.LoginPage;
import com.academy.core.BaseTest;
import com.google.common.io.Files;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginFromFileViaPO extends BaseTest {
    private final static Logger LOG = LogManager.getLogger(LoginFromFileViaPO.class.getName());

    @Test(dataProvider = "incorrectAuthDataProvider")
    public void testIncorrectLogin(String login, String password, String expectedErrMsg) {
        LOG.info("start testIncorrectLogin");
//        driver.get(baseUrl);
//        WebElement signInButton = driver.findElement(By.linkText("Sign in"));
//        signInButton.click();
//        driver.findElement(By.id("email")).click();
//        driver.findElement(By.id("email")).clear();
//        driver.findElement(By.id("email")).sendKeys(login); // "qwerty"
//        driver.findElement(By.id("passwd")).click();
//        driver.findElement(By.id("passwd")).clear();
//        driver.findElement(By.id("passwd")).sendKeys(password);
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Forgot your password?'])[1]/following::span[1]")).click();

        // 1 способ - длинный
//        HomePage homePage = new HomePage(driver, baseUrl);
//        homePage = homePage.goToHome();
//        LoginPage loginPage = homePage.clickSignIn();
//        loginPage = loginPage.fillEmail(login);
//        loginPage = loginPage.fillPassword(password);
//        loginPage = loginPage.clickSubmit();
//        String actualErrMsg = loginPage.getErrMsg();
//
//        Assert.assertEquals(actualErrMsg, expectedErrMsg);

        // 2 способ - длинный
        LoginPage loginPage = new HomePage(driver, baseUrl)
                .goToHome()
                .then()
                .clickSignIn()
                .fillEmail(login)
                .and()
                .fillPassw(password)
                .clickSubmit();

        String actualErrMsg = loginPage.getErrMsg();
        Assert.assertEquals(actualErrMsg, expectedErrMsg);

        LOG.info("finished testIncorrectLogin");
    }

    @DataProvider(name = "incorrectAuthDataProvider")
    public Object[][] incorrectAuthDataProvider() throws IOException {
        String file = properties.getProperty("data.dir") + "/automationpractice-auth-data.csv";
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        List<String> data = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.trim().startsWith("#"))
                data.add(line);
        }
        br.close();
        fr.close();

        LOG.debug("****List****");
        LOG.debug(data);

        Object[][] result = new Object[data.size()][3];
        for (int i = 0; i < data.size(); i++) {
            result[i] = data.get(i).split(",");
        }
        LOG.debug("****Array****");
        LOG.debug(Arrays.deepToString(result));
        return result;
    }
    @Override
    public void onException(Throwable err, WebDriver driver) {
        LOG.error("Error occurs: {}", err.getMessage());

        makeScreenshot(driver);
    }

    private void makeScreenshot(WebDriver driver) {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenName = "screen_" + System.currentTimeMillis()+".png";
        String screenPath =  "D:/temp/screenshots/" + screenName;
        File screen = new File(screenPath);
        try {
            Files.copy(tmp, screen);
        } catch (IOException exc) {
            LOG.error("Error copying screenshot from '{}' to '{}'. Details: {}",
                    tmp, screen, exc);
        }
    }
}
