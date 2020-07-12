package com.example.radyapp.DoctorSide.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.DoctorSide.Activities.DoctorAppointmentInternal;
import com.example.radyapp.DoctorSide.ResponseModels.DocAppointmentModel;
import com.example.radyapp.DoctorSide.ResponseModels.MedModel;
import com.example.radyapp.DoctorSide.ResponseModels.TextModel;
import com.example.radyapp.R;

import java.util.ArrayList;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.InventtoryAdapterRVVH> {

    ArrayList<MedModel> medicineModels;
    int code;

    public InventoryAdapter(ArrayList<MedModel> medicineModels,int code) {
        this.medicineModels = medicineModels;
        this.code =code;
    }

    @NonNull
    @Override
    public InventtoryAdapterRVVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new InventtoryAdapterRVVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.medecine_model_rv_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull InventtoryAdapterRVVH holder, int position) {

        holder.populateDocAppointments(medicineModels.get(position));
    }

    @Override
    public int getItemCount() {
        return medicineModels.size();
    }

    public class InventtoryAdapterRVVH extends RecyclerView.ViewHolder
    {
        TextView medName,medStock;

        public InventtoryAdapterRVVH(@NonNull View itemView) {
            super(itemView);

            medName =itemView.findViewById(R.id.medicine_name);
            medStock = itemView.findViewById(R.id.medicine_stock);

        }

        public void populateDocAppointments(MedModel med) {

            medName.setText(med.getMedName());
            medStock.setText(Integer.toString(med.getStock()));

            if(code==1)
            {
                itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),"selected",Toast.LENGTH_LONG).show();
                }
                 });
            }
        }
    }
}
