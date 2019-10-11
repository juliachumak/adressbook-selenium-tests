package com.example.common.steps;

import com.example.common.core.StepsBase;
import com.example.common.data.ContactData;
import com.example.common.pages.contacts.ContactsPage;
import com.example.common.core.PageBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ContactSteps extends StepsBase {
    public ContactSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public ContactSteps createContact(ContactData contact) {
        new ContactsPage(driver, PageBase.contactsPageTitle).get()
                .openContactCreationPage()
                .fillContactForm(contact).submitContactCreation()
                .navigateToParentContactsPage();
        return this;
    }

    @Step
    public ContactSteps modifyContact(int index, ContactData contact) {
        new ContactsPage(driver, PageBase.contactsPageTitle).get()
                .openContactEditionPage(index)
                .fillContactForm(contact)
                .submitContactModification()
                .navigateToParentContactsPage();
        return this;
    }

    @Step
    public ContactSteps deleteContact(int index) {
        new ContactsPage(driver, PageBase.contactsPageTitle).get()
                .openContactEditionPage(index)
                .submitContactDeletion()
                .navigateToParentContactsPage();
        return this;
    }

}