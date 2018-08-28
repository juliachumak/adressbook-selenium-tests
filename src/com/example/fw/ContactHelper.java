package com.example.fw;

import com.example.tests.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase{
    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void initNewContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.getFirstname());
        type(By.name("lastname"), contact.getLastname());
        type(By.name("address"), contact.getAddress());
        type(By.name("home"), contact.getHome());
        type(By.name("mobile"), contact.getMobile());
        type(By.name("work"), contact.getWork());
        type(By.name("email"), contact.getEmail());
        type(By.name("email2"), contact.getEmail2());
        selectByText(By.name("bday"), contact.getBday());
        selectByText(By.name("bmonth"), contact.getBmonth());
        type(By.name("byear"), contact.getByear());
        type(By.name("address2"), contact.getAddress2());
        type(By.name("phone2"), contact.getPhone2());
    }

    public void submitContactForm() {
        click(By.name("submit"));
    }

    public void returnToMainPage() {
        click(By.linkText("home page"));
    }

    public void selectContactByIndex(int index) {
        click(By.xpath("(//input[@id])[" + index + "]"));
    }

    public String getContactValue(int index) {
      String contactValue = getElementValue(By.xpath("(//input[@id])[" + index + "]"));
      return contactValue;
    }

    public void initContactModification(int index) {
        click(By.xpath("//a[@href='edit.php?id=" + getContactValue(index) + "']"));
    }

    public void submitContactModification() {
        click(By.xpath("//input[@value='Update']"));
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }
}