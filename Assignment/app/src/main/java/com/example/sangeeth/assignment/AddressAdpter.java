package com.example.sangeeth.assignment;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sangeeth.assignment.data.AddressUser;
import com.example.sangeeth.assignment.data.BillingAddress;

import java.io.Serializable;
import java.util.List;


/**
 * Created by sangeeth on 21/1/17.
 */

public class AddressAdpter extends RecyclerView.Adapter<AddressAdpter.MyViewHolder> implements RecyclerView.OnClickListener {


    //private List<AddressGetterSetter>  addressList;
    private Context context;
    private static String TAG = AddressAdpter.class.getSimpleName();
    private int position;
    BillingAddress[] addressuser;

    @Override
    public void onClick(View v) {
        final Intent intent;
   //     if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        Toast.makeText(context, " onclick "+position, Toast.LENGTH_SHORT).show();

        intent =  new Intent(context, UpdateAddress.class);
        intent.putExtra("Address", (BillingAddress) v.getTag());
        context.startActivity(intent);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {

        public TextView firstName,lastName,streetAddess1,streetAddress2,State,pincode;

        public MyViewHolder(View itemView) {
            super(itemView);
            firstName = (TextView) itemView.findViewById(R.id.firstname);
            lastName = (TextView) itemView.findViewById(R.id.lastname);
            streetAddess1 = (TextView) itemView.findViewById(R.id.address1);
            streetAddress2 = (TextView) itemView.findViewById(R.id.address2);
            State = (TextView) itemView.findViewById(R.id.state);
            pincode = (TextView) itemView.findViewById(R.id.pincode);

        }

    }

    public AddressAdpter(Context context, BillingAddress[] addressuser, Application application) {
        this.context = context;
        this.addressuser = addressuser;
    }


    @Override
    public AddressAdpter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.addaddress_textview, parent, false);
        itemView.setOnClickListener(this);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        BillingAddress address = addressuser[position];

        Log.d("ddddd ", "  onBindViewHolder "+position+ " "+address.getAddressFirstName());
        holder.firstName.setText(address.getAddressFirstName());
//        holder.lastName.setText(address.getLastName());
//        holder.streetAddess1.setText(address.getStreetAddress1());
//        holder.streetAddress2.setText(address.getStreetAddress2());
//        holder.State.setText(address.getState());
//        holder.pincode.setText(address.getPinCode());
        this.position = position;
        holder.itemView.setTag(address);

    }

    @Override
    public int getItemCount() {
   //     Log.i(TAG,"hello " + addressList.size() + "");
        return addressuser.length;

    }




}
 /*   LayoutInflater inflater;
    List<CompanyData> companyDataList;

    public AddressAdpter(Context context,List<CompanyData> companyDataList) {


        this.companyDataList = companyDataList;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return companyDataList.size();
    }

    @Override
    public CompanyData getItem(int position) {
        return companyDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView1, ViewGroup parent) {


        View convertView = null;
        CompanyData companyData = getItem(position);
        ViewHolder viewHolder;

        Log.d(" adapter ",position+" "+companyData.getCompany());

        //LayoutInflater inflater = context.getLayoutInflater();
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.custom_item, null);
            viewHolder = new ViewHolder();
            viewHolder.tv1 = (TextView) convertView.findViewById(R.id.textView1);
            viewHolder.tv2 = (TextView) convertView.findViewById(R.id.textView2);
            convertView.setTag(viewHolder);

        } else {

            viewHolder = (ViewHolder) convertView.getTag();

        }


        viewHolder.tv1.setText(companyData.getCompany());
        viewHolder.tv2.setText(companyData.getState());




        return convertView;
    }

    public class ViewHolder {
        TextView tv1,tv2;
    }

}*/
