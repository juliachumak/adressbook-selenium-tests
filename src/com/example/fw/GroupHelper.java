package com.example.fw;

import com.example.tests.GroupData;
import org.openqa.selenium.By;

public class GroupHelper extends HelperBase{
    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public void initNewGroupCreation() {
        click(By.name("new"));
    }

    public void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.getName());
        type(By.name("group_header"), group.getHeader());
        type(By.name("group_footer"), group.getFooter());
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    public void deleteGroup(int index){
        selectGroupByIndex(index);
        click(By.name("delete"));
    }

    public void initGroupModidication(int index) {
        selectGroupByIndex(index);
        click(By.name("edit"));
    }

    public void selectGroupByIndex(int index) {
        click(By.xpath("//input[@name='selected[]'][" + index + "]"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }
}
