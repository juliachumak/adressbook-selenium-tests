package com.example.fw;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void mainPage() {
        if (! onMainPage()){
            click(By.linkText("home"));
        }
    }

    private boolean onMainPage() {
        if (driver.getTitle().equalsIgnoreCase("Address book") &&
                driver.findElements(By.id("maintable")).size() > 0){
            return true;
        } else
            return false;
    }

    @Step ("Open Groups Page")
    public void groupsPage() {
        if (! onGroupsPage()){
            click(By.linkText("groups"));
        }
    }

    private boolean onGroupsPage() {
        if (driver.getCurrentUrl().contains("/group.php") &&
                driver.getTitle().equalsIgnoreCase("Groups | Address Book") &&
                driver.findElements(By.name("new")).size() > 0){
            return true;
        } else
            return false;
    }
}

