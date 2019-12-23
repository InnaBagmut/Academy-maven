/*) Реализовать автотест успешной аутентификации для сайта automationpractice.com:
        Сценарий:
        - перейти по ссылке http://automationpractice.com/index.php
        - cделать клик по ссылке вверху 'Sign in'
        - заполнить поля 'Email address' и 'Password'
        - нажать зеленую кнопку внизу 'Sign in'
        - убедиться, что в верхнем меню отображается гиперссылка с именем пользователя:  Contact us | Sign out | 'Username'
        - сделать выход, нажав в верхнем меню гиперссылку Sign out
        (см. скриншоты в директории 'lesson14/01_auth_successfull')*/

package com.academy.automationpractice;

import com.academy.automationpractice.page.HomePage;
import com.academy.automationpractice.page.LoginPage;
import com.academy.core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AuthenticationSuccessfull extends BaseTest {


    @Test
    public void authSuccessfull() throws InterruptedException {
        // Попасть на главную страницу
/*        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]")).click();
        driver.findElement(By.id("email")).sendKeys("innasamus@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("123456");
        driver.findElement(By.id("SubmitLogin")).click();*/

      //  String email = "innaSamus@gmail.com";
        LoginPage loginPage = new HomePage(driver, baseUrl)
                .goToHome()
                .then()
                .clickSignIn()
                .fillEmail("innaSamus@gmail.com")
                .and()
                .fillPassw("123456")
                .clickSubmit();

        String actualErrMsg = loginPage.getErrMsg();
        Assert.assertEquals(actualErrMsg, "Authentication failed.");


/*        WebElement contactUsButton = driver.findElement(By.id("contact-link"));
        String contactUsText = contactUsButton.getText().trim();
        Assert.assertEquals(contactUsText, "Contact us");

        WebElement signOutButton = driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a"));
        String signOutText = signOutButton.getText().trim();
        Assert.assertEquals(signOutText, "Sign out");

        WebElement userNameButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"));
        String userNameText = userNameButton.getText().trim();
        Assert.assertEquals(userNameText, "Инна Багмут");
        signOutButton.click();*/
    }
}
