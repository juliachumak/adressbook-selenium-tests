package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

    @Test (dataProvider = "randomValidContactGenerator", groups = {"contacts_testing", "creation"}, priority = 3)
    public void testContactCreationWithValidData(ContactData contact) throws Exception {

        //save old state
        List<ContactData> oldList = app.getContactHelper().getContactsList();

        //actions
        app.getContactHelper().createContact(contact);

        //save new state
        List<ContactData> newList = app.getContactHelper().getContactsList();
        app.getContactHelper().clearContactsList();

        //compare states
        boolean matchingContactExists = false;
        for (ContactData contactData : newList) {
            if ((contactData.getFirstname().equalsIgnoreCase(contact.getFirstname()) == true) &&
                    (contactData.getLastname().equalsIgnoreCase(contact.getLastname()) == true) &&
                    (contactData.getEmail().equalsIgnoreCase(app.getContactHelper().getDisplayedPEmail(contact)) == true) &&
                    (contactData.getHome().equalsIgnoreCase(app.getContactHelper().getDisplayedPhone(contact)) == true)) {
                newList.remove(contactData);
                matchingContactExists = true;
                break;
            }
        }
        Assert.assertTrue(matchingContactExists, "Added contact is not found in list");

        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(oldList, newList);

    }
}
