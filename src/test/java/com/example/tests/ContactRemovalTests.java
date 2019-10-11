package com.example.tests;
import com.example.common.core.PageBase;
import com.example.common.core.TestBase;
import com.example.common.data.ContactData;
import com.example.common.pages.contacts.ContactsPage;
import com.example.common.steps.ContactSteps;
import org.testng.annotations.Test;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactRemovalTests extends TestBase {

    @Test (groups = {"contacts_testing", "deletion"}, priority = 5)
    public void deleteSomeContact(){

        //save old state
        ContactsPage page = new ContactsPage(driver, PageBase.contactsPageTitle).get();
        List<ContactData> oldList = page.getContactsList();

        //actions
        int contactIndex =  page.getRandomContactIndexFromContactsList(page.getContactIndexesList());
        new ContactSteps(driver).deleteContact(contactIndex);

        //save new state
        List<ContactData> newList = page.getContactsList();

        //compare states
        ContactData contactToRemove = page.findContactInListById(oldList, contactIndex);
        oldList.remove(oldList.indexOf(contactToRemove));

        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(oldList, newList);

    }

}
