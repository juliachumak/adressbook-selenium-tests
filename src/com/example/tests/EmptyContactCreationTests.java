package com.example.tests;

import org.testng.annotations.*;

public class EmptyContactCreationTests extends TestBase {

    @Test
    public void testEmptyContactCreation() throws Exception {
        app.openMainPage();
        app.initNewContactCreation();
        ContactData contact = new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "", "");
        contact.fillContactForm();
        app.submitContactForm();
        app.returnToMainPage();
    }
}
