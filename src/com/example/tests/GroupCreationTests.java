package com.example.tests;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        app.openMainPage();
        app.gotoGroupsPage();
        app.initNewGroupCreation();
        GroupData group = new GroupData();
        group.name = "group name 1";
        group.header = "group header 1";
        group.footer = "group footer 1";
        app.fillGroupForm(group);
        app.submitGroupCreation();
        app.returnToGroupsPage();
    }
}
