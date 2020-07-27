package com.sample.shetkarisahayogaggregator.DashboardActivities;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.shetkarisahayogaggregator.R;

public class AggregatorViewHolder extends RecyclerView.ViewHolder {

    TextView textViewDemandName, textViewDemandAggId, textViewDemandFarmProduct, textViewDemandQuantity, textViewDemandAddress, textViewDemandDate;
    Button buttonAccept;

    public AggregatorViewHolder(@NonNull View itemView) {
        super(itemView);

        textViewDemandName = itemView.findViewById(R.id.aggDemandName);
        textViewDemandAggId = itemView.findViewById(R.id.aggDemandId);
        textViewDemandFarmProduct = itemView.findViewById(R.id.aggDemandedCrop);
        textViewDemandQuantity = itemView.findViewById(R.id.aggDemandQuantityReq);
        textViewDemandAddress = itemView.findViewById(R.id.aggDemandAddress);
        textViewDemandDate = itemView.findViewById(R.id.aggDemandDate);
    }
}
