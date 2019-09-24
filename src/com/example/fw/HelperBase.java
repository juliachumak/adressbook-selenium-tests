package com.example.fw;

import com.example.tests.ContactData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


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
//        if (text != null) {
            driver.findElement(locator).clear();
//            if (text != ""){
                driver.findElement(locator).sendKeys(text);
//            }
//        }
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected String getText(By locator){
        return driver.findElement(locator).getText();
    }

    protected String getElementValue(By locator) {
        return driver.findElement(locator).getAttribute("value");
    }


    protected void selectByText(By locator, String text) {
        if (text != null) {
            new Select(driver.findElement(locator)).selectByVisibleText(text);
        }
    }
}
