package com.example.tests;
import com.example.fw.ApplicationManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {


    protected static ApplicationManager app;

    @BeforeSuite
    public void setUp() throws Exception {
        app = new ApplicationManager();
    }

    @AfterSuite
    public void tearDown() throws Exception {
        app.stop();
    }

}
