package com.example.tests;
import com.example.fw.ApplicationManager;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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

    @DataProvider
    public Iterator<Object[]> randomValidGroupGenerator() {
        List<Object[]> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            GroupData group = new GroupData();

            group.name = generateRandomString();
            group.header = generateRandomString();
            group.footer = generateRandomString();

            list.add(new Object[]{group});
        }

        return list.iterator();
    }

    public String generateRandomString(){
        Random rnd = new Random();
        if (rnd.nextInt(3) == 0){
            return "";
        } else {
            return "test" + rnd.nextInt();
        }
    }


}
