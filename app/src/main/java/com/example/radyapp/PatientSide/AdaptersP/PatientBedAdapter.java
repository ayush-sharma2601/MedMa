package com.example.radyapp.PatientSide.AdaptersP;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.PatientSide.ModelsP.PatientBedModel;
import com.example.radyapp.R;

import java.util.ArrayList;

public class PatientBedAdapter extends RecyclerView.Adapter<PatientBedAdapter.PatientBedAdapterRvRH> {

    ArrayList<PatientBedModel> patientBedModels ;


    @NonNull
    @Override
    public PatientBedAdapterRvRH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PatientBedAdapterRvRH(LayoutInflater.from(parent.getContext()).inflate(R.layout.patient_appointment_rv_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PatientBedAdapterRvRH holder, int position) {
        holder.populateBeds(patientBedModels.get(position));
    }

    @Override
    public int getItemCount() {
        return patientBedModels.size();
    }

    public class PatientBedAdapterRvRH extends RecyclerView.ViewHolder
    {

        public PatientBedAdapterRvRH(@NonNull View itemView) {
            super(itemView);
        }

        public void populateBeds(PatientBedModel patientBedModel) {
        }
    }
}
