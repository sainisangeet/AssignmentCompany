package com.example.sangeeth.assignment;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by sangeeth on 21/1/17.
 */

public class AddressGetterSetter implements Serializable{

    private String firstName;
    private String lastName;
    private String streetAddress1;
    private String streetAddress2;
    private String state;
    private String pinCode;


    AddressGetterSetter(String firstName,String lastName,String streetAddress1,String streetAddress2,String state , String pinCode){

        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress1 = streetAddress1;
        this.streetAddress2 = streetAddress2;
        this.state = state;
        this.pinCode = pinCode;
    }


    public String getFirstName() {
        Log.i("first name ","first name " + firstName);
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
