package com.example.sangeeth.assignment.listfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.sangeeth.assignment.R;

/**
 * Created by sangeeth on 7/2/17.
 */

public class Fragments1 extends ListFragment implements AdapterView.OnItemClickListener {

    Fragment fr;
    ArrayAdapter adapter;
    FragmentManager fm;
    FragmentTransaction ft;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parentViewGroup,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmentlist_textview, parentViewGroup, false);
        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.state, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener( this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String str = (String) adapter.getItem(position);
        Log.d("adapter value is ",str);

        fr = DetailFragment.newInstances(getString(getResources().getIdentifier(str,"string", getActivity().getPackageName())));
   //     fr = DetailFragment.newInstances("hello");
       fm = getFragmentManager();
       ft = fm.beginTransaction();
        ft.replace(R.id.activity_fragment_list, fr);
        ft.addToBackStack(null);
        ft.commit();
   }

}
