package com.example.tests;
import org.testng.annotations.Test;
import java.util.ArrayList;
import static org.testng.Assert.assertEquals;

public class ContactRemovalTests extends TestBase {

    @Test
    public void deleteSomeContact(){
        app.getNavigationHelper().openMainPage();

        //save old state
        ArrayList<ContactData> oldList = app.getContactHelper().createContactsList();

        //actions
        int contactIndex = app.getContactHelper().getRandomContactIndexFromContactsList(app.getContactHelper().getContactIndexesList());
        app.getContactHelper().initContactModification(contactIndex);
        app.getContactHelper().deleteContact();
        app.getContactHelper().returnToMainPage();

        //save new state
        ArrayList<ContactData> newList = app.getContactHelper().createContactsList();

        //compare states
        assertEquals(newList.size(), oldList.size() - 1);
        ContactData contactToRemove = app.getContactHelper().findContactInListById(oldList, contactIndex);
        oldList.remove(oldList.indexOf(contactToRemove));
        assertEquals(oldList, newList);

    }

}
