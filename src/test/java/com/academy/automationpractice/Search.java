package com.academy.automationpractice;

import com.academy.automationpractice.page.HomePage;
import com.academy.automationpractice.page.SearchPage;
import com.academy.core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Search extends BaseTest {
    @Override
    public void onException(Throwable err, WebDriver driver) {}

    @Test
    public void testSearch() {

       // SearchPage myObject = new HomePage(driver, baseUrl);
    }

}
