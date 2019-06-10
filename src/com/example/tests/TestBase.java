package com.example.tests;
import com.example.fw.ApplicationManager;
import org.testng.annotations.*;

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
