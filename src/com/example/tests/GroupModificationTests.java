package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {


    @Test
    public void modifySomeGroup(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();

        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        //actions
        int groupIndex = 0;
        app.getGroupHelper().initGroupModification(groupIndex);
        GroupData group = new GroupData();
        group.name = "edited group name";
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupsPage();

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        assertEquals(newList.size(), oldList.size());

        oldList.remove(groupIndex);
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

}
