package com.example.sangeeth.assignment.pageviewer;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sangeeth.assignment.R;

public class PagerView extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        CustomPagerAdapter adapter = new CustomPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new NewFragment1(),null);
        adapter.addFragment(new NewFragment2(),null);
        adapter.addFragment(new NewFragment3(),null);
        adapter.addFragment(new NewFragment4(),null);
        adapter.addFragment(new NewFragment5(),null);

        viewPager.setAdapter(adapter);
    }
}
