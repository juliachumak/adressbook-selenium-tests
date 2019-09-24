package com.example.tests;

import java.util.Objects;

public class ContactData implements Comparable<ContactData> {
    public int contactId;
    public String firstname;
    public String lastname;
    public String address;
    public String home;
    public String mobile;
    public String work;
    public String email;
    public String email2;
    public String bday;
    public String bmonth;
    public String byear;
    public String address2;
    public String phone2;

    public ContactData() {
    }

    public ContactData(String firstname, String lastname, String address, String home, String mobile, String work,
                       String email, String email2, String bday, String bmonth, String byear, String address2, String phone2) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.email = email;
        this.email2 = email2;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.address2 = address2;
        this.phone2 = phone2;
    }

    public String getFirstname() {
        return firstname;
    }

    public int getContactId() { return contactId; }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWork() {
        return work;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }

    public String getAddress2() {
        return address2;
    }

    public String getPhone2() {
        return phone2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(contactId, that.contactId) &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(address, that.address) &&
                Objects.equals(home, that.home) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(work, that.work) &&
                Objects.equals(email, that.email) &&
                Objects.equals(email2, that.email2) &&
                Objects.equals(bday, that.bday) &&
                Objects.equals(bmonth, that.bmonth) &&
                Objects.equals(byear, that.byear) &&
                Objects.equals(address2, that.address2) &&
                Objects.equals(phone2, that.phone2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, firstname, lastname, address, home, mobile, work, email, email2, bday, bmonth, byear, address2, phone2);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + contactId + '\'' +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", home='" + home + '\'' +
                '}';
    }

    @Override
    public int compareTo(ContactData other) {
        return String.valueOf(this.contactId).compareTo(String.valueOf(other.contactId));

    }
}
