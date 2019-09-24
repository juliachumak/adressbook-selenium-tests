package com.example.tests;
import org.testng.annotations.Test;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactRemovalTests extends TestBase {

    @Test
    public void deleteSomeContact(){

        //save old state
        List<ContactData> oldList = app.getContactHelper().getContactsList();

        //actions
        int contactIndex = app.getContactHelper().getRandomContactIndexFromContactsList(app.getContactHelper().getContactIndexesList());
        app.getContactHelper().deleteContact(contactIndex);

        //save new state
        List<ContactData> newList = app.getContactHelper().getContactsList();

        //compare states
//        assertEquals(newList.size(), oldList.size() - 1);
        ContactData contactToRemove = app.getContactHelper().findContactInListById(oldList, contactIndex);
        oldList.remove(oldList.indexOf(contactToRemove));

        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(oldList, newList);

    }

}
