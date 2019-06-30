package com.example.tests;

import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {


    @Test
    public void modifySomeContact(){
        app.getNavigationHelper().openMainPage();

        //save old state

        HashMap<Integer, ContactData> oldList = app.getContactHelper().createContactsHashMap();

        //actions
        int contactIndex = 86;
        app.getContactHelper().initContactModification(contactIndex);
        ContactData contact = new ContactData();
        contact.firstname = "EditedName";
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToMainPage();

        //save new state

        HashMap<Integer, ContactData> newList = app.getContactHelper().createContactsHashMap();

        //compare states
        assertEquals(newList.size(), oldList.size());

        oldList.get(contactIndex).firstname = "EditedName";
        assertEquals(oldList, newList);

    }

}
