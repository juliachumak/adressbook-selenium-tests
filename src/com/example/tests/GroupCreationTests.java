package com.example.tests;

import org.testng.annotations.*;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();

        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        //actions
        app.getGroupHelper().initNewGroupCreation();
        GroupData group = new GroupData();
        group.name = "group name 1";
        group.header = "group header 1";
        group.footer = "group footer 1";
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
