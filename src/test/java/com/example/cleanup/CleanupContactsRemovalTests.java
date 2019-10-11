package com.example.cleanup;

import com.example.common.core.PageBase;
import com.example.common.core.TestBase;
import com.example.common.pages.contacts.ContactsPage;
import com.example.common.steps.ContactSteps;
import org.testng.annotations.Test;
import java.util.List;

public class CleanupContactsRemovalTests extends TestBase {

    @Test (groups = {"cleanup"}, priority = 0)
    public void deleteSomeContact(){

        //save old state
        ContactsPage page = new ContactsPage(driver, PageBase.contactsPageTitle).get();
        List<Integer> oldList = page.getContactIndexesList();

        //actions
        while (oldList.size() > 5){
            int contactIndex = page.getRandomContactIndexFromContactsList(oldList);
            new ContactSteps(driver).deleteContact(contactIndex);
            oldList.remove(new Integer(contactIndex));
        }

    }

}
