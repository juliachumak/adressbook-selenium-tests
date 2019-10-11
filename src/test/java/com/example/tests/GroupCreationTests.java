package com.example.tests;

import com.example.common.core.PageBase;
import com.example.common.core.TestBase;
import com.example.common.data.GroupData;
import com.example.common.pages.contacts.ContactsPage;
import com.example.common.pages.groups.GroupsPage;
import com.example.common.steps.GroupSteps;
import org.testng.annotations.*;

import java.util.*;


import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {

    @Test (dataProvider = "randomValidGroupGenerator", groups = {"groups_testing", "creation"}, priority = 0)
    public void testGroupCreationWithValidData(GroupData group) throws Exception {

        //save old state
        GroupsPage page = new ContactsPage(driver, PageBase.contactsPageTitle).get().openGroupsPage();
        List<GroupData> oldList = page.getGroupsList();
//        System.out.println("oldList is " + oldList.size());

        //actions
        new GroupSteps(driver).createGroup(group);

        //save new state
        List<GroupData> newList = page.getGroupsList();
//        System.out.println("newList is " + newList.size());

        //compare states
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
