package com.example.sangeeth.assignment.tabview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sangeeth.assignment.R;

public class TabViewers extends AppCompatActivity {

    Button swipe,scroll,swipeandscroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_viewers);
        swipe = (Button) findViewById(R.id.swipe);
        scroll = (Button) findViewById(R.id.scroll);
        swipeandscroll = (Button) findViewById(R.id.swipeandscroll);


        swipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TabViewers.this,Swipe.class);
                startActivity(intent);
            }
        });


        swipeandscroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TabViewers.this,SwipeScroll.class);
                startActivity(intent);
            }
        });



        scroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TabViewers.this,Scroll.class);
                startActivity(intent);
            }
        });

    }
}
