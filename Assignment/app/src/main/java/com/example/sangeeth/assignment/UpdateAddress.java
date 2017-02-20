package com.example.sangeeth.assignment;

import android.app.Activity;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sangeeth.assignment.data.BillingAddress;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class UpdateAddress extends AppCompatActivity {


    EditText firstName;
    EditText lastName;
    EditText streetAddress1;
    EditText streetAddress2;
    EditText mobile;
    Spinner state;
    Spinner city;
    Spinner country;
    Spinner pinCode;
    Spinner addressType;
    Button upDate;
    String Firstname ;
    String Lastname;
    String StreetAddress1;
    String StreetAddress2;
    String Mobile;
    String State;
    String City;
    String Country;
    String Pincode;
    String AddressType;
    ArrayAdapter<CharSequence> stateArray;
    BillingAddress addressGetterSetter;

    Map<String, List<String>> mStateMap = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_address);


        addressGetterSetter = (BillingAddress) getIntent().getSerializableExtra("Address");


        firstName = (EditText) findViewById(R.id.first_name);
        lastName = (EditText) findViewById(R.id.last_name);
        streetAddress1 = (EditText) findViewById(R.id.street_address1);
        streetAddress2 = (EditText) findViewById(R.id.street_address2);
        mobile = (EditText) findViewById(R.id.mobile_number);
        upDate = (Button) findViewById(R.id.update_address);
        state = (Spinner) findViewById(R.id.state);
        city = (Spinner) findViewById(R.id.city);
        country = (Spinner) findViewById(R.id.country_name);
        pinCode = (Spinner) findViewById(R.id.pin_code);
        addressType = (Spinner) findViewById(R.id.address_type);


        firstName.setText(addressGetterSetter.getAddressFirstName());
    /*    lastName.setText(addressGetterSetter.getLastName());
        streetAddress1.setText(addressGetterSetter.getStreetAddress1());
        streetAddress2.setText(addressGetterSetter.getStreetAddress2());*/
        OnClick();
    }




    public void OnClick() {

        spinner();

        upDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();

            }
        });


    }


    public void spinner() {

        stateArray = ArrayAdapter.createFromResource(this, R.array.state, R.layout.support_simple_spinner_dropdown_item);
        stateArray.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        state.setAdapter(stateArray);


     /*   int spinnerPosition = stateArray.getPosition(addressGetterSetter.getState());
        Log.i("position",spinnerPosition + "");
        state.setSelection(spinnerPosition);
*/



        mStateMap.put("Karnataka", Arrays.asList(getResources().getStringArray(R.array.karnataka_city)));
        mStateMap.put("Haryana", Arrays.asList(getResources().getStringArray(R.array.haryana_city)));
        mStateMap.put("Uttar Pradesh", Arrays.asList(getResources().getStringArray(R.array.up_city)));
        mStateMap.put("Madhya Pradesh", Arrays.asList(getResources().getStringArray(R.array.mp_city)));
        mStateMap.put("Punjab", Arrays.asList(getResources().getStringArray(R.array.punjab_city)));
        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String state = parent.getItemAtPosition(position).toString();
                List<String> cities = mStateMap.get(state);
                ArrayAdapter<String> dataAdapter = new ArrayAdapter(com.example.sangeeth.assignment.UpdateAddress.this, R.layout.support_simple_spinner_dropdown_item, cities);
                dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                city.setAdapter(dataAdapter);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });



        ArrayAdapter<CharSequence> countryArray = ArrayAdapter.createFromResource(this, R.array.country_array, R.layout.support_simple_spinner_dropdown_item);
        countryArray.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        country.setAdapter(countryArray);


        ArrayAdapter<CharSequence> pincodeArray = ArrayAdapter.createFromResource(this, R.array.picode, R.layout.support_simple_spinner_dropdown_item);
        pincodeArray.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        pinCode.setAdapter(pincodeArray);



