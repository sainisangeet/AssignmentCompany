package com.example.sangeeth.assignment.recyclerviewwithprogressbar;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sangeeth.assignment.R;

import java.util.List;

/**
 * Created by sangeeth on 8/2/17.
 */

class UserAdapter extends RecyclerView.Adapter < RecyclerView.ViewHolder >{
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    private OnLoadMoreListener mOnLoadMoreListener;
    private boolean isLoading;
    private int visibleThreshold = 10;
    private int lastVisibleItem, totalItemCount;
    private Context context;
    private static String[] names;
    public  static  List<Products> mUsers;
    public UserAdapter(Context context,List<Products> modelObjects,RecyclerView mRecyclerView) {
        this.context = context;
        this.mUsers = modelObjects;
//        Log.e("hello product code is ",mUsers.length + "");
        this.names = names;
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.i("hello"," in the addonclicklistner ");
                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
       //         if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                    if (mOnLoadMoreListener != null) {
                        Log.e("hello", "hello in scroll");
                        mOnLoadMoreListener.onLoadMore();
                    }
                    isLoading = true;
          //      }
            }
        });
    }

    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.mOnLoadMoreListener = mOnLoadMoreListener;
    }
    @Override
    public int getItemViewType(int position) {
        return mUsers.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_useritem, parent, false);
            return new RecyclerViewMainactivity.UserViewHolder(view);
        } else if (viewType == VIEW_TYPE_LOADING) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_loading_progressbar, parent, false);
            return new RecyclerViewMainactivity.LoadingViewHolder(view);
        }
        return null;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RecyclerViewMainactivity.UserViewHolder) {
            Products user = mUsers.get(position);
            RecyclerViewMainactivity.UserViewHolder userViewHolder = (RecyclerViewMainactivity.UserViewHolder) holder;
            userViewHolder.tvName.setText(user.getProductEntity().getIdentifier().getSkuId());
            userViewHolder.tvEmailId.setText(user.getProductEntity().getIdentifier().getSkuName());
        } else if (holder instanceof RecyclerViewMainactivity.LoadingViewHolder) {
            RecyclerViewMainactivity.LoadingViewHolder loadingViewHolder = (RecyclerViewMainactivity.LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }
    }
    @Override
    public int getItemCount() {
        return mUsers == null ? 0 : mUsers.size();
    }

    public void setLoaded() {
        isLoading = false;
    }

    public void appendList(List<Products> product) {
        mUsers.addAll(product);
    }
}


