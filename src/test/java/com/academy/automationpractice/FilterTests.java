package com.academy.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class FilterTests {
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws IOException {
        Properties commonProp = new Properties();
        Properties rozetkaProp = new Properties();
        // вычитываем файл *.properties из директории <root>/src/main/java/resources
        commonProp.load(this.getClass().getClassLoader().getResourceAsStream("common.properties"));
        rozetkaProp.load(this.getClass().getClassLoader().getResourceAsStream("rozetka.properties"));
        // Инициализируем драйвер Chrome
        System.setProperty("webdriver.chrome.driver", commonProp.getProperty("chrome.driver"));
        driver = new ChromeDriver();
        baseUrl = rozetkaProp.getProperty("baseUrl");
        // Неявное ожидание (Implicit Waits)
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testSlider() {
        driver.get(baseUrl);
        WebElement menuItem = driver.findElement(By.cssSelector("body > app-root > div > div:nth-child(2) > app-rz-main-page > div > aside > main-page-sidebar > sidebar-fat-menu > div > ul > li:nth-child(1) > a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuItem).perform();
        driver.findElement(By.partialLinkText("Мониторы")).click();
        WebElement leftBtn = driver.findElement(By.cssSelector("#trackbarprice > table > tbody > tr > td.lb > div > img"));
        actions.moveToElement(leftBtn)
                .clickAndHold()
                .moveByOffset(15, 0)
                .perform();
    }
}