package com.example.tests;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

    @Test
    public void testNonEmptyContactCreation() throws Exception {
        app.openMainPage();
        app.initNewContactCreation();
        ContactData contact = new ContactData();
                contact.firstname = "test first name";
                contact.lastname = "test last name";
                contact.address = "test address";
                contact.home = "0000000";
                contact.mobile = "0987654321";
                contact.work = "1111111";
                contact.email = "test@email.com";
                contact.email2 = "test@email2.com";
                contact.bday = "1";
                contact.bmonth = "January";
                contact.byear = "1990";
                contact.address2 = "test secondary address";
                contact.phone2 = "2222222";
        contact.fillContactForm();
        app.submitContactForm();
        app.returnToMainPage();
    }
}
