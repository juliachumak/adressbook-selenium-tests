package com.example.tests;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collections;

import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

    @Test (dataProvider = "randomValidContactGenerator")
    public void testContactCreationWithValidData(ContactData contact) throws Exception {
        app.getNavigationHelper().openMainPage();

        //save old state
        ArrayList<ContactData> oldList = app.getContactHelper().createContactsList();

        //actions
        app.getContactHelper().initNewContactCreation();
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
