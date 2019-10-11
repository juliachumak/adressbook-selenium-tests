package com.example.common.pages.contacts;

import com.example.common.core.PageBase;
import com.example.common.data.ContactData;
import com.example.common.pages.common.ConfirmationMessagePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactEditionPage<T extends PageBase<T>> extends PageBase<T>  {

    protected ContactEditionPage(WebDriver driver, String title) {
        super(driver, title);
    }

    private int indexOfContactToEdit;
    private String title;

    @Override
    public boolean isOnPage() {
        if (driver.getTitle().equalsIgnoreCase(title) &&
                driver.findElements(By.xpath("//input[@value='Update']")).size() > 0
                && driver.findElements(By.xpath("//input[@value='Delete']")).size() > 0){
            return true;
        } else
            return false;
    }

    @Override
    protected void isLoaded() {
        //        ADD METHOD  (assert with exception)
    }

    @Override
    protected void load() {
        ContactsPage page = new ContactsPage(driver, contactsPageTitle);
        indexOfContactToEdit = page.getRandomContactIndexFromContactsList(page.getContactIndexesList());
        page.openContactEditionPage(indexOfContactToEdit);
        String firstname = driver.findElement(By.name("firstname")).getAttribute("value");
        String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
        if (firstname.length() > 0 || lastname.length() > 0){
            title += firstname + " " + lastname + " ";
        }
;    }

    //    @Override
    public ContactsPage navigateToParentPage() {
        click(By.linkText("home"));
        return new ContactsPage(driver, contactsPageTitle);
    }

    private String getContactEditionPageTitle(){
        return title;    }

    @Step
    public ContactEditionPage fillContactForm(ContactData contact) {
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

    @Step
    public ConfirmationMessagePage submitContactModification() {
        click(By.xpath("//input[@value='Update']"));
        return new ConfirmationMessagePage(driver, contactsPageTitle);
    }

    @Step
    public ConfirmationMessagePage submitContactDeletion() {
        click(By.xpath("//input[@value='Delete']"));
        return new ConfirmationMessagePage(driver, "Delete");
    }
}
