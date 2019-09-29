package com.example.fw;

import com.example.tests.GroupData;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase{
    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    private List<GroupData> cachedGroupsList;

    public List<GroupData> getGroupsList(){
        if (cachedGroupsList == null){
//            System.out.println("cachedGroupsList is NULL, rebuilding...");
            rebuildGroupsCache();
        }
//        System.out.println("cachedGroupsList is " + cachedGroupsList.size());
        return cachedGroupsList;
    }

    private void rebuildGroupsCache() {
        manager.navigateTo().groupsPage();
        cachedGroupsList = new ArrayList<>();
        List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
        for (WebElement checkbox : checkboxes) {
            String title = checkbox.getAttribute("title");
            String name = title.substring("Select (".length(), title.length() - ")".length());
            cachedGroupsList.add(new GroupData().withName(name));
//            System.out.println("Added 1 element to cachedGroupsList, length is " + cachedGroupsList.size());
        }
    }

    @Story("createGroup")
    public GroupHelper createGroup(GroupData group) {
        manager.navigateTo().groupsPage();
        initNewGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
        rebuildGroupsCache();
        return this;
    }

    @Story("modifyGroup")
    public GroupHelper modifyGroup(int index, GroupData group){
        manager.navigateTo().groupsPage();
        initGroupModification(index);
        fillGroupForm(group);
        submitGroupModification();
        returnToGroupsPage();
        rebuildGroupsCache();
        return this;
    }

    @Story("deleteGroup")
    public GroupHelper deleteGroup(int index){
        manager.navigateTo().groupsPage();
        selectGroupByIndex(index);
        submitGroupDeletion();
        returnToGroupsPage();
        rebuildGroupsCache();
        return this;
    }

    //------------------------------------------------------------------------------------------------------------

    @Step("initNewGroupCreation")
    public GroupHelper initNewGroupCreation() {
        manager.navigateTo().groupsPage();
        click(By.name("new"));
        return this;
    }

    @Step("fillGroupForm")
    public GroupHelper fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.getName());
        type(By.name("group_header"), group.getHeader());
        type(By.name("group_footer"), group.getFooter());
        return this;
    }

    @Step("submitGroupCreation")
    public GroupHelper submitGroupCreation() {
        click(By.name("submit"));
        cachedGroupsList = null;
        return this;
    }

    @Step("returnToGroupsPage")
    public GroupHelper returnToGroupsPage() {
        click(By.linkText("group page"));
        return this;
    }

    @Step("initGroupModification")
    public GroupHelper initGroupModification(int index) {
        selectGroupByIndex(index);
        click(By.name("edit"));
        return this;
    }

    @Step("selectGroupByIndex")
    public GroupHelper selectGroupByIndex(int index) {
        click(By.xpath("//input[@name='selected[]'][" + Integer.valueOf(index + 1) + "]"));
        return this;
    }

    @Step("submitGroupModification")
    public GroupHelper submitGroupModification() {
        click(By.name("update"));
        cachedGroupsList = null;
        return this;
    }

    @Step("submitGroupDeletion")
    public GroupHelper submitGroupDeletion() {
        click(By.name("delete"));
        cachedGroupsList = null;
        return this;
    }
}
