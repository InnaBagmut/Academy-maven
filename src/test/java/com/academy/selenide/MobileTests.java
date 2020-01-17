package com.academy.selenide;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
//import static com.codeborne.selenide.Selectors;
//import static com.codeborne.selenide.Selenide;

public class MobileTests {

    @BeforeClass
    public void setUp() {
        baseUrl = "http://localhost:8081";
        Configuration.timeout = 3000;
// Configuration.browser = "com.academy.selenide.configuration.GeckoDriverProvider";
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
    }

    @Test
    public void testCreateSubscriber() {
        open(baseUrl);
        $(byPartialLinkText("Subscribers")).click();
// WebDriver driver = WebDriverRunner.getWebDriver();
// List<WebElement> elements = driver.findElements(By.xpath("//td[4]"));
// List<String> lastNames = new ArrayList<>();
// for (WebElement item : elements) {
// lastNames.add(item.getText());
// }
        List<String> lastNamesBefore = Selenide.$$(byXpath("//td[4]")).texts();
        System.out.println(lastNamesBefore);

        $(byId("add")).click();
        $(byId("fname")).setValue("FirstName");
        $(byId("lname")).setValue("LastName");
        $(byId("FEMALE")).click();
        $(byId("age")).clear();
        $(byId("age")).sendKeys("23");
        $(byXpath("id")).click();

        List<String> lastNamesAfter = Selenide.$$(byXpath(("//td[4]"))).texts();

        Assert.assertEquals(lastNamesBefore.size() + 1, lastNamesAfter.size());

        lastNamesBefore.add("LastName");
        Collections.sort(lastNamesBefore);
        Collections.sort(lastNamesAfter);

        Assert.assertEquals(lastNamesBefore, lastNamesAfter);
        sleep(3000);
    }

    @AfterClass
    public void tearDown() {
        close();
    }
}