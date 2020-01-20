package com.academy.core;

import com.academy.core.listener.WebDriverEventListenerImpl;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    //protected WebDriver driver;
    protected EventFiringWebDriver driver;
    protected String baseUrl;
    protected Properties properties;
    private final static Logger LOG = LogManager.getLogger(BaseTest.class.getName());

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) throws IOException {
        properties = new Properties();
        // вычитываем файл *.properties из директории <root>/src/main/java/resources
        properties.load(this.getClass().getClassLoader().getResourceAsStream("common.properties"));
        baseUrl = properties.getProperty("baseUrl");
        // Инициализируем драйвер
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver"));
                //driver = new ChromeDriver();
                driver = new EventFiringWebDriver(new ChromeDriver());
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("firefox.driver"));
                //driver = new FirefoxDriver();
                driver = new EventFiringWebDriver(new FirefoxDriver());
                break;
        }

        driver.register(new WebDriverEventListenerImpl());

        // Неявное ожидание (Implicit Waits)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        // Закрываем браузер (все окна)
        driver.quit();
    }
    @BeforeMethod
    public void beforeMethod(Method method, Object[] params) {
        LOG.info("Start test {} with parameters {}",
                method.getName(), Arrays.toString(params));
    }

    @AfterMethod
    public void afterMethod(Method method) {
        LOG.info("Finished test {}",
                method.getName());
    }

    public abstract void onException(Throwable err, WebDriver driver);

    @Attachment(value = "Page screenshot", type="image/png")
    public byte[] saveScreenshotPNG() {
        return driver.getScreenshotAs(OutputType.BYTES);
    }
}
