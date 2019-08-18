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

        for (int i = 0; i < 3; i++) {
            GroupData group = new GroupData();

            group.name = generateRandomString();
            group.header = generateRandomString();
            group.footer = generateRandomString();

            list.add(new Object[]{group});
        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> randomValidContactGenerator(){
        List<Object[]> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ContactData contact = new ContactData();

            contact.firstname = generateRandomString();
            contact.lastname = generateRandomString();
            contact.address = generateRandomString();
            contact.home = generateRandomNumber();
            contact.mobile = generateRandomNumber();
            contact.work = generateRandomNumber();
            contact.email = generateRandomEmail();
            contact.email2 = generateRandomEmail();
            contact.bday = generateRandomDate();
            contact.bmonth = generateRandomMonth();
            contact.byear = generateRandomYear();
            contact.address2 = generateRandomString();
            contact.phone2 = generateRandomNumber();

            list.add(new Object[]{contact});
        }
        return list.iterator();

    }

    public String generateRandomString(){
        Random rnd = new Random();
        if (rnd.nextInt(3) == 0){
            return "";
        } else {
            return Math.abs(rnd.nextInt()) + " test";
        }
    }

    public String generateRandomNumber(){
        Random rnd = new Random();
        if (rnd.nextInt(3) == 0){
            return "";
        } else {
            return String.valueOf(Math.abs(rnd.nextInt()));
        }
    }

    public String generateRandomYear(){
        Random rnd = new Random();
//        if (rnd.nextInt(3) == 0){
//            return "0000";
//        } else {
            return String.valueOf(rnd.nextInt((2011 - 1920) + 1) + 1920);
//        }

    }

    public String generateRandomDate(){
        Random rnd = new Random();
//        if (rnd.nextInt(3) == 0){
//            return "";
//        } else {
            return String.valueOf(rnd.nextInt(31) + 1);
//        }
    }

    public String generateRandomMonth(){
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        Random rnd = new Random();
//        if (rnd.nextInt(3) == 0){
//            return "";
//        } else {
            return months[rnd.nextInt(12)];
//        }
    }

    public String generateRandomEmail(){
        Random rnd = new Random();
        if (rnd.nextInt(3) == 0){
            return "";
        } else {
            return Math.abs(rnd.nextInt()) + "test@email.com";
        }
    }

}
