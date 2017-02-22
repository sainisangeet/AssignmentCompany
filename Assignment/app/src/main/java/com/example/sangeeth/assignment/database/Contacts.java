package com.example.sangeeth.assignment.database;

import java.io.Serializable;

/**
 * Created by sangeeth on 21/2/17.
 */

public class Contacts implements Serializable {

    public Contacts(){

    }

    String name;

    public Contacts(String name,String mobile){
        this.name = name;
        this.mobile=mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String mobile;
}
