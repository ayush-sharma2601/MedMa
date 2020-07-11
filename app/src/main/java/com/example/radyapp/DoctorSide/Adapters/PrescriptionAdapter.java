package com.example.radyapp.DoctorSide.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.DoctorSide.ResponseModels.MedModel;
import com.example.radyapp.DoctorSide.ResponseModels.PrescriptionModel;
import com.example.radyapp.R;

import java.util.ArrayList;

public class PrescriptionAdapter extends RecyclerView.Adapter<PrescriptionAdapter.PrescriptionRVVH> {

    ArrayList<PrescriptionModel> prescriptions;


    public PrescriptionAdapter(ArrayList<PrescriptionModel> prescriptions) {
        this.prescriptions = prescriptions;
    }

    @NonNull
    @Override
    public PrescriptionRVVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new PrescriptionRVVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.prescription_rv_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PrescriptionRVVH holder, int position) {

        holder.populateDocAppointments(prescriptions.get(position));
    }

    @Override
    public int getItemCount() {
        return prescriptions.size();
    }

    public class PrescriptionRVVH extends RecyclerView.ViewHolder
    {
        TextView medName,medDosage,medComments;

        public PrescriptionRVVH(@NonNull View itemView) {
            super(itemView);

            medName =itemView.findViewById(R.id.pres_name);
            medDosage = itemView.findViewById(R.id.pres_dosage);
            medComments = itemView.findViewById(R.id.pres_comment);

        }

        public void populateDocAppointments(PrescriptionModel prescriptionModel) {

            medName.setText(prescriptionModel.getMedName());
            medDosage.setText(prescriptionModel.getDosage());
            medComments.setText(prescriptionModel.getComments());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
