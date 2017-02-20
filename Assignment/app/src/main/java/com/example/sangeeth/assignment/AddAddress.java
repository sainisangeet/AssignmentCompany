package com.example.sangeeth.assignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.example.sangeeth.assignment.data.AddressUser;
import com.example.sangeeth.assignment.data.BillingAddress;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class AddAddress extends AppCompatActivity {

    ListView listview;
    private static String TAG = AddAddress.class.getSimpleName();
    String array[] = {"sys 1", "sys 2", "sys 3", "sys 4","sys 1", "sys 2", "sys 3", "sys 4",
            "sys 1", "sys 2", "sys 3", "sys 4","sys 1", "sys 2", "sys 3", "sys 4","sys 1", "sys 2", "sys 3", "sys 4","sys 1", "sys 2", "sys 3", "sys 4"};

    List<AddressGetterSetter> addressList = new ArrayList<>();
    RecyclerView recyclerView;
    AddressAdpter addressAdpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        getUserAddress();


        //prepareData();


    }

    /**
     * inside the oncreate method
     */

     /*  ArrayAdapter adapter = new ArrayAdapter(AddAddress.this, R.layout.addaddress_textview, array);
        listview.setAdapter(adapter);
        Log.i(TAG,"you are in the log");



        CompanyData companyData = new CompanyData();
        companyData.setState("Karnataka");
        companyData.setCompany("msupply1");

        CompanyData companyData1 = new CompanyData();
        companyData1.setState("Karnataka1");
        companyData1.setCompany("msupply2");


        CompanyData companyData2 = new CompanyData();
        companyData2.setState("Karnataka2");
        companyData2.setCompany("msupply2");


        CompanyData companyData3 = new CompanyData();
        companyData3.setState("Karnataka3");
        companyData3.setCompany("msupply2");


        CompanyData companyData4 = new CompanyData();
        companyData4.setState("Karnataka4");
        companyData4.setCompany("msupply2");

        companyDataList.add(companyData);
        companyDataList.add(companyData1);
        companyDataList.add(companyData2);
        companyDataList.add(companyData3);
        companyDataList.add(companyData4);

        AddressAdpter addAddress = new AddressAdpter(AddAddress.this,companyDataList);
        listview.setAdapter(addAddress);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {

               // CompanyData companyData5 = addAddress.getItem(position);

                Intent intent = new Intent(AddAddress.this, UpdateAddress.class);
                startActivity(intent);
            }
        });
*/

    public void prepareData(){
        AddressGetterSetter addressData = new AddressGetterSetter("ram","saini","karnataka","karnataka2","Karnataka","560102");
        addressList.add(addressData);


        AddressGetterSetter addressData1 = new AddressGetterSetter("shyam","saini","karnataka","karnataka2","Haryana","560103");
        addressList.add(addressData1);



    }

    private String payload = "{\"http_code\":\"200\",\"message\":{\"billingAddress\":[{\"addressFirstName\":\"Riya\",\"addressLastName\":\"k\",\"addressEmail\":\"\",\"addressMobile\":\"9985653645\",\"addressLine1\":\"Address 1\",\"addressLine2\":\"Address 2\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Bangalore\",\"state\":\"Karnataka\",\"country\":\"India\",\"pincode\":\"560000\",\"default\":false,\"addressId\":2},{\"addressFirstName\":\"Riya\",\"addressLastName\":\"Bale\",\"addressEmail\":\"\",\"addressMobile\":\"9879987878\",\"addressLine1\":\"HSR Layout Sector 2\",\"addressLine2\":\"\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Thiruvananthapuram\",\"state\":\"Kerala\",\"country\":\"India\",\"pincode\":\"678675\",\"default\":false,\"addressId\":17},{\"addressFirstName\":\"Vivek\",\"addressLastName\":\"MV\",\"addressEmail\":\"\",\"addressMobile\":\"7403612994\",\"addressLine1\":\"Kochi\",\"addressLine2\":\"\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Ernakulam\",\"state\":\"Kerala\",\"country\":\"India\",\"pincode\":\"560102\",\"default\":true,\"addressId\":18},{\"addressFirstName\":\"Riya\",\"addressLastName\":\"k\",\"addressEmail\":\"\",\"addressMobile\":\"9985653645\",\"addressLine1\":\"Address 1\",\"addressLine2\":\"Address 2\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Bangalore\",\"state\":\"Karnataka\",\"country\":\"India\",\"pincode\":\"560000\",\"default\":false,\"addressId\":2},{\"addressFirstName\":\"Riya\",\"addressLastName\":\"Bale\",\"addressEmail\":\"\",\"addressMobile\":\"9879987878\",\"addressLine1\":\"HSR Layout Sector 2\",\"addressLine2\":\"\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Thiruvananthapuram\",\"state\":\"Kerala\",\"country\":\"India\",\"pincode\":\"678675\",\"default\":false,\"addressId\":17},{\"addressFirstName\":\"Vivek\",\"addressLastName\":\"MV\",\"addressEmail\":\"\",\"addressMobile\":\"7403612994\",\"addressLine1\":\"Kochi\",\"addressLine2\":\"\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Ernakulam\",\"state\":\"Kerala\",\"country\":\"India\",\"pincode\":\"560102\",\"default\":true,\"addressId\":18},{\"addressFirstName\":\"Riya\",\"addressLastName\":\"k\",\"addressEmail\":\"\",\"addressMobile\":\"9985653645\",\"addressLine1\":\"Address 1\",\"addressLine2\":\"Address 2\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Bangalore\",\"state\":\"Karnataka\",\"country\":\"India\",\"pincode\":\"560000\",\"default\":false,\"addressId\":2},{\"addressFirstName\":\"Riya\",\"addressLastName\":\"Bale\",\"addressEmail\":\"\",\"addressMobile\":\"9879987878\",\"addressLine1\":\"HSR Layout Sector 2\",\"addressLine2\":\"\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Thiruvananthapuram\",\"state\":\"Kerala\",\"country\":\"India\",\"pincode\":\"678675\",\"default\":false,\"addressId\":17},{\"addressFirstName\":\"Vivek\",\"addressLastName\":\"MV\",\"addressEmail\":\"\",\"addressMobile\":\"7403612994\",\"addressLine1\":\"Kochi\",\"addressLine2\":\"\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Ernakulam\",\"state\":\"Kerala\",\"country\":\"India\",\"pincode\":\"560102\",\"default\":true,\"addressId\":18},{\"addressFirstName\":\"Riya\",\"addressLastName\":\"k\",\"addressEmail\":\"\",\"addressMobile\":\"9985653645\",\"addressLine1\":\"Address 1\",\"addressLine2\":\"Address 2\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Bangalore\",\"state\":\"Karnataka\",\"country\":\"India\",\"pincode\":\"560000\",\"default\":false,\"addressId\":2},{\"addressFirstName\":\"Riya\",\"addressLastName\":\"Bale\",\"addressEmail\":\"\",\"addressMobile\":\"9879987878\",\"addressLine1\":\"HSR Layout Sector 2\",\"addressLine2\":\"\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Thiruvananthapuram\",\"state\":\"Kerala\",\"country\":\"India\",\"pincode\":\"678675\",\"default\":false,\"addressId\":17},{\"addressFirstName\":\"Vivek\",\"addressLastName\":\"MV\",\"addressEmail\":\"\",\"addressMobile\":\"7403612994\",\"addressLine1\":\"Kochi\",\"addressLine2\":\"\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Ernakulam\",\"state\":\"Kerala\",\"country\":\"India\",\"pincode\":\"560102\",\"default\":true,\"addressId\":18},{\"addressFirstName\":\"Riya\",\"addressLastName\":\"k\",\"addressEmail\":\"\",\"addressMobile\":\"9985653645\",\"addressLine1\":\"Address 1\",\"addressLine2\":\"Address 2\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Bangalore\",\"state\":\"Karnataka\",\"country\":\"India\",\"pincode\":\"560000\",\"default\":false,\"addressId\":2},{\"addressFirstName\":\"Riya\",\"addressLastName\":\"Bale\",\"addressEmail\":\"\",\"addressMobile\":\"9879987878\",\"addressLine1\":\"HSR Layout Sector 2\",\"addressLine2\":\"\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Thiruvananthapuram\",\"state\":\"Kerala\",\"country\":\"India\",\"pincode\":\"678675\",\"default\":false,\"addressId\":17},{\"addressFirstName\":\"Vivek\",\"addressLastName\":\"MV\",\"addressEmail\":\"\",\"addressMobile\":\"7403612994\",\"addressLine1\":\"Kochi\",\"addressLine2\":\"\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Ernakulam\",\"state\":\"Kerala\",\"country\":\"India\",\"pincode\":\"560102\",\"default\":true,\"addressId\":18},{\"addressFirstName\":\"Riya\",\"addressLastName\":\"k\",\"addressEmail\":\"\",\"addressMobile\":\"9985653645\",\"addressLine1\":\"Address 1\",\"addressLine2\":\"Address 2\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Bangalore\",\"state\":\"Karnataka\",\"country\":\"India\",\"pincode\":\"560000\",\"default\":false,\"addressId\":2},{\"addressFirstName\":\"Riya\",\"addressLastName\":\"Bale\",\"addressEmail\":\"\",\"addressMobile\":\"9879987878\",\"addressLine1\":\"HSR Layout Sector 2\",\"addressLine2\":\"\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Thiruvananthapuram\",\"state\":\"Kerala\",\"country\":\"India\",\"pincode\":\"678675\",\"default\":false,\"addressId\":17},{\"addressFirstName\":\"Vivek\",\"addressLastName\":\"MV\",\"addressEmail\":\"\",\"addressMobile\":\"7403612994\",\"addressLine1\":\"Kochi\",\"addressLine2\":\"\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Ernakulam\",\"state\":\"Kerala\",\"country\":\"India\",\"pincode\":\"560102\",\"default\":true,\"addressId\":18},{\"addressFirstName\":\"Riya\",\"addressLastName\":\"k\",\"addressEmail\":\"\",\"addressMobile\":\"9985653645\",\"addressLine1\":\"Address 1\",\"addressLine2\":\"Address 2\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Bangalore\",\"state\":\"Karnataka\",\"country\":\"India\",\"pincode\":\"560000\",\"default\":false,\"addressId\":2},{\"addressFirstName\":\"Riya\",\"addressLastName\":\"Bale\",\"addressEmail\":\"\",\"addressMobile\":\"9879987878\",\"addressLine1\":\"HSR Layout Sector 2\",\"addressLine2\":\"\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Thiruvananthapuram\",\"state\":\"Kerala\",\"country\":\"India\",\"pincode\":\"678675\",\"default\":false,\"addressId\":17},{\"addressFirstName\":\"Vivek\",\"addressLastName\":\"MV\",\"addressEmail\":\"\",\"addressMobile\":\"7403612994\",\"addressLine1\":\"Kochi\",\"addressLine2\":\"\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Ernakulam\",\"state\":\"Kerala\",\"country\":\"India\",\"pincode\":\"560102\",\"default\":true,\"addressId\":18}],\"shippingAddress\":[{\"addressFirstName\":\"Keshav\",\"addressLastName\":\"Gupta\",\"addressEmail\":\"\",\"addressMobile\":\"8998877686\",\"addressLine1\":\"hjxczx\",\"addressLine2\":\"\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Chandigarh\",\"state\":\"Chandigarh\",\"country\":\"India\",\"pincode\":\"545544\",\"default\":false,\"addressId\":9},{\"addressFirstName\":\"Vivek\",\"addressLastName\":\"MV\",\"addressEmail\":\"\",\"addressMobile\":\"7403612994\",\"addressLine1\":\"Kochi\",\"addressLine2\":\"\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Ernakulam\",\"state\":\"Kerala\",\"country\":\"India\",\"pincode\":\"560102\",\"default\":true,\"addressId\":10}]}}";
            //"{\"http_code\":\"200\",\"message\":{\"billingAddress\":[{\"addressFirstName\":\"Riya\",\"addressLastName\":\"k\",\"addressEmail\":\"\",\"addressMobile\":\"9985653645\",\"addressLine1\":\"Address 1\",\"addressLine2\":\"Address 2\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Bangalore\",\"state\":\"Karnataka\",\"country\":\"India\",\"pincode\":\"560000\",\"default\":false,\"addressId\":2},{\"addressFirstName\":\"Riya\",\"addressLastName\":\"Bale\",\"addressEmail\":\"\",\"addressMobile\":\"9879987878\",\"addressLine1\":\"HSR Layout Sector 2\",\"addressLine2\":\"\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Thiruvananthapuram\",\"state\":\"Kerala\",\"country\":\"India\",\"pincode\":\"678675\",\"default\":false,\"addressId\":17},{\"addressFirstName\":\"Vivek\",\"addressLastName\":\"MV\",\"addressEmail\":\"\",\"addressMobile\":\"7403612994\",\"addressLine1\":\"Kochi\",\"addressLine2\":\"\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Ernakulam\",\"state\":\"Kerala\",\"country\":\"India\",\"pincode\":\"560102\",\"default\":true,\"addressId\":18}],\"shippingAddress\":[{\"addressFirstName\":\"Keshav\",\"addressLastName\":\"Gupta\",\"addressEmail\":\"\",\"addressMobile\":\"8998877686\",\"addressLine1\":\"hjxczx\",\"addressLine2\":\"\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Chandigarh\",\"state\":\"Chandigarh\",\"country\":\"India\",\"pincode\":\"545544\",\"default\":false,\"addressId\":9},{\"addressFirstName\":\"Vivek\",\"addressLastName\":\"MV\",\"addressEmail\":\"\",\"addressMobile\":\"7403612994\",\"addressLine1\":\"Kochi\",\"addressLine2\":\"\",\"addressLine3\":\"\",\"addressLine4\":\"\",\"addressLine5\":\"\",\"city\":\"Ernakulam\",\"state\":\"Kerala\",\"country\":\"India\",\"pincode\":\"560102\",\"default\":true,\"addressId\":10}]}}";

    private void getUserAddress(){
        Gson gson = new Gson();
        AddressUser addressuser = gson.fromJson(payload, AddressUser.class);

        Log.d(TAG, "addressuserv length "+ addressuser.getMessage().getBillingAddress().length);
        for(int i =0 ;i < addressuser.getMessage().getBillingAddress().length;i++){
            BillingAddress billingAddress = addressuser.getMessage().getBillingAddress()[i];
            Log.d(TAG, "addressuserv  first "+ billingAddress.getAddressFirstName());
            Log.d(TAG, "addressuserv last "+ billingAddress.getAddressLastName());
        }

        addressAdpter = new AddressAdpter(AddAddress.this,addressuser.getMessage().getBillingAddress(), getApplication());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        addressAdpter.notifyDataSetChanged();
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(addressAdpter);

    }

}