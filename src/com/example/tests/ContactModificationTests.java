package com.example.tests;

import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {


    @Test (dataProvider = "randomValidContactGenerator")
    public void testContactModificationWithValidData(ContactData contact) throws Exception{
        app.getNavigationHelper().openMainPage();

        //save old state
        HashMap<Integer, ContactData> oldList = app.getContactHelper().createContactsHashMap();

        //actions
        int contactIndex = app.getContactHelper().getRandomContactIndexFromContactsHashMap(oldList);
        System.out.println(oldList.get(contactIndex).firstname + " " + oldList.get(contactIndex).lastname + " " + oldList.get(contactIndex).email);
        app.getContactHelper().initContactModification(contactIndex);
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToMainPage();

        //save new state

        HashMap<Integer, ContactData> newList = app.getContactHelper().createContactsHashMap();
        System.out.println(contact.firstname + " " + contact.lastname + " " + contact.email);
        //compare states
        assertEquals(newList.size(), oldList.size());

        oldList.get(contactIndex).firstname = "EditedName";
        assertEquals(oldList, newList);

    }

}
