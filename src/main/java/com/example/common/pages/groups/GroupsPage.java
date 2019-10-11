package com.example.common.pages.groups;

import com.example.common.core.PageBase;
import com.example.common.data.GroupData;
import com.example.common.pages.common.ConfirmationMessagePage;
import com.example.common.pages.contacts.ContactsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupsPage extends PageBase<GroupsPage> {

    public GroupsPage(WebDriver driver, String title) {
        super(driver, title);
    }

    @Override
    public boolean isOnPage() {
        if (driver.getCurrentUrl().contains("/group.php") &&
                driver.getTitle().equalsIgnoreCase(groupsPageTitle) &&
                driver.findElements(By.name("new")).size() > 0){
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
        new ContactsPage(driver, groupsPageTitle).get().openGroupsPage().openGroupCreationPage();
    }

//    @Override
    public ContactsPage navigateToParentPage() {
        click(By.linkText("home"));
        return new ContactsPage(driver, contactsPageTitle);
    }

    @Step
    public GroupCreationPage openGroupCreationPage() {
        click(By.name("new"));
        return new GroupCreationPage(driver, groupsPageTitle);
    }

    @Step
    public GroupEditionPage openGroupEditionPage(int index) {
        selectGroupByIndex(index);
        click(By.name("edit"));
        return new GroupEditionPage(driver, groupsPageTitle);
    }

    @Step
    public ConfirmationMessagePage submitGroupDeletion() {
        click(By.name("delete"));
        return new ConfirmationMessagePage(driver, groupsPageTitle);
    }

    @Step
    public GroupsPage selectGroupByIndex(int index) {
        click(By.xpath("//input[@name='selected[]' and @value='" + index + "']"));
        return this;
    }

    private List<GroupData> groupsList;

    @Step
    public List<GroupData> getGroupsList(){
        groupsList = new ArrayList<>();
        List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
        for (WebElement checkbox : checkboxes) {
            String title = checkbox.getAttribute("title");
            String name = title.substring("Select (".length(), title.length() - ")".length());
            int groupId = Integer.valueOf(checkbox.getAttribute("value"));
            groupsList.add(new GroupData().withName(name).withGroupId(groupId));
        }
        return groupsList;
    }

    @Step
    public List<Integer> getGroupIndexesList(){
        List<Integer> groupIndexesList = new ArrayList<>();
        List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
        for (WebElement checkbox : checkboxes) {
            groupIndexesList.add(Integer.valueOf(checkbox.getAttribute("value")));
        }
        return groupIndexesList;
    }

    @Step
    public int getRandomGroupIndexFromGroupsList(List<Integer> groupIndexesList){
        Random rnd = new Random();
        int groupIndex = groupIndexesList.get(rnd.nextInt(groupIndexesList.size() - 1));
        return groupIndex;
    }

    @Step
    public GroupData findGroupInListById(List<GroupData> groupsList, int groupId){
        for (GroupData groupData : groupsList) {
            if (groupData.getGroupId() == groupId){
                return groupData;
            }
        }
        return null;
    }

}
