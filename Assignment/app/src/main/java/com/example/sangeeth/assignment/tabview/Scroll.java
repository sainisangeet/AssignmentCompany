package com.example.sangeeth.assignment.tabview;

import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sangeeth.assignment.R;
import com.example.sangeeth.assignment.pageviewer.CustomPagerAdapter;
import com.example.sangeeth.assignment.pageviewer.NewFragment1;
import com.example.sangeeth.assignment.pageviewer.NewFragment2;
import com.example.sangeeth.assignment.pageviewer.NewFragment3;
import com.example.sangeeth.assignment.pageviewer.NewFragment4;
import com.example.sangeeth.assignment.pageviewer.NewFragment5;
import com.example.sangeeth.assignment.pageviewer.NewFragment6;

public class Scroll extends AppCompatActivity {

    ViewPager viewPager;
    PagerTitleStrip pagerTitleStrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        CustomPagerAdapter adapter = new CustomPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new NewFragment1(),"one");
        adapter.addFragment(new NewFragment2(),"two");
        adapter.addFragment(new NewFragment3(),"three");
        adapter.addFragment(new NewFragment4(),"four");
        adapter.addFragment(new NewFragment5(),"five");
        adapter.addFragment(new NewFragment6(),"six");

        viewPager.setAdapter(adapter);

        pagerTitleStrip = (PagerTitleStrip) findViewById(R.id.pager_title_strip);

    }
}
