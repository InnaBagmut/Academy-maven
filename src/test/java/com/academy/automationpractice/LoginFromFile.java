package com.academy.automationpractice;

import com.academy.core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginFromFile extends BaseTest {
    @Test(dataProvider = "incorrectAuthDataProvider")
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

        // TODO LOG
        System.out.println("****List");
        System.out.println(data);

        Object[][] result = new Object[data.size()][3];
        for (int i = 0; i < data.size(); i++) {
            result[i] = data.get(i).split(",");
        }
        System.out.println("****Array");
        System.out.println(Arrays.deepToString(result));
        return result;
    }

}
