package com.example.tests;

import org.testng.annotations.*;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {

    @Test (dataProvider = "randomValidGroupGenerator")
    public void testGroupCreationWithValidData(GroupData group) throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();

        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        //actions
        app.getGroupHelper().initNewGroupCreation();
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        assertEquals(newList.size(), oldList.size() + 1);

        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
