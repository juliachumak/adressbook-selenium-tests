package com.example.tests;
import com.example.fw.ApplicationManager;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TestBase {


    protected static ApplicationManager app;

    @BeforeSuite (alwaysRun = true)

    public void setUp() throws Exception {
        app = new ApplicationManager();
        app.navigateTo().mainPage();
    }

    @AfterSuite (alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
        Runtime.getRuntime().
                exec("cmd /c start \"\" generateReport.bat");
//        try{
//            Process p = Runtime.getRuntime().exec("D:/Users/jchumak/Desktop/Automation/adressbook-selenium-tests/generateReport.bat");
//            p.waitFor();
//
//        }catch( IOException ex ){
//            //Validate the case the file can't be accessed (not enough permissions)
//
//        }catch( InterruptedException ex ){
//            //Validate the case the process is being stopped by some external situation
//
//        }
////        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "generateReport.bat");
////        File dir = new File("D:/Users/jchumak/Desktop/Automation/adressbook-selenium-tests");
////        pb.directory(dir);
////        Process p = pb.start();
    }

    @DataProvider
    public Iterator<Object[]> randomValidGroupGenerator() {
        List<Object[]> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            GroupData group = new GroupData()
                    .withName(generateRandomString())
                    .withHeader(generateRandomString())
                    .withFooter(generateRandomString());

            list.add(new Object[]{group});
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> randomValidContactGenerator(){
        List<Object[]> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ContactData contact = new ContactData()
                    .withFirstname(generateRandomString())
                    .withLastname(generateRandomString())
                    .withAddress(generateRandomString())
                    .withHome(generateRandomNumber())
                    .withMobile(generateRandomNumber())
                    .withWork(generateRandomNumber())
                    .withEmail(generateRandomEmail())
                    .withEmail2(generateRandomEmail())
                    .withBday(generateRandomDate())
                    .withBmonth(generateRandomMonth())
                    .withByear(generateRandomYear())
                    .withAddress2(generateRandomString())
                    .withPhone2(generateRandomNumber());

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