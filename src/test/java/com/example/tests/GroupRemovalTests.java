package com.example.tests;

import com.example.common.core.PageBase;
import com.example.common.core.TestBase;
import com.example.common.data.GroupData;
import com.example.common.pages.contacts.ContactsPage;
import com.example.common.pages.groups.GroupsPage;
import com.example.common.steps.GroupSteps;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class GroupRemovalTests extends TestBase {

    @Test (groups = {"groups_testing", "deletion"}, priority = 2)
    public void deleteSomeGroup(){

        //save old state
        GroupsPage page = new ContactsPage(driver, PageBase.contactsPageTitle).get().openGroupsPage();
        List<GroupData> oldList = page.getGroupsList();

        //actions
        int groupIndex = page.getRandomGroupIndexFromGroupsList(page.getGroupIndexesList());
        new GroupSteps(driver).deleteGroup(groupIndex);

        //save new state
        List<GroupData> newList = page.getGroupsList();

        //compare states
        GroupData groupToRemove = page.findGroupInListById(oldList, groupIndex);
        oldList.remove(oldList.indexOf(groupToRemove));
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

}
