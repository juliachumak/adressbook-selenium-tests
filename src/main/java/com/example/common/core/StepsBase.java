package com.example.common.core;

import com.example.common.steps.ContactSteps;
import com.example.common.steps.GroupSteps;
import org.openqa.selenium.WebDriver;

public class StepsBase {
    public static WebDriver driver;

    public StepsBase(WebDriver driver) {
        this.driver = driver;
    }

    private static GroupSteps groupSteps;
    private static ContactSteps contactSteps;

    public static GroupSteps getGroupSteps(){
        if (groupSteps == null){
            groupSteps = new GroupSteps(driver);
        }
        return groupSteps;
    }

    public static ContactSteps getContactSteps(){
        if (contactSteps == null){
            contactSteps = new ContactSteps(driver);
        }
        return contactSteps;
    }
}