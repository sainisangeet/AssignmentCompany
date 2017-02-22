package com.example.sangeeth.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.sangeeth.assignment.database.DataBaseActivity;
import com.example.sangeeth.assignment.expandableview.ExpandableViews;
import com.example.sangeeth.assignment.listfragment.FragmentList;
import com.example.sangeeth.assignment.pageviewer.PagerView;
import com.example.sangeeth.assignment.recyclerviewwithprogressbar.RecyclerViewMainactivity;
import com.example.sangeeth.assignment.tabview.TabViewers;
import com.example.sangeeth.assignment.volley.MainActivity;


public class AssignMent extends AppCompatActivity {

    Button assignment1, assignment2, assignment3, assignment4, assignment5, assignment6,assignment7,assignment8,assignment9,assignment10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_ment);
        assignment1 = (Button) findViewById(R.id.assignment1);
        assignment2 = (Button) findViewById(R.id.assignment2);
        assignment3 = (Button) findViewById(R.id.assignment3);
        assignment4 = (Button) findViewById(R.id.assignment4);
        assignment5 = (Button) findViewById(R.id.assignment5);
        assignment6 = (Button) findViewById(R.id.assignment6);
        assignment7 = (Button) findViewById(R.id.assignment7);
        assignment8 = (Button) findViewById(R.id.assignment8);
        assignment9 = (Button) findViewById(R.id.assignment9);
        assignment10 = (Button) findViewById(R.id.assignment10);
        OnClick();
    }

    public void OnClick() {

        assignment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssignMent.this, LayoutActivity.class);
                startActivity(intent);
            }
        });


        assignment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssignMent.this, AddAddress.class);
                startActivity(intent);
            }
        });


        assignment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssignMent.this, Fragment1.class);
                startActivity(intent);
            }
        });


        assignment4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssignMent.this, PagerView.class);
                startActivity(intent);
            }
        });

        assignment5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssignMent.this, TabViewers.class);
                startActivity(intent);
            }
        });

        assignment6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssignMent.this, ExpandableViews.class);
                startActivity(intent);
            }
        });


        assignment7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssignMent.this, FragmentList.class);
                startActivity(intent);
            }
        });

        assignment8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssignMent.this, RecyclerViewMainactivity.class);
                startActivity(intent);
            }
        });

        assignment9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssignMent.this, MainActivity.class);
                startActivity(intent);
            }
        });


        assignment10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssignMent.this, DataBaseActivity.class);
                startActivity(intent);
            }
        });
    }
}
