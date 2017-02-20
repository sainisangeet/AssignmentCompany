package com.example.sangeeth.assignment;

/**
 * Created by sangeeth on 25/1/17.
 */

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
public class Fragment1 extends Activity {

    FragMent2 fr = new FragMent2();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_ment);
    }
}