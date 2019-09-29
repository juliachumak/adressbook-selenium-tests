package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class GroupRemovalTests extends TestBase {

    @Test (groups = {"groups_testing", "deletion"}, priority = 2)
    public void deleteSomeGroup(){

        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroupsList();

        //actions
        Random rnd = new Random();
        int groupIndex = rnd.nextInt(oldList.size() - 1);
        app.getGroupHelper().deleteGroup(groupIndex);

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroupsList();

        //compare states
//        assertEquals(newList.size(), oldList.size() - 1);

        oldList.remove(groupIndex);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

}