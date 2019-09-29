package com.example.fw;

import com.example.tests.ContactData;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactHelper extends HelperBase{
    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    private List<ContactData> cachedContactsList;

    public void clearContactsList(){
        cachedContactsList = null;
    }

    public List<ContactData> getContactsList(){
        if (cachedContactsList == null){
            rebuildContactsCache();
        }
        return cachedContactsList;
    }

    private void rebuildContactsCache() {
        manager.navigateTo().mainPage();
        cachedContactsList = new ArrayList<>();
        List<WebElement> tableRows = driver.findElements(By.name("entry"));
        for (WebElement tableRow : tableRows) {
            cachedContactsList.add(getContactDataFromTableRow(tableRow));
        }
    }

    @Story("createContact")
    public ContactHelper createContact(ContactData contact) {
        initNewContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToMainPage();
//        click(By.linkText("home"));
//        cachedContactsList = null;
        rebuildContactsCache();
        return this;
    }

    @Story("modifyContact")
    public ContactHelper modifyContact(int index, ContactData contact) {
        initContactModification(index);
        fillContactForm(contact);
        submitContactModification();
        returnToMainPage();
//        click(By.linkText("home"));
//        cachedContactsList = null;
        rebuildContactsCache();
        return this;
    }

    @Story("deleteContact")
    public ContactHelper deleteContact(int index) {
        initContactModification(index);
        submitContactDeletion();
        returnToMainPage();
        rebuildContactsCache();
        return this;
    }

    //------------------------------------------------------------------------------------------------------------

    @Step("initNewContactCreation")
    public ContactHelper initNewContactCreation() {
        manager.navigateTo().mainPage();
        click(By.linkText("add new"));
        return this;
    }

    @Step("fillContactForm")
    public ContactHelper fillContactForm(ContactData contact) {
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
        return this;
    }

    @Step("submitContactCreation")
    public ContactHelper submitContactCreation() {
        click(By.name("submit"));
        cachedContactsList = null;
        return this;
    }

    @Step("returnToMainPage")
    public ContactHelper returnToMainPage() {
        click(By.linkText("home page"));
        return this;
    }

    @Step("selectContactByIndex")
    public ContactHelper selectContactByIndex(int index) {
        click(By.xpath("(//input[@id])[" + index + "]"));
        return this;
    }

    @Step("initContactModification")
    public ContactHelper initContactModification(int index) {
        manager.navigateTo().mainPage();
        click(By.xpath("//a[@href='edit.php?id=" + index + "']"));
        return this;
    }

    @Step("submitContactModification")
    public ContactHelper submitContactModification() {
        click(By.xpath("//input[@value='Update']"));
        cachedContactsList = null;
        return this;
    }

    public String getCellText (int index, List<WebElement> rowCells){
        String text = rowCells.get(index).getText();

        if (text == null){
            text = "";
        }
        return text;
    }

//    @Step("getContactDataFromTableRow")
    public ContactData getContactDataFromTableRow(WebElement tableRow){
        manager.navigateTo().mainPage();
        List<WebElement> rowCells = tableRow.findElements(By.tagName("td"));
        ContactData contact = new ContactData()
                .withContactId(getContactIndexFromTableRow(tableRow))
                .withLastname(getCellText(1, rowCells))
                .withFirstname(getCellText(2, rowCells))
                .withEmail(getCellText(3, rowCells))
                .withHome(getCellText(4, rowCells));

        return contact;
    }

//    @Step("getContactIndexFromTableRow")
    public int getContactIndexFromTableRow(WebElement tableRow){
        manager.navigateTo().mainPage();
        List<WebElement> rowCells = tableRow.findElements(By.tagName("td"));
        int contactIndex = Integer.valueOf(rowCells.get(0).findElement(By.tagName("input")).getAttribute("value"));
        return contactIndex;
    }

//    @Step("getContactIndexesList")
    public List<Integer> getContactIndexesList(){
        manager.navigateTo().mainPage();
        List<Integer> contactIndexesList = new ArrayList<>();
        List<WebElement> tableRows = driver.findElements(By.name("entry"));
        for (WebElement tableRow : tableRows) {
            contactIndexesList.add(getContactIndexFromTableRow(tableRow));
        }
        return contactIndexesList;
    }

//    @Step("getRandomContactIndexFromContactsList")
    public int getRandomContactIndexFromContactsList(List<Integer> contactIndexesList){
        Random rnd = new Random();
        int contactIndex = contactIndexesList.get(rnd.nextInt(contactIndexesList.size() - 1));
        return contactIndex;
    }

//    @Step("findContactInListById")
    public ContactData findContactInListById(List<ContactData> contactsList, int contactId){
        for (ContactData contactData : contactsList) {
            if (contactData.getContactId() == contactId){
                return contactData;
            }
        }
        return null;
    }

    public String getDisplayedPhone(ContactData contact){
        String phone;
        if (contact.getHome() != ""){
            phone = contact.getHome();
        } else if (contact.getMobile() != ""){
            phone = contact.getMobile();
        } else if (contact.getWork() != ""){
            phone = contact.getWork();
        } else {
            phone = "";
        }
        return phone;
    }

    public String getDisplayedPEmail(ContactData contact){
        String email;
        if (contact.getEmail() != ""){
            email = contact.getEmail();
        } else if (contact.getEmail2() != ""){
            email = contact.getEmail2();
        } else {
            email = "";
        }
        return email;
    }

    @Step("submitContactDeletion")
    public ContactHelper submitContactDeletion() {
        click(By.xpath("//input[@value='Delete']"));
        cachedContactsList = null;
        return this;
    }
}