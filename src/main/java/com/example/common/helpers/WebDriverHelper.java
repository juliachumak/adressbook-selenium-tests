package com.example.common.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class WebDriverHelper {

    private static WebDriver driver = null;
    public static String baseUrl;

    private static WebDriver createDriver(){
        System.setProperty("webdriver.gecko.driver",
                "D:/Users/jchumak/Desktop/Automation/adressbook-selenium-tests/src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "http://localhost/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "addressbookv4.1.4/");
        return driver;
    }

    public static WebDriver getDriver(){
        if (driver == null){
            driver = createDriver();
        }
        return driver;
    }

    public void stop() {
        driver.quit();
    }

}
