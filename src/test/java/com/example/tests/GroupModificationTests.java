package com.example.tests;

import com.example.common.core.PageBase;
import com.example.common.core.TestBase;
import com.example.common.data.ContactData;
import com.example.common.data.GroupData;
import com.example.common.pages.contacts.ContactsPage;
import com.example.common.pages.groups.GroupsPage;
import com.example.common.steps.GroupSteps;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

    @Test (dataProvider = "randomValidGroupGenerator", groups = {"groups_testing", "modification"}, priority = 1)
    public void modifySomeGroup(GroupData group){

        //save old state

//        List<GroupData> oldList = app.getGroupHelper().getGroupsList();
        GroupsPage page = new ContactsPage(driver, PageBase.contactsPageTitle).get().openGroupsPage();
        List<GroupData> oldList = page.getGroupsList();

        //actions
//        Random rnd = new Random();
        int groupIndex = page.getRandomGroupIndexFromGroupsList(page.getGroupIndexesList());
        new GroupSteps(driver).modifyGroup(groupIndex, group);

        //save new state
        List<GroupData> newList = page.getGroupsList();

        //compare states
        GroupData groupToRemove = page.findGroupInListById(oldList, groupIndex);
        oldList.remove(oldList.indexOf(groupToRemove));
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

}
