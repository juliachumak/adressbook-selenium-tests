package com.example.fw;

import com.example.tests.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

//    public String getContactValue(int index) {
//      String contactValue = getElementValue(By.xpath("(//input[@id])[" + index + "]"));
//      return contactValue;
//    }

    public void initContactModification(int index) {
        click(By.xpath("//a[@href='edit.php?id=" + index + "']"));
    }

    public void submitContactModification() {
        click(By.xpath("//input[@value='Update']"));
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public String getCellText (int index, List<WebElement> rowCells){
        String text = rowCells.get(index).getText();

        if (text == null){
            text = "";
        }
        return text;
    }

    public ContactData getContactDataFromTableRow(WebElement tableRow){
        List<WebElement> rowCells = tableRow.findElements(By.tagName("td"));
        ContactData contact = new ContactData();

        contact.lastname = getCellText(1, rowCells);
        contact.firstname = getCellText(2, rowCells);
        contact.email = getCellText(3, rowCells);
        contact.home = getCellText(4, rowCells);

        return contact;
    }

    public int getContactIndexFromTableRow(WebElement tableRow){
        List<WebElement> rowCells = tableRow.findElements(By.tagName("td"));
        int contactIndex = Integer.valueOf(rowCells.get(0).findElement(By.tagName("input")).getAttribute("value"));
        return contactIndex;
    }

    public HashMap<Integer, ContactData> createContactsHashMap(){
        HashMap<Integer, ContactData> contacts = new HashMap<>();
        List<WebElement> tableRows = driver.findElements(By.name("entry"));
        for (WebElement tableRow : tableRows) {
            contacts.put(getContactIndexFromTableRow(tableRow), getContactDataFromTableRow(tableRow));
            System.out.println(getContactIndexFromTableRow(tableRow));
        }

        return contacts;
    }

    public ArrayList<ContactData> createContactsList(){
        ArrayList<ContactData> contacts = new ArrayList<>();
        List<WebElement> tableRows = driver.findElements(By.name("entry"));
        for (WebElement tableRow : tableRows) {
            contacts.add(getContactDataFromTableRow(tableRow));
        }

        return contacts;
    }


}