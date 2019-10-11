package com.example.common.pages.groups;

import com.example.common.core.PageBase;
import com.example.common.data.GroupData;
import com.example.common.pages.common.ConfirmationMessagePage;
import com.example.common.pages.contacts.ContactsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupEditionPage extends PageBase<GroupEditionPage> {

    protected GroupEditionPage(WebDriver driver, String title) {
        super(driver, title);
    }

    private int indexOfGroupToEdit;

    @Override
    public boolean isOnPage() {
        if (driver.getTitle().equalsIgnoreCase(groupsPageTitle) &&
                driver.findElements(By.xpath("//input[@value='Update']")).size() > 0){
            return true;
        } else
            return false;
    }

    @Override
    protected void isLoaded() {
        //        ADD METHOD  (assert with exception)
    }

    @Override
    protected void load() {
        GroupsPage page = new ContactsPage(driver, contactsPageTitle).get().openGroupsPage();
        indexOfGroupToEdit = page.getRandomGroupIndexFromGroupsList(page.getGroupIndexesList());
        page.openGroupEditionPage(indexOfGroupToEdit);
    }

    //    @Override
    public GroupsPage navigateToParentPage() {
        click(By.linkText("home"));
        return new GroupsPage(driver, groupsPageTitle);
    }

    @Step
    public GroupEditionPage fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.getName());
        type(By.name("group_header"), group.getHeader());
        type(By.name("group_footer"), group.getFooter());
        return this;
    }

    @Step
    public ConfirmationMessagePage submitGroupModification() {
        click(By.name("update"));
        return new ConfirmationMessagePage(driver, groupsPageTitle);
    }
}
