package com.example.sangeeth.assignment.recyclerviewwithprogressbar;

import java.io.Serializable;

/**
 * Created by sangeeth on 8/2/17.
 */

public class ModelObject implements Serializable {

    private String name;
    private String email;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
