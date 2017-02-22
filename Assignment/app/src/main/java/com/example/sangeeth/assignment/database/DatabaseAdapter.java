package com.example.sangeeth.assignment.database;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sangeeth.assignment.AddressAdpter;
import com.example.sangeeth.assignment.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sangeeth on 21/2/17.
 */

public class DatabaseAdapter extends BaseAdapter {

    Context context;
    List<Contacts> contactsList;


    public DatabaseAdapter(Context contexts, List<Contacts> contactLists){
        this.context=contexts;
        this.contactsList=contactLists;


    }

    @Override
    public int getCount() {
  //      Log.e("contactsList.size()",contactsList.size() + "");
        return contactsList.size();
    }

    @Override
    public Object getItem(int position) {
    //    Log.e("contactsList.get(position)",contactsList.get(position) + "");
        return contactsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    /* private view holder class */
    static class ViewHolder {
        TextView name;
        TextView mobile;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = new ViewHolder();
   //     Log.e("hello","hello");

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.databaselistview_textview, parent,false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.mobile = (TextView) convertView.findViewById(R.id.mobile);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Contacts contactItem = (Contacts) getItem(position);

        viewHolder.name.setText(contactItem.getName());
        viewHolder.mobile.setText(contactItem.getMobile());
        return convertView;
    }
}
