/*3) Реализовать автотест для сайта automationpractice.com:
        Сценарий:
        - перейти на главную страницу по ссылке: http://automationpractice.com
        - в меню (WOMEN | DRESSES | T-SHIRTS) кликнуть пункт 'WOMEN'
        - Сделать следующие проверки:
        1) страница title содержит слово "Women"
        2) навигатор страниц содержит пункт "women"
        3) слева над каталогом расположен раздел "WOMEN"
        4) по середение содержится текст с заголовком "Women" и содержимое текста начинается
        "You will find here all woman fashion..."
        5) наличие под текстом в середине категории "WOMEN" "There are 7 products". (Число 7 может быть другим)
        6) в футоре внизу наличие "Women" в пункте "Categories"

        (см. скриншоты в директории '03_category_women')

        4) 	Реализовать автотест фильтра для сайта automationpractice.com:
        - перейти на главную страницу по ссылке: http://automationpractice.com
        - в меню (WOMEN | DRESSES | T-SHIRTS) кликнуть пункт 'DRESSES'
        - выбрать checkbox Size -> S
        - выбрать checkbox Composition -> Cotton
        - Сделать следующие проверки:
        1) высвечивается только одна позиция "Printed Dress"
        - Перейти на карточку товара, кликнув по картинке
        - Проверить, что Size имеет значение S, а 'Composition' имеет значение'Cotton'

        (см. скриншоты в директории '04_filter_test')

        5) 	Реализовать автотест фильтра для сайта automationpractice.com:
        - перейти на главную страницу по ссылке: http://automationpractice.com
        - в меню (WOMEN | DRESSES | T-SHIRTS) кликнуть пункт 'DRESSES'
        - установить фильтр диапазон цены с помощью ползунка
        Price->Range,
        например от 30.00 до 40.00

        - Выполнить проверку:
        1) все позиции имеют цену заданного диапазона (напр. 30.00 до 40.00)
        (точные значения границ цен не важны)

        6) 	Реализовать автотест фильтра для сайта automationpractice.com:
        - перейти на главную страницу по ссылке: http://automationpractice.com
        - в меню (WOMEN | DRESSES | T-SHIRTS) кликнуть пункт 'DRESSES'
        - установить фильтр на цвет, например 'Orange'

        - выбрать checkbox Composition -> Cotton
        - Сделать следующие проверки:
        1) все позиции содержат цвет указанный в фильтре (напр. 'Orange')*/

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
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Filter {
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
    public void filter() throws InterruptedException {
        /*    3) Реализовать автотест для сайта automationpractice.com:
    Сценарий:
            - перейти на главную страницу по ссылке: http://automationpractice.com
            - в меню (WOMEN | DRESSES | T-SHIRTS) кликнуть пункт 'WOMEN'
            - Сделать следующие проверки:
            1) страница title содержит слово "Women"
            2) навигатор страниц содержит пункт "women"
            3) слева над каталогом расположен раздел "WOMEN"
            4) по середение содержится текст с заголовком "Women" и содержимое текста начинается
        "You will find here all woman fashion..."
            5) наличие под текстом в середине категории "WOMEN" "There are 7 products". (Число 7 может быть другим)
            6) в футоре внизу наличие "Women" в пункте "Categories"

            (см. скриншоты в директории '03_category_women')*/

        driver.get(baseUrl);
        driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a")).click();

        //3.1 страница title содержит слово "Women"
        WebElement titleWomen = driver.findElement(By.cssSelector("#columns > div.breadcrumb.clearfix > span.navigation_page"));
        String titleWomenText = titleWomen.getText().trim();
        Assert.assertEquals(titleWomenText, "Women");

        //3.2 навигатор страниц содержит пункт "women" - Option 1:
        WebElement womenButton = driver.findElement(By.cssSelector("#block_top_menu > ul > li.sfHoverForce > a"));
        Assert.assertSame(womenButton, womenButton);

        //3.2 навигатор страниц содержит пункт "women" - Option 2:
        boolean present;
        try {
            driver.findElement(By.cssSelector("#block_top_menu > ul > li.sfHoverForce > a"));
        } catch (NoSuchElementException e) {
            present = false;
        }

        //3.3 слева над каталогом расположен раздел "WOMEN"
        WebElement blockNameWomen = driver.findElement(By.cssSelector("#categories_block_left > h2"));
        String blockNameWomenText = blockNameWomen.getText().trim();
        Assert.assertEquals(blockNameWomenText, "WOMEN");

        //3.4 по середение содержится текст с заголовком "Women" и содержимое текста начинается
        //"You will find here all woman fashion..."

        WebElement categoryNameWomen = driver.findElement(By.cssSelector("#center_column > div.content_scene_cat > div > div > span"));
        String categoryNameWomenText = categoryNameWomen.getText().trim();
        Assert.assertEquals(categoryNameWomenText, "Women");

        WebElement elementUnderWomen = driver.findElement(By.cssSelector("#center_column > div.content_scene_cat > div > div > div > p:nth-child(1) > strong"));
        String elementUnderWomenText = elementUnderWomen.getText().trim();
        Assert.assertEquals(elementUnderWomenText, "You will find here all woman fashion collections.");

        //3.5 наличие под текстом в середине категории "WOMEN" "There are 7 products". (Число 7 может быть другим)
        WebElement middleTitle = driver.findElement(By.cssSelector("#center_column > h1 > span.cat-name"));
        String middleTitleText = middleTitle.getText().trim();
        Assert.assertEquals(middleTitleText, "WOMEN");

        WebElement displayNumberOfProducts = driver.findElement(By.cssSelector("#center_column > h1 > span.heading-counter"));
        String displayNumberOfProductsText = displayNumberOfProducts.getText().trim();
        Assert.assertEquals(displayNumberOfProductsText, "There are 7 products.");

        //3.6 в футоре внизу наличие "Women" в пункте "Categories"
        WebElement footerCategories = driver.findElement(By.cssSelector("#footer > div > section.blockcategories_footer.footer-block.col-xs-12.col-sm-2 > div > div > ul > li > a"));
        String footerCategoriesText = footerCategories.getText().trim();
        Assert.assertEquals(footerCategoriesText, "Women");

/*     4) 	Реализовать автотест фильтра для сайта automationpractice.com:
        - перейти на главную страницу по ссылке: http://automationpractice.com
        - в меню (WOMEN | DRESSES | T-SHIRTS) кликнуть пункт 'DRESSES'
                - выбрать checkbox Size -> S
                - выбрать checkbox Composition -> Cotton
                - Сделать следующие проверки:
        1) высвечивается только одна позиция "Printed Dress"
                - Перейти на карточку товара, кликнув по картинке
                - Проверить, что Size имеет значение S, а 'Composition' имеет значение'Cotton'
        (см. скриншоты в директории '04_filter_test')*/

        driver.get(baseUrl);
        driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a")).click();
        driver.findElement(By.id("layered_id_attribute_group_1")).click();
        driver.findElement(By.id("layered_id_feature_5")).click();
        //TODO: реализовать проверки

/*        5) 	Реализовать автотест фильтра для сайта automationpractice.com:
        - перейти на главную страницу по ссылке: http://automationpractice.com
        - в меню (WOMEN | DRESSES | T-SHIRTS) кликнуть пункт 'DRESSES'
                - установить фильтр диапазон цены с помощью ползунка
        Price->Range,
                например от 30.00 до 40.00

                - Выполнить проверку:
        1) все позиции имеют цену заданного диапазона (напр. 30.00 до 40.00)
        (точные значения границ цен не важны)*/

        driver.get(baseUrl);
        driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a")).click();

        //TODO установить фильтр диапазон цены с помощью ползунка
        //driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a")).click();
        //driver.findElement(By.cssSelector("#layered_price_slider > a:nth-child(2)")).click();
        driver.findElement(By.xpath("//div[@id='layered_price_slider']/a"));
        //driver.findElement(By.xpath("//div[@id='layered_price_slider']/a[2]")).click();
        //<a class="ui-slider-handle ui-state-default ui-corner-all" href="#" style="left: 35%;"></a>

        //TODO все позиции имеют цену заданного диапазона (напр. 30.00 до 40.00)

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        // Закрываем браузер (все окна)
        //driver.quit();
    }
}
