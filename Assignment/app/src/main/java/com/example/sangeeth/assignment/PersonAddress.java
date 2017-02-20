package com.example.sangeeth.assignment;

import java.io.Serializable;

/**
 * Created by sangeeth on 20/1/17.
 */

public class PersonAddress implements Serializable {

    private String FirstName;
    private String LastName;
    private String StreetAddress;
    private String MobileNo;
    private String state;
    private String city;
    private String contact;
    private String service;
    private String property;
    private String address1;
    private String address2;
    private String pin_code;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getStreetAddress() {
        return StreetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        StreetAddress = streetAddress;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

}
