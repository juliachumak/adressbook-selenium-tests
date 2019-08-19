package com.example.cleanup;

import com.example.tests.GroupData;
import com.example.tests.TestBase;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;

public class CleanupGroupsRemovalTests extends TestBase {

    @Test
    public void deleteSomeGroup(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();

        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        //actions
        Random rnd = new Random();
        while (oldList.size() > 10){
            int groupIndex = rnd.nextInt(oldList.size() - 1);
            app.getGroupHelper().deleteGroup(groupIndex);
            app.getGroupHelper().returnToGroupsPage();
            oldList.remove(groupIndex);
            System.out.println(oldList.size());
        }

    }

}
