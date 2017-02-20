package com.example.sangeeth.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URISyntaxException;

public class DisplayData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);
        TextView company = (TextView) findViewById(R.id.company_name);
        TextView tin = (TextView) findViewById(R.id.tin_number);
        TextView pan = (TextView) findViewById(R.id.company_pan);
        TextView property = (TextView) findViewById(R.id.property_name);
        TextView establish = (TextView) findViewById(R.id.established);
        TextView states = (TextView) findViewById(R.id.state);
        TextView cities = (TextView) findViewById(R.id.city);
        TextView address1 = (TextView) findViewById(R.id.address_line1);
        TextView address2 = (TextView) findViewById(R.id.address_line2);
        TextView pin = (TextView) findViewById(R.id.pin_code);
        TextView msupply = (TextView) findViewById(R.id.msupply_contact);
        TextView service = (TextView) findViewById(R.id.service_tax);

        Intent intent = getIntent();
        CompanyData companyData = (CompanyData) intent.getSerializableExtra("companydata");
        company.setText(companyData.getCompany());
        tin.setText(companyData.getTin());
        pan.setText(companyData.getPan());
        property.setText(companyData.getProperty());
        establish.setText(companyData.getYear());
        states.setText(companyData.getState());
        cities.setText(companyData.getCity());
        address1.setText(companyData.getAddress1());
        address2.setText(companyData.getAddress2());
        pin.setText(companyData.getPin_code());
        msupply.setText(companyData.getContact());
        service.setText(companyData.getService());
    }

}