/*
        spinnerPosition = pincodeArray.getPosition(addressGetterSetter.getPinCode());
        Log.i("position",spinnerPosition + "");
        if (spinnerPosition == -1) {
            pinCode.setSelection(spinnerPosition);
            Intent intent =  new Intent(this, AddAddress.class);
            startActivity(intent);
        }
*/


        ArrayAdapter<CharSequence> addresstypeArray = ArrayAdapter.createFromResource(this, R.array.address_type, R.layout.support_simple_spinner_dropdown_item);
        stateArray.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        addressType.setAdapter(addresstypeArray);

    }


/**
 * function for validation
 */

    public void validate(){
        Firstname = firstName.getText().toString();
        Lastname = lastName.getText().toString();
        StreetAddress1 = streetAddress1.getText().toString();
        StreetAddress2 = streetAddress2.getText().toString();
        Mobile = mobile.getText().toString();
        State = state.getSelectedItem().toString();
        City = city.getSelectedItem().toString();
        Country = country.getSelectedItem().toString();
        AddressType = addressType.getSelectedItem().toString();

        Boolean check = Validation.getInstance().companyname(Firstname);
        Boolean check1 = Validation.getInstance().companyname(Lastname);
        Boolean check2 = Validation.getInstance().address1(StreetAddress1);
        Boolean check3 = Validation.getInstance().mobile(Mobile);


        if (!check){
            firstName.setError("enter first name ");
        }
        else if (!check1) {
            lastName.setError("enter last name ");
        }
        else if (!check2) {
            streetAddress1.setError("enter correct address ");
        }
        else if (!check3) {
            mobile.setError("enter correct mobile ");
        }
        else
            Toast.makeText(getApplicationContext(),"all data is correct",Toast.LENGTH_SHORT).show();

    }

}




    /*


    public class LayoutActivity extends Activity implements Serializable {


    EditText address1;
    EditText address2;
  //  EditText pinCode;
    EditText provide;
    String company_name ;
    String tin_number;
    String pan_number;
    String tax_number;
    String property_name;
    String address_line1;
    String address_line2;
    String pin_code;
    String provide_msupply;
    RadioGroup radiogroup;


    Spinner establishe;


        /* Pattern name_Pattern = Pattern.compile("[[a-zA-z]|[a-zA-z]+[ \\t\\n\\x0b\\r\\f]+[a-zA-z]]{3,15}");
         Pattern pan_pattern = Pattern.compile("[A-Z]{5}+[0-9]{4}+[A-Z]{1}");
         Pattern service_pattern = Pattern.compile("[A-Z]{5}+[0-9]{4}+[A-Z]{1}+[S]+[T|D]+[0-9]{3}");
         Pattern address1_pattern = Pattern.compile("[A-Za-z_0-9]");
         Pattern address2_pattern = Pattern.compile("[A-Za-z_0-9]");




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout);
            value();

        }

        public  void value(){





            save = (Button) findViewById(R.id.save_data);
            final CompanyData companyData = new CompanyData();
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    company_name = companyName.getText().toString();
                    tin_number = tinNumber.getText().toString();
                    pan_number = panNumber.getText().toString();
                    tax_number = taxNumber.getText().toString();
                    property_name = property.getText().toString();
                    address_line1 = address1.getText().toString();
                    address_line2 = address2.getText().toString();
                    pin_code = pinCode.getText().toString();
                    property_name = provide.getText().toString();

                    //   Boolean value = validate();

                      sending the data using companyData class

                    // pinCode.getText().toString().length() != 6

                    //   Log.d("companyName ","companyName "+companyName.getText().toString());
                    //       Boolean check = validate();
                    // Validation ValiObject = Validation.getInstance();
                    Log.d("dsdd","company_name  "+company_name);
                    Boolean check = Validation.getInstance().companyname(company_name);
                    Boolean check1 = Validation.getInstance().tinnumber(tinNumber.getText().toString());
                    Boolean check2 = Validation.getInstance().pannumber(panNumber.getText().toString());
                    Boolean check3 = Validation.getInstance().taxnumber(taxNumber.getText().toString());
                    //   Boolean check4 = ValiObject.property(property.getText().toString());
                    Boolean check5 = Validation.getInstance().address1(address1.getText().toString());
                    Boolean check6 = Validation.getInstance().address2(address2.getText().toString());
                    Boolean check7 = Validation.getInstance().pincode(pinCode.getText().toString());
                    Boolean check8 = true;
                    if(radiogroup.getCheckedRadioButtonId() == R.id.yes) {
                        check8 = Validation.getInstance().provide(provide.getText().toString());
                    }
                    else
                        provide.getText().clear();
                    //        Boolean check9 = ValiObject.companyname(companyName.getText().toString());


                    if (!check){
                        // Toast.makeText(getApplicationContext(), "Enter All the Field", Toast.LENGTH_SHORT).show();
                        companyName.setError("enter company name ");
                    }
                    else if (!check1) {
                        // Toast.makeText(getApplicationContext(), "Enter All the Field", Toast.LENGTH_SHORT).show();
                        tinNumber.setError("enter correct tin number ");
                    }
                    else if (!check2) {
                        // Toast.makeText(getApplicationContext(), "Enter All the Field", Toast.LENGTH_SHORT).show();
                        panNumber.setError("enter correct pan number ");
                    }
                    else if (!check3) {
                        // Toast.makeText(getApplicationContext(), "Enter All the Field", Toast.LENGTH_SHORT).show();
                        taxNumber.setError("enter correct tax number ");
                    }
                    else if (!check5) {
                        // Toast.makeText(getApplicationContext(), "Enter All the Field", Toast.LENGTH_SHORT).show();
                        address1.setError("enter correct address ");
                    }
                    else if (!check6) {
                        // Toast.makeText(getApplicationContext(), "Enter All the Field", Toast.LENGTH_SHORT).show();
                        address2.setError("enter correct address ");
                    }
                    else if (!check7) {
                        // Toast.makeText(getApplicationContext(), "Enter All the Field", Toast.LENGTH_SHORT).show();
                        pinCode.setError("enter correct pin code ");
                    }
                    else if (!check8) {
                        // Toast.makeText(getApplicationContext(), "Enter All the Field", Toast.LENGTH_SHORT).show();
                        provide.setError("enter correct supply name");
                    }

                    else {
                        companyData.setCompany(companyName.getText().toString());
                        companyData.setTin(tinNumber.getText().toString());
                        companyData.setPan(panNumber.getText().toString());
                        companyData.setService(taxNumber.getText().toString());
                        companyData.setProperty(property.getText().toString());
                        companyData.setAddress1(address1.getText().toString());
                        companyData.setAddress2(address2.getText().toString());
                        companyData.setPin_code(pinCode.getText().toString());
                        companyData.setContact(provide.getText().toString());
                        companyData.setState(state.getSelectedItem().toString());
                        companyData.setCity(city.getSelectedItem().toString());
                        companyData.setYear(establishe.getSelectedItem().toString());
                        Intent intent = new Intent(getApplicationContext(), DisplayData.class);
                        intent.putExtra("companydata", companyData);
                        startActivity(intent);
                    }
                }
            });



            establishe = (Spinner) findViewById(R.id.established);
            Calendar currentYear = Calendar.getInstance();
            int year = currentYear.get(Calendar.YEAR);
            Log.i(TAG,"you are in log "  + " " + String.valueOf(year));
            String establishedYear[] = new String[16];
            for (int i=0;i<=15;i++){
                try {
                    establishedYear[i]= String.valueOf(year-i);
                    Log.i(TAG, establishedYear[i]);
                }
                catch (Exception ArrayIndexOutOfBoundsException){

                }
            }
            ArrayAdapter<String> establishArray = new ArrayAdapter(com.example.sangeeth.assignment.LayoutActivity.this,R.layout.support_simple_spinner_dropdown_item, establishedYear);
            establishArray.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            establishe.setAdapter(establishArray);
            establishe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String year = parent.getItemAtPosition(position).toString();
//                Intent intent = new Intent(getApplicationContext(),DisplayData.class);
//                intent.putExtra("year",year);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            state = (Spinner) findViewById(R.id.state);
            ArrayAdapter<CharSequence> stateArray = ArrayAdapter.createFromResource(this,R.array.state,R.layout.support_simple_spinner_dropdown_item);
            stateArray.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            state.setAdapter(stateArray);

            city = (Spinner) findViewById(R.id.city);
            mStateMap.put("Karnataka", Arrays.asList(getResources().getStringArray(R.array.karnataka_city)));
            mStateMap.put("Haryana", Arrays.asList(getResources().getStringArray(R.array.haryana_city)));
            mStateMap.put("Uttar Pradesh", Arrays.asList(getResources().getStringArray(R.array.up_city)));
            mStateMap.put("Madhya Pradesh", Arrays.asList(getResources().getStringArray(R.array.mp_city)));
            mStateMap.put("Punjab", Arrays.asList(getResources().getStringArray(R.array.punjab_city)));
            state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    String state = parent.getItemAtPosition(position).toString();
                    List<String> cities = mStateMap.get(state);
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter(com.example.sangeeth.assignment.LayoutActivity.this, R.layout.support_simple_spinner_dropdown_item, cities);
                    dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                    city.setAdapter(dataAdapter);
                ArrayAdapter<CharSequence> cityAdapter = null;
                switch (state){
                    case "Karnataka" :
                        cityAdapter = ArrayAdapter.createFromResource(LayoutActivity.this,R.array.karnataka_city,R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case "Haryana" :
                        cityAdapter = ArrayAdapter.createFromResource(LayoutActivity.this, R.array.haryana_city, R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case "Uttar Pradesh" :
                        cityAdapter = ArrayAdapter.createFromResource(LayoutActivity.this, R.array.up_city, R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case "Madhya Pradesh" :
                        cityAdapter = ArrayAdapter.createFromResource(LayoutActivity.this, R.array.mp_city, R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case "Punjab" :
                        cityAdapter = ArrayAdapter.createFromResource(LayoutActivity.this, R.array.punjab_city, R.layout.support_simple_spinner_dropdown_item);
                        break;
                }

                cityAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                city.setAdapter(cityAdapter);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });




             * for using the radio button

            radiogroup = (RadioGroup) findViewById(R.id.radioButton);
            radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if(checkedId == R.id.no){
                        provide.setEnabled(false);
                    }
                    else {
                        provide.setEnabled(true);
                    }
                }
            });
        }


         * validating the data
         * @return

    public Boolean validate(){

        AlertDialog alertDialog = new AlertDialog.Builder(
                LayoutActivity.this).create();

        if(companyName.getText().toString().equals("") || pinCode.getText().toString().equals("") || panNumber.getText().toString().equals("")){
         //   Toast.makeText(getApplicationContext(), "Enter All the Field", Toast.LENGTH_SHORT).show();
            alertDialog.setMessage("enter all the field");
            alertDialog.show();
            return false;
        }

        else if (!companyName.getText().toString().matches(String.valueOf(name_Pattern))) {
            Toast.makeText(getApplicationContext(), " Invalid Company Name", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(pinCode.getText().toString().length() != 6 || tinNumber.getText().toString().length() != 11){

            Toast.makeText(getApplicationContext(), "Enter correct pin code and tin number", Toast.LENGTH_SHORT).show();
            return false;
        }

        else if(!panNumber.getText().toString().matches(String.valueOf(pan_pattern))){
            Toast.makeText(getApplicationContext(), "incorrect pan number", Toast.LENGTH_SHORT).show();
            return false;

        }
        else if(!taxNumber.getText().toString().matches(String.valueOf(service_pattern))){

            Toast.makeText(getApplicationContext(), "in correct service tax number", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(address1.getText().toString().matches(String.valueOf(address1_pattern))){

            Toast.makeText(getApplicationContext(), "in correct service tax number", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(address2.getText().toString().matches(String.valueOf(address2_pattern))){

            Toast.makeText(getApplicationContext(), "in correct service tax number", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
            return true;

    }

*/















