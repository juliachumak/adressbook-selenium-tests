package com.example.cleanup;

import com.example.tests.TestBase;
import org.testng.annotations.Test;
import java.util.List;

public class CleanupContactsRemovalTests extends TestBase {

    @Test
    public void deleteSomeContact(){
        app.getNavigationHelper().openMainPage();

        //save old state
        List<Integer> oldList = app.getContactHelper().getContactIndexesList();

        //actions
        while (oldList.size() > 10){
            int contactIndex = app.getContactHelper().getRandomContactIndexFromContactsList(oldList);
            app.getContactHelper().initContactModification(contactIndex);
            app.getContactHelper().deleteContact();
            app.getContactHelper().returnToMainPage();
            oldList.remove(new Integer(contactIndex));
            System.out.println(oldList.size());
        }

    }

}
