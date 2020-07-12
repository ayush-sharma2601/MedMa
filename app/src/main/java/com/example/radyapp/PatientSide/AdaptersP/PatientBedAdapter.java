package com.example.radyapp.PatientSide.AdaptersP;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.PatientSide.ModelsP.PatientBedModel;
import com.example.radyapp.R;

import java.util.ArrayList;

public class PatientBedAdapter extends RecyclerView.Adapter<PatientBedAdapter.PatientBedAdapterRvRH> {

    ArrayList<PatientBedModel> patientBedModels ;

    public PatientBedAdapter(ArrayList<PatientBedModel> patientBedModels) {
        this.patientBedModels = patientBedModels;
    }

    @NonNull
    @Override
    public PatientBedAdapterRvRH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PatientBedAdapterRvRH(LayoutInflater.from(parent.getContext()).inflate(R.layout.patient_bed_rv_layout,parent,false));
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
        TextView roomClass,roomOccupancy,roomVacancy,roomManager;
        ImageView roomCallButton;

        public PatientBedAdapterRvRH(@NonNull View itemView) {
            super(itemView);

            roomClass=itemView.findViewById(R.id.bed_class);
            roomOccupancy=itemView.findViewById(R.id.beds_occupied);
            roomVacancy=itemView.findViewById(R.id.beds_vacant);
            roomManager=itemView.findViewById(R.id.bed_manager);
            roomCallButton=itemView.findViewById(R.id.manager_bed_call_btn);

        }

        public void populateBeds(PatientBedModel patientBedModel) {

            roomClass.setText(patientBedModel.getBedClass());
            roomOccupancy.setText(patientBedModel.getOccupancy());
            roomVacancy.setText(patientBedModel.getVacancy());
            roomManager.setText(patientBedModel.getWardManager());
            //set Intent on call button here
        }
    }
}
