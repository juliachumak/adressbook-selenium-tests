package com.example.common.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public abstract class PageBase<T extends PageBase<T>> {

    public WebDriver driver;
    private String title;

    public static final String contactsPageTitle = "Address book";
    public static final String groupsPageTitle = "Groups | Address Book";

    protected PageBase(WebDriver driver, String title) {
        this.driver = driver;
        this.title = title;
    }

    public T get() {
        if (isOnPage()) {
            isLoaded();
            return (T) this;
        } else {
            load();
        }
        return (T) this;
    }

    public boolean isOnPage() {
//        WaitHelper.waitForPageLoaded();
        return driver.getTitle().toUpperCase().contains(title.toUpperCase());
    }

    protected abstract void load();

    protected abstract void isLoaded();

//    protected abstract T navigateToParentPage();

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void selectByText(By locator, String text) {
        if (text != null) {
            new Select(driver.findElement(locator)).selectByVisibleText(text);
        }
    }
    protected String getText(By locator){
        return driver.findElement(locator).getText();
    }

    protected String getElementValue(By locator) {
        return driver.findElement(locator).getAttribute("value");
    }

    public String getCellText (int index, List<WebElement> rowCells){
        String text = rowCells.get(index).getText();

        if (text == null){
            text = "";
        }
        return text;
    }

    protected void type(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
}
