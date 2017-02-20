package com.example.sangeeth.assignment.recyclerviewwithprogressbar;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.sangeeth.assignment.R;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.support.v7.widget.RecyclerView.*;

public class RecyclerViewMainactivity extends AppCompatActivity {

    public static final String JSON_URL = "http://stg.msupply.com/product/api/v1.0/productList";

    static int pageNumber=0;
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private UserAdapter mUserAdapter;
    public messageUser messageUsers = new messageUser();
    private String jsonString;
    public Gson gson;
    private static List<Products> products;
    private String TAG="RecyclerViewMainactivity";


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_mainactivity);
        mToolbar = (Toolbar) findViewById(R.id.toolbar2);
        mToolbar.setTitle("LoadMoreRecycleView");
        pageNumber =0;

        Log.e("messageUsers ",messageUsers + "");

        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Log.e("length of message user jsonstring is ", "hello " + jsonString);

    /*    mUserAdapter = new UserAdapter(RecyclerViewMainactivity.this, products , mRecyclerView);
        mRecyclerView.setAdapter(mUserAdapter);



        mUserAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                Log.e("haint", "Load More");
                products.add(null);
           //     mUserAdapter.notifyItemInserted(products.size() - 5);
                //Load more data for reyclerview
              *//*  new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {*//*
                        pageNumber=pageNumber+1;
                        sendRequest(pageNumber);
                        mUserAdapter.notifyDataSetChanged();
                        mUserAdapter.appendList(products);
                        mUserAdapter.setLoaded();
             *//*       }
                }, 1000);*//*
            }
        });*/


        sendRequest(pageNumber);

    }
    static class UserViewHolder extends ViewHolder {
        public TextView tvName;
        public TextView tvEmailId;
        public UserViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvEmailId = (TextView) itemView.findViewById(R.id.tvEmailId);
        }
    }
    static class LoadingViewHolder extends ViewHolder {
        public ProgressBar progressBar;
        public LoadingViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
        }
    }


    /**
     * request for json data from sewrver
     */



    public void sendRequest(final int pageNumber){

        RequestQueue requestQueue = Volley.newRequestQueue(RecyclerViewMainactivity.this);

            HashMap<String, String> params = new HashMap();
            params.put("category1", "Plumbing");
            params.put("itemsPerPage", "12");
            params.put("page", String.valueOf(pageNumber));
            params.put("skuNameSort", "1");

            final JSONObject jsonObject = new JSONObject(params);


            Log.i(TAG,"jsonObject "+jsonObject);

            JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, JSON_URL, jsonObject,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                Log.e("working fine ", "response data is getting" + "page number we called " + jsonObject.getInt(String.valueOf(pageNumber)));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Log.e("response", " " + response);
                            ShowResponse(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                                Toast.makeText(RecyclerViewMainactivity.this, error.toString() + " timeout", Toast.LENGTH_LONG).show();
                            } else if (error instanceof AuthFailureError) {
                                Toast.makeText(RecyclerViewMainactivity.this, error.toString() + " authfailure", Toast.LENGTH_LONG).show();
                            } else if (error instanceof ServerError) {
                                Toast.makeText(RecyclerViewMainactivity.this, error.toString() + " servererror", Toast.LENGTH_LONG).show();
                            } else if (error instanceof NetworkError) {
                                Toast.makeText(RecyclerViewMainactivity.this, error.toString() + " networkerror", Toast.LENGTH_LONG).show();
                            } else if (error instanceof ParseError) {
                                Toast.makeText(RecyclerViewMainactivity.this, error.toString() + " parserrerror", Toast.LENGTH_LONG).show();
                            }
                        }
                    });


            requestQueue.add(stringRequest);


        return;
    }

    public void ShowResponse(JSONObject json) {
 //       Log.e("response", " " + json);

        jsonString = json.toString();

        gson = new Gson();

        messageUsers = gson.fromJson(jsonString, messageUser.class);
        products = messageUsers.getMessage().getProduct();
        Log.e("products",products.size() + " " + products.isEmpty() );
        Log.e("in the exception", " messageUser " + messageUsers.getMessage().getTotalCount());
        Log.e("in the exception", " messageUser " + messageUsers.getMessage().getProduct().size());
        Log.e("in the exception", " messageUser " + messageUsers.getMessage().getFilterses().length);

        if(null==mUserAdapter){
        mUserAdapter = new UserAdapter(RecyclerViewMainactivity.this, messageUsers.getMessage().getProduct() , mRecyclerView);
        mRecyclerView.setAdapter(mUserAdapter);
        }else {
          if (!products.isEmpty()){
                mUserAdapter.appendList(products);
                mUserAdapter.notifyDataSetChanged();
      }
        }

        mUserAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                Log.e("haint", "Load More");
                //         products.add(null);
                     mUserAdapter.notifyItemInserted(products.size() - 1);
                //Load more data for reyclerview
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pageNumber++;
                        sendRequest(pageNumber);
                        mUserAdapter.notifyDataSetChanged();
                        mUserAdapter.setLoaded();
                    }
                }, 1000);
            }
        });


        return;

    }



}
