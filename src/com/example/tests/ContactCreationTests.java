package com.example.tests;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collections;

import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

    @Test
    public void testNonEmptyContactCreation() throws Exception {
        app.getNavigationHelper().openMainPage();

        //save old state

        ArrayList<ContactData> oldList = app.getContactHelper().createContactsList();

        //actions
        app.getContactHelper().initNewContactCreation();
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
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactForm();
        app.getContactHelper().returnToMainPage();

        //save new state

        ArrayList<ContactData> newList = app.getContactHelper().createContactsList();

        //compare states
        assertEquals(newList.size(), oldList.size() + 1);

        ContactData newContact = new ContactData();
        newContact.email = contact.email;
        newContact.lastname = contact.lastname;
        newContact.firstname = contact.firstname;
        newContact.home = contact.home;
        oldList.add(newContact);
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(oldList, newList);

    }
}
