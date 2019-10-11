package com.example.cleanup;

import com.example.common.core.PageBase;
import com.example.common.data.GroupData;
import com.example.common.core.TestBase;
import com.example.common.pages.contacts.ContactsPage;
import com.example.common.pages.groups.GroupsPage;
import com.example.common.steps.ContactSteps;
import com.example.common.steps.GroupSteps;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;

public class CleanupGroupsRemovalTests extends TestBase {

    @Test (groups = {"cleanup"}, priority = 1)
    public void deleteSomeGroup(){

        //save old state
        GroupsPage page = new ContactsPage(driver, PageBase.contactsPageTitle).get().openGroupsPage();
        List<Integer> oldList = page.getGroupIndexesList();

        //actions
        while (oldList.size() > 5){
            int groupIndex = page.getRandomGroupIndexFromGroupsList(oldList);
            new GroupSteps(driver).deleteGroup(groupIndex);
            oldList.remove(new Integer(groupIndex));
        }

    }

}
