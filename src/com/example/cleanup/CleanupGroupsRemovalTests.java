package com.example.cleanup;

import com.example.tests.GroupData;
import com.example.tests.TestBase;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;

public class CleanupGroupsRemovalTests extends TestBase {

    @Test
    public void deleteSomeGroup(){

        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroupsList();

        //actions
        Random rnd = new Random();
        while (oldList.size() > 5){
            int groupIndex = rnd.nextInt(oldList.size() - 1);
            app.getGroupHelper().deleteGroup(groupIndex);
            oldList.remove(groupIndex);
        }

    }

}
