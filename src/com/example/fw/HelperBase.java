package com.example.fw;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public abstract class HelperBase {

    protected ApplicationManager manager;
    protected WebDriver driver;
    public boolean acceptNextAlert = true;

    public HelperBase (ApplicationManager manager){
        this.manager = manager;
        this.driver = manager.driver;
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    protected void type(By locator, String text) {
        if (text != null) {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

//    protected List<WebElement> findElements(By locator) { return driver.findElements(locator); }

    protected String getElementValue(By locator) {
        return driver.findElement(locator).getAttribute("value");
    }

    protected void selectByText(By locator, String text) {
        if (text != null) {
            new Select(driver.findElement(locator)).selectByVisibleText(text);
        }
    }
}
