package com.example.sangeeth.assignment;

import android.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * Created by sangeeth on 20/1/17.
 */

public class Validation {

    private static Validation validate = new Validation();
    private static final String TAG = Validation.class.getSimpleName();

    Pattern name_Pattern = Pattern.compile("[[a-zA-z]|[a-zA-z]+[ \\t\\n\\x0b\\r\\f]+[a-zA-z]]{3,15}");
    Pattern pan_pattern = Pattern.compile("[A-Z]{5}+[0-9]{4}+[A-Z]{1}");
    Pattern service_pattern = Pattern.compile("[A-Z]{5}+[0-9]{4}+[A-Z]{1}+[S]+[T|D]+[0-9]{3}");
    Pattern address1_pattern = Pattern.compile("[A-Za-z_0-9#,-]{5,50}");
    Pattern address2_pattern = Pattern.compile("[A-Za-z_0-9#,-]{5,50}");

    private Validation(){

    }

    public static Validation getInstance() {
        return validate;
    }



    public Boolean companyname(String s){

        Log.d(TAG," comapny name paterrn "+s.matches(String.valueOf(name_Pattern)));

        if (s.matches(String.valueOf(name_Pattern))) {
            return true;
        }
        else
            return false;
    }

    public Boolean tinnumber(String s){

        if (s.length() == 11) {
            return true;
        }
        else
            return false;
    }
    public Boolean pannumber(String s){

        if (s.matches(String.valueOf(pan_pattern))) {
            return true;
        }
        else
            return false;
    }

    public Boolean taxnumber(String s){

        if (s.matches(String.valueOf(service_pattern))) {
            return true;
        }
        else
            return false;
    }
/*
    public Boolean property(String s){

        if (s.matches(String.valueOf())) {
            return true;
        }
        else
            return false;
    }*/

    public Boolean address1(String s){

        if (s.matches(String.valueOf(address1_pattern))) {
            return true;
        }
        else
            return false;
    }
    public Boolean address2(String s){

        if (s.matches(String.valueOf(address2_pattern))) {
            return true;
        }
        else
            return false;
    }
    public Boolean pincode(String s){

        if (s.length() == 6) {
            return true;
        }
        else
            return false;
    }
    public Boolean provide(String s){

        if (s.matches(String.valueOf(name_Pattern))) {
            return true;
        }
        else
            return false;
    }

    public Boolean mobile(String s){
        if(s.length() == 10)
            return true;
        else
            return false;
    }








}
