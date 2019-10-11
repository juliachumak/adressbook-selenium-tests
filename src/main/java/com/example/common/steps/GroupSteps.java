package com.example.common.steps;

import com.example.common.core.StepsBase;
import com.example.common.data.GroupData;
import com.example.common.pages.contacts.ContactsPage;
import com.example.common.core.PageBase;
import com.example.common.pages.groups.GroupsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class GroupSteps extends StepsBase {
    public GroupSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public GroupSteps createGroup(GroupData group) {
        new GroupsPage(driver, PageBase.groupsPageTitle)
                .openGroupCreationPage()
                .fillGroupForm(group)
                .submitGroupCreation()
                .navigateToParentGroupsPage();
        return this;
    }

    @Step
    public GroupSteps modifyGroup(int index, GroupData group){
        new ContactsPage(driver, PageBase.contactsPageTitle).get()
                .openGroupsPage()
                .openGroupEditionPage(index)
                .fillGroupForm(group)
                .submitGroupModification()
                .navigateToParentGroupsPage();
        return this;
    }

    @Step
    public GroupSteps deleteGroup(int index){
        new ContactsPage(driver, PageBase.contactsPageTitle).get()
                .openGroupsPage()
                .selectGroupByIndex(index)
                .submitGroupDeletion()
                .navigateToParentGroupsPage();
        return this;
    }

}
