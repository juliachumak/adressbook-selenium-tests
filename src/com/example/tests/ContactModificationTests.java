package com.example.tests;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {


    @Test (dataProvider = "randomValidContactGenerator")
    public void testContactModificationWithValidData(ContactData contact) throws Exception{
        app.getNavigationHelper().openMainPage();

        //save old state
        ArrayList<ContactData> oldList = app.getContactHelper().createContactsList();

        //actions
        int contactIndex = app.getContactHelper().getRandomContactIndexFromContactsList(app.getContactHelper().getContactIndexesList());
//        System.out.println(oldList.get(contactIndex).firstname + " " + oldList.get(contactIndex).lastname + " " + oldList.get(contactIndex).email);
        app.getContactHelper().initContactModification(contactIndex);
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToMainPage();

        //save new state
        ArrayList<ContactData> newList = app.getContactHelper().createContactsList();
//        System.out.println("First name: " + contact.firstname + " Last name: " + contact.lastname + " Email 1: " + contact.email + " Email 2: " + contact.email2);

        //compare states
        assertEquals(newList.size(), oldList.size());
        ContactData contactToEdit = app.getContactHelper().findContactInListById(oldList, contactIndex);
        contactToEdit.firstname = contact.firstname;
        contactToEdit.lastname = contact.lastname;
        contactToEdit.home = app.getContactHelper().getDisplayedPhone(contact);
        contactToEdit.email = app.getContactHelper().getDisplayedPEmail(contact);

        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(oldList, newList);

    }

}
