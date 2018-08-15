package com.example.tests;

import org.testng.annotations.*;

public class EmptyContactCreationTests extends TestBase {

    @Test
    public void testEmptyContactCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initNewContactCreation();
        ContactData contact = new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "", "");
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactForm();
        app.getContactHelper().returnToMainPage();
    }
}
