package com.example.sangeeth.assignment.listfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sangeeth.assignment.R;

public class FragmentList extends AppCompatActivity {

    ListView listView;
    Fragments1 fr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment_list);
        fr = new Fragments1();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.activity_fragment_list, fr);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();



    }
}
