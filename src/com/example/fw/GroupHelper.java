package com.example.fw;

import com.example.tests.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

    public GroupHelper createGroup(GroupData group) {
        manager.navigateTo().groupsPage();
        initNewGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
        rebuildGroupsCache();
        return this;
    }

    public GroupHelper modifyGroup(int index, GroupData group){
        manager.navigateTo().groupsPage();
        initGroupModification(index);
        fillGroupForm(group);
        submitGroupModification();
        returnToGroupsPage();
        rebuildGroupsCache();
        return this;
    }

    public GroupHelper deleteGroup(int index){
        manager.navigateTo().groupsPage();
        selectGroupByIndex(index);
        submitGroupDeletion();
        returnToGroupsPage();
        rebuildGroupsCache();
        return this;
    }

    //------------------------------------------------------------------------------------------------------------

    public GroupHelper initNewGroupCreation() {
        manager.navigateTo().groupsPage();
        click(By.name("new"));
        return this;
    }

    public GroupHelper fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.getName());
        type(By.name("group_header"), group.getHeader());
        type(By.name("group_footer"), group.getFooter());
        return this;
    }

    public GroupHelper submitGroupCreation() {
        click(By.name("submit"));
        cachedGroupsList = null;
        return this;
    }

    public GroupHelper returnToGroupsPage() {
        click(By.linkText("group page"));
        return this;
    }

    public GroupHelper initGroupModification(int index) {
        selectGroupByIndex(index);
        click(By.name("edit"));
        return this;
    }

    public GroupHelper selectGroupByIndex(int index) {
        click(By.xpath("//input[@name='selected[]'][" + Integer.valueOf(index + 1) + "]"));
        return this;
    }

    public GroupHelper submitGroupModification() {
        click(By.name("update"));
        cachedGroupsList = null;
        return this;
    }

    public GroupHelper submitGroupDeletion() {
        click(By.name("delete"));
        cachedGroupsList = null;
        return this;
    }
}
