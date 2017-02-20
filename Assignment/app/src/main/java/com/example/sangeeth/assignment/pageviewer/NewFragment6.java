package com.example.sangeeth.assignment.pageviewer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sangeeth.assignment.R;

/**
 * Created by sangeeth on 6/2/17.
 */

public class NewFragment6 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.newfragment6, container, false);
        return view;
    }

}
