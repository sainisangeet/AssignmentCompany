package com.example.sangeeth.assignment.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sangeeth.assignment.R;

import java.util.List;

public class ListViewDatabase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_database);

        Intent intent = getIntent();
  //      List<Contacts> contactsList = (List<Contacts>) intent.getSerializableExtra("data");

        final DataBaseHandler dataBaseHandler = new DataBaseHandler(this);
        List<Contacts> contactsList = dataBaseHandler.getalldata();

     //   Log.e("name", String.valueOf(contactsList.size()));

        ListView listView = (ListView) findViewById(R.id.listviewdatabase);

        DatabaseAdapter adapter = new DatabaseAdapter(ListViewDatabase.this,contactsList);
        listView.setAdapter(adapter);
    }
}
