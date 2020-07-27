package com.sample.shetkarisahayogaggregator.DashboardActivities;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.shetkarisahayogaggregator.R;

public class ComplaintViewHolder extends RecyclerView.ViewHolder{
    TextView textViewFarmerId, textViewDate, textViewAggregatorId, textViewComplaintText;

    public ComplaintViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewFarmerId = itemView.findViewById(R.id.complaintFarmerId);
        textViewDate = itemView.findViewById(R.id.complaintDate);
        textViewAggregatorId = itemView.findViewById(R.id.complaintAggId);
        textViewComplaintText = itemView.findViewById(R.id.complaintText);
    }
}
