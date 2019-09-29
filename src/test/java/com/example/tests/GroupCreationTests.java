package com.example.tests;

import org.testng.annotations.*;

import java.util.*;


import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {

    @Test (dataProvider = "randomValidGroupGenerator", groups = {"groups_testing", "creation"}, priority = 0)
    public void testGroupCreationWithValidData(GroupData group) throws Exception {

        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroupsList();
//        System.out.println("oldList is " + oldList.size());

        //actions
        app.getGroupHelper().createGroup(group);

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroupsList();
//        System.out.println("newList is " + newList.size());

        //compare states
//        assertEquals(newList.size(), oldList.size() + 1);

        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
