package com.example.sangeeth.assignment.listfragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sangeeth.assignment.R;

/**
 * Created by sangeeth on 8/2/17.
 */

public class DetailFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.detail_fragment, container, false);
        TextView textView = (TextView) view.findViewById(R.id.detailfragment);
        textView.setText(getArguments().getString("data"));
        return view;
    }

    public static DetailFragment newInstances(String string){
        DetailFragment detailFragment = new DetailFragment();

        Bundle bundle = new Bundle();
        bundle.putString("data",string);
        detailFragment.setArguments(bundle);
        return detailFragment;
    }

}
