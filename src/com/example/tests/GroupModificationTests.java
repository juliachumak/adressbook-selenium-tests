package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

    @Test (dataProvider = "randomValidGroupGenerator")
    public void modifySomeGroup(GroupData group){

        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroupsList();

        //actions
        Random rnd = new Random();
        int groupIndex = rnd.nextInt(oldList.size() - 1);
        app.getGroupHelper().modifyGroup(groupIndex, group);

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroupsList();

        //compare states
//        assertEquals(newList.size(), oldList.size());

        oldList.remove(groupIndex);
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

}
