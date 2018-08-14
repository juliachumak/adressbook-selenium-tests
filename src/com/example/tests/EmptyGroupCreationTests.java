package com.example.tests;

import org.testng.annotations.*;

public class EmptyGroupCreationTests extends TestBase {

    @Test
    public void testEmptyGroupCreation() throws Exception {
        app.openMainPage();
        app.gotoGroupsPage();
        app.initNewGroupCreation();
        GroupData group = new GroupData("", "", "");
        app.fillGroupForm(group);
        app.submitGroupCreation();
        app.returnToGroupsPage();
    }
}
