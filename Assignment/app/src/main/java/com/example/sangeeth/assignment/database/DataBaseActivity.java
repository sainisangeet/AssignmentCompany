package com.example.sangeeth.assignment.database;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.sangeeth.assignment.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataBaseActivity extends AppCompatActivity {

    Button insertData,getData;

    String name="names";
    String mobile="9996920147";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
        insertData = (Button) findViewById(R.id.insertdata);
        getData = (Button) findViewById(R.id.getdata);
        final DataBaseHandler dataBaseHandler = new DataBaseHandler(this);
        insertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i =0;i<5;i++) {
                    long result = dataBaseHandler.addContacts(new Contacts(name,mobile));
              //      Log.i("result",result + "");
                }

            }
        });

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(DataBaseActivity.this, ListViewDatabase.class);
                    startActivity(intent);
            }
        });
    }
}
