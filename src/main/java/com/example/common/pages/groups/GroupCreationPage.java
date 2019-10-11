package com.example.common.pages.groups;

import com.example.common.core.PageBase;
import com.example.common.data.GroupData;
import com.example.common.pages.common.ConfirmationMessagePage;
import com.example.common.pages.contacts.ContactsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupCreationPage extends PageBase<GroupCreationPage>  {

    protected GroupCreationPage(WebDriver driver, String title) {
        super(driver, title);
    }

    @Override
    public boolean isOnPage() {
        if (driver.getTitle().equalsIgnoreCase(groupsPageTitle) &&
                driver.findElements(By.xpath("//input[@value='Enter information']")).size() > 0){
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
        new GroupsPage(driver, groupsPageTitle).get().openGroupCreationPage();
    }

    //    @Override
    public ContactsPage navigateToParentPage() {
        click(By.linkText("home"));
        return new ContactsPage(driver, contactsPageTitle);
    }

    @Step
    public GroupCreationPage fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.getName());
        type(By.name("group_header"), group.getHeader());
        type(By.name("group_footer"), group.getFooter());
        return this;
    }

    @Step
    public ConfirmationMessagePage submitGroupCreation() {
        click(By.name("submit"));
        return new ConfirmationMessagePage(driver, groupsPageTitle);
    }
}
