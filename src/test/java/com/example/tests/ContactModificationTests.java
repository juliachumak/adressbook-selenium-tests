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

public class ContactModificationTests extends TestBase {


    @Test (dataProvider = "randomValidContactGenerator", groups = {"contacts_testing", "modification"}, priority = 4)
    public void testContactModificationWithValidData(ContactData contact) throws Exception{

        //save old state
        ContactsPage page = new ContactsPage(driver, PageBase.contactsPageTitle).get();
        List<ContactData> oldList = page.getContactsList();

        //actions
        int contactIndex = page.getRandomContactIndexFromContactsList(page.getContactIndexesList());
        new ContactSteps(driver).modifyContact(contactIndex, contact);

        //save new state
        List<ContactData> newList = page.getContactsList();

        //compare states
//        assertEquals(newList.size(), oldList.size());
        page.findContactInListById(oldList, contactIndex)
                .withFirstname(contact.getFirstname())
                .withLastname(contact.getLastname())
                .withHome(page.getDisplayedPhone(contact))
                .withEmail(page.getDisplayedEmail(contact));

        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(oldList, newList);

    }

}
