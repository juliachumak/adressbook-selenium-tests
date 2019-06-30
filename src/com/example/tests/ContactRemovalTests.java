package com.example.tests;

import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;

public class ContactRemovalTests extends TestBase {

    @Test
    public void deleteSomeContact(){
        app.getNavigationHelper().openMainPage();

        //save old state

        HashMap<Integer, ContactData> oldList = app.getContactHelper().createContactsHashMap();

        //actions
        int contactIndex = 133;
        app.getContactHelper().initContactModification(contactIndex);
        app.getContactHelper().deleteContact();
        app.getContactHelper().returnToMainPage();

        //save new state

        HashMap<Integer, ContactData> newList = app.getContactHelper().createContactsHashMap();

        //compare states
        assertEquals(newList.size(), oldList.size() - 1);

        oldList.remove(contactIndex);
        assertEquals(oldList, newList);

    }

}
