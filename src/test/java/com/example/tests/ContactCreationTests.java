package com.example.tests;

import com.example.common.core.PageBase;
import com.example.common.core.TestBase;
import com.example.common.data.ContactData;
import com.example.common.pages.contacts.ContactsPage;
import com.example.common.steps.ContactSteps;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

    @Test (dataProvider = "randomValidContactGenerator", groups = {"contacts_testing", "creation"}, priority = 3)
    public void testContactCreationWithValidData(ContactData contact) throws Exception {

        //save old state
        ContactsPage page = new ContactsPage(driver, PageBase.contactsPageTitle).get();
        List<ContactData> oldList = page.getContactsList();

        //actions
        new ContactSteps(driver).createContact(contact);

        //save new state
        List<ContactData> newList = page.getContactsList();

        //compare states
        boolean matchingContactExists = false;
        for (ContactData contactData : newList) {
            if ((contactData.getFirstname().equalsIgnoreCase(contact.getFirstname())) &&
                    (contactData.getLastname().equalsIgnoreCase(contact.getLastname())) &&
                    (contactData.getEmail().equalsIgnoreCase(page.getDisplayedEmail(contact))) &&
                    (contactData.getHome().equalsIgnoreCase(page.getDisplayedPhone(contact)))) {
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
