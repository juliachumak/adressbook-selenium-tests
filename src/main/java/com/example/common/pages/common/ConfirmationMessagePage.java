package com.example.common.pages.common;

import com.example.common.core.PageBase;
import com.example.common.pages.contacts.ContactsPage;
import com.example.common.pages.groups.GroupsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationMessagePage<T extends PageBase<T>> extends PageBase<T> {

    String title;

    public ConfirmationMessagePage(WebDriver driver, String parentTitle) {
        super(driver, parentTitle);
        title = parentTitle;
    }

    @Override
    public boolean isOnPage() {
        if (driver.getTitle().equalsIgnoreCase(title) &&
                driver.findElements(By.className("msgbox")).size() > 0){
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
    }

//    @Override
    public ContactsPage navigateToParentContactsPage() {
        click(By.linkText("home page"));
        return new ContactsPage (driver, contactsPageTitle);
    }

    //    @Override
    public GroupsPage navigateToParentGroupsPage() {
        click(By.linkText("group page"));
        return new GroupsPage (driver, groupsPageTitle);
    }
}
