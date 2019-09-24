package com.example.cleanup;

import com.example.tests.TestBase;
import org.testng.annotations.Test;
import java.util.List;

public class CleanupContactsRemovalTests extends TestBase {

    @Test
    public void deleteSomeContact(){

        //save old state
        List<Integer> oldList = app.getContactHelper().getContactIndexesList();

        //actions
        while (oldList.size() > 5){
            int contactIndex = app.getContactHelper().getRandomContactIndexFromContactsList(oldList);
            app.getContactHelper().deleteContact(contactIndex);
            oldList.remove(new Integer(contactIndex));
        }

    }

}
