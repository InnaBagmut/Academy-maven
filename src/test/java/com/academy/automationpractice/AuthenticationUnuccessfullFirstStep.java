/*2)	Реализовать автотест неуспешной аутентификации для сайта automationpractice.com:

        Сценарий:
        - перейти по ссылке http://automationpractice.com/index.php
        - cделать клик по ссылке вверху 'Sign in'
        - заполнить некорректными значениями поля 'Email address' и 'Password'
        - нажать зеленую кнопку внизу 'Sign in'
        - убедиться, что на красном фоне отображается соответствующее сообщение об ошибке

        (проверить на всех вариантах значений логина, пароля и сообщения об ошибке из подготовленного
        на предыдущих занятиях файла automationpractice-auth-data.xlsx )

        (см. скриншоты в директории '02_auth_unsuccessfull')*/

package com.academy.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AuthenticationUnuccessfullFirstStep {
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
        driver.get(baseUrl);

        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]")).click();
        driver.findElement(By.id("email")).sendKeys("erwhutoiwhjmail.ru");
        driver.findElement(By.id("passwd")).sendKeys("123456");
        driver.findElement(By.id("SubmitLogin")).click();
        WebElement validMsg1 = driver.findElement(By.cssSelector("#center_column > div.alert.alert-danger > ol > li"));
        String validMsg1Text = validMsg1.getText().trim();
        Assert.assertEquals(validMsg1Text, "Invalid email address.");

        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]")).click();
        driver.findElement(By.id("email")).sendKeys("inna_samus@mail.ru");
        driver.findElement(By.id("passwd")).sendKeys("1234567");
        driver.findElement(By.id("SubmitLogin")).click();
        WebElement validMsg2 = driver.findElement(By.cssSelector("#center_column > div.alert.alert-danger > ol > li"));
        String validMsg2Text = validMsg2.getText().trim();
        Assert.assertEquals(validMsg2Text, "Authentication failed.");

        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]")).click();
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.id("passwd")).sendKeys("123456");
        driver.findElement(By.id("SubmitLogin")).click();
        WebElement validMsg3 = driver.findElement(By.cssSelector("#center_column > div.alert.alert-danger > ol > li"));
        String validMsg3Text = validMsg3.getText().trim();
        Assert.assertEquals(validMsg3Text, "An email address required.");

        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]")).click();
        driver.findElement(By.id("email")).sendKeys("ewfgwew@mail.ru");
        driver.findElement(By.id("passwd")).sendKeys("");
        driver.findElement(By.id("SubmitLogin")).click();
        WebElement validMsg4 = driver.findElement(By.cssSelector("#center_column > div.alert.alert-danger > ol > li"));
        String validMsg4Text = validMsg4.getText().trim();
        Assert.assertEquals(validMsg4Text, "Password is required.");

    }
}
