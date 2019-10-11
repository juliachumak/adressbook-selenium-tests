package com.example.common.pages.contacts;

import com.example.common.core.PageBase;
import com.example.common.data.ContactData;
import com.example.common.pages.groups.GroupsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactsPage extends PageBase<ContactsPage> {

    public ContactsPage(WebDriver driver, String title) {
        super(driver, title);
    }

    @Override
    public boolean isOnPage() {
        if (driver.getTitle().equalsIgnoreCase(contactsPageTitle)
                && driver.findElements(By.id("maintable")).size() > 0){
            return true;
        } else
            return false;
    }

    protected void isLoaded() {
        //        ADD METHOD  (assert with exception)
    }

    @Override
    protected void load() {
        driver.get("http://localhost/addressbookv4.1.4/");
    }

//    @Override
    public ContactsPage navigateToParentPage() {
        click(By.linkText("home"));
        return new ContactsPage(driver, contactsPageTitle);
    }

    @Step
    public GroupsPage openGroupsPage() {
        click(By.linkText("groups"));
        return new GroupsPage(driver, groupsPageTitle);
    }

    @Step
    public ContactCreationPage openContactCreationPage() {
        click(By.linkText("add new"));
        return new ContactCreationPage(driver, contactsPageTitle);
    }

    @Step
    public ContactEditionPage openContactEditionPage(int index) {
        click(By.xpath("//a[@href='edit.php?id=" + index + "']"));
        //EDIT TITLE
        return new ContactEditionPage(driver, contactsPageTitle);
    }

    @Step
    public ContactsPage selectContactByIndex(int index) {
        click(By.xpath("(//input[@id])[" + index + "]"));
        return this;
    }

    @Step
    public ContactData findContactInListById(List<ContactData> contactsList, int contactId){
        for (ContactData contactData : contactsList) {
            if (contactData.getContactId() == contactId){
                return contactData;
            }
        }
        return null;
    }

    @Step
    public int getContactIndexFromTableRow(WebElement tableRow){
        List<WebElement> rowCells = tableRow.findElements(By.tagName("td"));
        int contactIndex = Integer.valueOf(rowCells.get(0).findElement(By.tagName("input")).getAttribute("value"));
        return contactIndex;
    }

    @Step
    public List<Integer> getContactIndexesList(){
        List<Integer> contactIndexesList = new ArrayList<>();
        List<WebElement> tableRows = driver.findElements(By.name("entry"));
        for (WebElement tableRow : tableRows) {
            contactIndexesList.add(getContactIndexFromTableRow(tableRow));
        }
        return contactIndexesList;
    }

    @Step
    public int getRandomContactIndexFromContactsList(List<Integer> contactIndexesList){
        Random rnd = new Random();
        int contactIndex = contactIndexesList.get(rnd.nextInt(contactIndexesList.size() - 1));
        return contactIndex;
    }

    @Step
    public ContactData getContactDataFromTableRow(WebElement tableRow){
        List<WebElement> rowCells = tableRow.findElements(By.tagName("td"));
        ContactData contact = new ContactData()
                .withContactId(getContactIndexFromTableRow(tableRow))
                .withLastname(getCellText(1, rowCells))
                .withFirstname(getCellText(2, rowCells))
                .withEmail(getCellText(3, rowCells))
                .withHome(getCellText(4, rowCells));

        return contact;
    }

    private List<ContactData> contactsList;

    public List<ContactData> getContactsList(){
        contactsList = new ArrayList<>();
        List<WebElement> tableRows = driver.findElements(By.name("entry"));
        for (WebElement tableRow : tableRows) {
            contactsList.add(getContactDataFromTableRow(tableRow));
        }
        return contactsList;
    }

    public String getDisplayedPhone(ContactData contact){
        String phone;
        if (!contact.getHome().isEmpty()){
            phone = contact.getHome();
        } else if (!contact.getMobile().isEmpty()){
            phone = contact.getMobile();
        } else if (!contact.getWork().isEmpty()){
            phone = contact.getWork();
        } else {
            phone = "";
        }
        return phone;
    }

    public String getDisplayedEmail(ContactData contact){
        String email;
        if (!contact.getEmail().isEmpty()){
            email = contact.getEmail();
        } else if (!contact.getEmail2().isEmpty()){
            email = contact.getEmail2();
        } else {
            email = "";
        }
        return email;
    }
}
