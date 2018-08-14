package com.example.fw;

import com.example.tests.GroupData;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public static WebDriver driver;
    public static String baseUrl;
    public static boolean acceptNextAlert = true;
    public static StringBuffer verificationErrors = new StringBuffer();

    public ApplicationManager(){
        System.setProperty("webdriver.gecko.driver","D:\\Users\\jchumak\\Desktop\\Automation\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "http://localhost/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            Assert.fail(verificationErrorString);
        }
    }

    public void openMainPage() {
        driver.get(baseUrl + "addressbookv4.1.4/");
    }

    public void returnToGroupsPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    public void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData group) {
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(group.getName());
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(group.getHeader());
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(group.getFooter());
    }

    public void initNewGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    public void gotoGroupsPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void returnToMainPage() {
        driver.findElement(By.linkText("home page")).click();
    }

    public void submitContactForm() {
        driver.findElement(By.name("submit")).click();
    }

    public void initNewContactCreation() {
        driver.findElement(By.linkText("add new")).click();
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
}
