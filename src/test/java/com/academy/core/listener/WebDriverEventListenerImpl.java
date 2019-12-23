package com.academy.core.listener;

import com.google.common.io.Files;
import com.google.protobuf.compiler.PluginProtos;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.io.File;

public class WebDriverEventListenerImpl extends AbstractWebDriverEventListener {
    @Override
    public void beforeNavigateBack(WebDriver driver) {
        super.beforeNavigateBack(driver);
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        super.afterNavigateBack(driver);
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        super.beforeNavigateRefresh(driver);
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        super.afterNavigateRefresh(driver);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        super.beforeClickOn(element, driver);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        super.afterClickOn(element, driver);
    }

  /*  @Override
    public void onException(Throwable err, WebDriver driver) {
        LOG.error("Error occurs: {}", err.getMessage());

        makeScreenshot(driver);
    }

    private void makeScreenshot(WebDriver driver) {
        PluginProtos.CodeGeneratorResponse.File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenName = "screen_" + System.currentTimeMillis()+".png";
        String screenPath =  "D:/temp/screenshots/" + screenName;
        PluginProtos.CodeGeneratorResponse.File screen = new File(screenPath);
        try {
            Files.copy(tmp, screen);
        } catch (IOException exc) {
            LOG.error("Error copying screenshot from '{}' to '{}'. Details: {}",
                    tmp, screen, exc);
        }
    }*/
}
