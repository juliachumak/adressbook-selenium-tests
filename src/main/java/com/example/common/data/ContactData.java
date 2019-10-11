package com.example.common.data;

import java.util.Objects;

public class ContactData implements Comparable<ContactData> {
    private int contactId;
    private String firstname;
    private String lastname;
    private String address;
    private String home;
    private String mobile;
    private String work;
    private String email;
    private String email2;
    private String bday;
    private String bmonth;
    private String byear;
    private String address2;
    private String phone2;

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

    public int getContactId() { return contactId; }

    public String getFirstname() { return firstname; }

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

    public String getEmail() { return email; }

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


    public ContactData withContactId(int contactId) {
        this.contactId = contactId;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHome(String home) {
        this.home = home;
        return this;
    }

    public ContactData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactData withWork(String work) {
        this.work = work;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withBday(String bday) {
        this.bday = bday;
        return this;
    }

    public ContactData withBmonth(String bmonth) {
        this.bmonth = bmonth;
        return this;
    }

    public ContactData withByear(String byear) {
        this.byear = byear;
        return this;
    }

    public ContactData withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public ContactData withPhone2(String phone2) {
        this.phone2 = phone2;
        return this;
    }
}
