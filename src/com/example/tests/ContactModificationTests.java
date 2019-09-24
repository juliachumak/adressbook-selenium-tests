package com.example.tests;
import org.testng.annotations.Test;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {


    @Test (dataProvider = "randomValidContactGenerator")
    public void testContactModificationWithValidData(ContactData contact) throws Exception{

        //save old state
        List<ContactData> oldList = app.getContactHelper().getContactsList();

        //actions
        int contactIndex = app.getContactHelper().getRandomContactIndexFromContactsList(app.getContactHelper().getContactIndexesList());
        app.getContactHelper().modifyContact(contactIndex, contact);

        //save new state
        List<ContactData> newList = app.getContactHelper().getContactsList();

        //compare states
//        assertEquals(newList.size(), oldList.size());
        app.getContactHelper().findContactInListById(oldList, contactIndex)
                .withFirstname(contact.getFirstname())
                .withLastname(contact.getLastname())
                .withHome(app.getContactHelper().getDisplayedPhone(contact))
                .withEmail(app.getContactHelper().getDisplayedPEmail(contact));

        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(oldList, newList);

    }

}
