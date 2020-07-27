package com.sample.shetkarisahayogaggregator.DashboardActivities;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.shetkarisahayogaggregator.R;

public class FarmerViewHolder extends RecyclerView.ViewHolder {

    TextView textViewName, textViewAppId, textViewMobileNo, textViewAddress;

    public FarmerViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewName = itemView.findViewById(R.id.farmerName);
        textViewAppId = itemView.findViewById(R.id.farmerId);
        textViewMobileNo = itemView.findViewById(R.id.farmerMobileNo);
        textViewAddress = itemView.findViewById(R.id.farmerAddress);
    }
}
