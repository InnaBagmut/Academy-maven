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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AuthenticationSuccessfull {
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws IOException {
        Properties properties = new Properties();
        // вычитываем файл *.properties из директории <root>/src/main/java/resources
        properties.load(this.getClass().getClassLoader().getResourceAsStream("automationpractice.properties"));
        // Инициализируем драйвер Chrome
        System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver"));
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        baseUrl = properties.getProperty("baseUrl");
        // Неявное ожидание (Implicit Waits)
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(300, 200));
    }

    @Test
    public void authSuccessfull() throws InterruptedException {
        // Попасть на главную страницу
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]")).click();
        driver.findElement(By.id("email")).sendKeys("innasamus@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("123456");
        driver.findElement(By.id("SubmitLogin")).click();

        WebElement contactUsButton = driver.findElement(By.id("contact-link"));
        String contactUsText = contactUsButton.getText().trim();
        Assert.assertEquals(contactUsText, "Contact us");

        WebElement signOutButton = driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a"));
        String signOutText = signOutButton.getText().trim();
        Assert.assertEquals(signOutText, "Sign out");

        WebElement userNameButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"));
        String userNameText = userNameButton.getText().trim();
        Assert.assertEquals(userNameText, "Инна Багмут");

        signOutButton.click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        // Закрываем браузер (все окна)
        driver.quit();
    }
}
