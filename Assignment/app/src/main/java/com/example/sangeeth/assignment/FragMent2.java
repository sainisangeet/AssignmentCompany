package com.example.sangeeth.assignment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragMent2 extends Fragment{

    private static String TAG = FragMent2.class.getSimpleName();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.activity_frag_ment2, container, false);
        return view;
    }



    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        Log.d(TAG,"in onattach function");

    }

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        Log.d(TAG,"in oncreate method");

    }

/*
    @Override
    public void onAcivityCreated(Bundle savedInstanceState){

        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,"in oncreate method");

    }*/
}

