package com.academy.automationpractice;

import com.academy.automationpractice.page.HomePage;
import com.academy.automationpractice.page.LoginPage;
import com.academy.automationpractice.page.MyAddressPage;
import com.academy.core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddAddress extends BaseTest {
    @Override
    public void onException(Throwable err, WebDriver driver) {
    }

    @Test(dataProvider = "addAddressDataProvider")
    public void addAddressTest(String firstName, String lastName, String company, String addressMain,
                               String addressAdditional, String city, String zipCode, String homePhone,
                               String mobilePhone, String additionalInfo, String addressTitle) {

        LoginPage myObject1 = new HomePage(driver, baseUrl)
                .goToHome()
                .clickSignIn()
                .fillEmail("innasamus@gmail.com")
                .fillPassw("123456")
                .clickSubmit();

        MyAddressPage myObject2 = new MyAddressPage(driver)
                .clickOnMyAddresses()
                .clickAddAddress()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillCompany(company)
                .chooseState()
                .fillAddressMain(addressMain)
                .fillAddressAdditional(addressAdditional)
                .fillCity(city)
                .fillZipCode(zipCode)
                .fillHomePhone(homePhone)
                .fillMobilePhone(mobilePhone)
                .fillAdditionalInfo(additionalInfo)
                .fillAddressTitle(addressTitle)
                .clickOnSubmit();

        BaseTest myObject3 = new BaseTest() {
            @Override
            public void onException(Throwable err, WebDriver driver) {
            }
        };
        // myObject3.clickOnElement();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @DataProvider(name = "addAddressDataProvider")
    public Object[][] addAddressDataProvider() throws IOException {
        String file = properties.getProperty("data.dir") + "/addAddressDataWithoutStateAndCountry.csv";
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        List<String> data = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null)
            if(!line.trim().startsWith("#"))
                data.add(line);
            br.close();
            fr.close();

            Object[][] result = new Object[data.size()][12];
        for (int i = 0; i < data.size(); i++) {
            result[i] = data.get(i).split(",");
        }
            return result;
    }

}
