package com.example.tests;

import com.example.fw.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ContactData {
    public String firstname;
    public String lastname;
    public String address;
    public String home;
    public String mobile;
    public String work;
    public String email;
    public String email2;
    public String bday;
    public String bmonth;
    public String byear;
    public String address2;
    public String phone2;

    public ContactData() {
    }

    public ContactData(String firstname, String lastname, String address, String home, String mobile, String work,
                       String email, String email2, String bday, String bmonth, String byear, String address2, String phone2) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.email = email;
        this.email2 = email2;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.address2 = address2;
        this.phone2 = phone2;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWork() {
        return work;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }

    public String getAddress2() {
        return address2;
    }

    public String getPhone2() {
        return phone2;
    }

    public void fillContactForm() {
        ApplicationManager.driver.findElement(By.name("firstname")).clear();
        ApplicationManager.driver.findElement(By.name("firstname")).sendKeys(getFirstname());
        ApplicationManager.driver.findElement(By.name("lastname")).clear();
        ApplicationManager.driver.findElement(By.name("lastname")).sendKeys(getLastname());
        ApplicationManager.driver.findElement(By.name("address")).clear();
        ApplicationManager.driver.findElement(By.name("address")).sendKeys(getAddress());
        ApplicationManager.driver.findElement(By.name("home")).clear();
        ApplicationManager.driver.findElement(By.name("home")).sendKeys(getHome());
        ApplicationManager.driver.findElement(By.name("mobile")).clear();
        ApplicationManager.driver.findElement(By.name("mobile")).sendKeys(getMobile());
        ApplicationManager.driver.findElement(By.name("work")).clear();
        ApplicationManager.driver.findElement(By.name("work")).sendKeys(getWork());
        ApplicationManager.driver.findElement(By.name("email")).clear();
        ApplicationManager.driver.findElement(By.name("email")).sendKeys(getEmail());
        ApplicationManager.driver.findElement(By.name("email2")).clear();
        ApplicationManager.driver.findElement(By.name("email2")).sendKeys(getEmail2());
        new Select(ApplicationManager.driver.findElement(By.name("bday"))).selectByVisibleText(getBday());
        new Select(ApplicationManager.driver.findElement(By.name("bmonth"))).selectByVisibleText(getBmonth());
        ApplicationManager.driver.findElement(By.name("byear")).clear();
        ApplicationManager.driver.findElement(By.name("byear")).sendKeys(getByear());
        ApplicationManager.driver.findElement(By.name("address2")).clear();
        ApplicationManager.driver.findElement(By.name("address2")).sendKeys(getAddress2());
        ApplicationManager.driver.findElement(By.name("phone2")).clear();
        ApplicationManager.driver.findElement(By.name("phone2")).sendKeys(getPhone2());
    }
}
