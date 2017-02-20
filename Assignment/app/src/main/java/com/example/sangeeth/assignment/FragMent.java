package com.example.sangeeth.assignment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragMent extends Fragment {

    TextView text, vers;
    Button newFragment;
    Fragment fr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parentViewGroup,
                             Bundle savedInstanceState) {

       // Log.d("hello", "hello");

        View view = inflater.inflate(R.layout.fragment_textview, parentViewGroup, false);

        fr = new Fragment3();

        newFragment = (Button) view.findViewById(R.id.new_fragment);


        newFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.acivity_frag_ment2, fr);
            //    fragmentTransaction.remove(R.id.acivity_frag_ment2,fr);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        return view;

    }

}
