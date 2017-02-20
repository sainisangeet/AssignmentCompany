package com.example.sangeeth.assignment.pagination;

import android.view.View;
import android.widget.ProgressBar;

import com.example.sangeeth.assignment.R;
import com.example.sangeeth.assignment.pagination.RecyclerViewHolders;

public class ProgressViewHolder extends RecyclerViewHolders {
    public ProgressBar progressBar;
    public ProgressViewHolder(View itemView) {
        super(itemView);
        progressBar = (ProgressBar)itemView.findViewById(R.id.progressBar);
    }
}