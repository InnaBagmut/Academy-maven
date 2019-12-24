package com.academy.automationpractice.page;

import com.academy.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
    private WebDriver driver;

    @FindBy(id = "search_query_top")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id='searchbox']/button")
    private WebElement searchButton;

    @FindBy(css = "#center_column > ul > li:nth-child(1) > div > div.right-block > h5 > a")
    private WebElement searchResult1;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage fillSearchInput(String value) {
        fillInput(searchInput, value);
        return this;
    }

    public SearchPage getTextFromSearchResult() {
        getText(searchResult1);
        return this;
    }
}
