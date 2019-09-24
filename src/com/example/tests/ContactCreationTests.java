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

        for (ContactData contactData : newList) {
            if ((contactData.firstname.equalsIgnoreCase(contact.firstname) == true) && (contactData.lastname.equalsIgnoreCase(contact.lastname) == true) &&
                    (contactData.email.equalsIgnoreCase(app.getContactHelper().getDisplayedPEmail(contact)) == true) &&
                    (contactData.home.equalsIgnoreCase(app.getContactHelper().getDisplayedPhone(contact)) == true)) {
                newList.remove(contactData);
                return;
            }
        }

        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(oldList, newList);

    }
}
