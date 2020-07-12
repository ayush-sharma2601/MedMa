package com.example.radyapp.PatientSide.AdaptersP;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.DoctorSide.Activities.DoctorAppointmentInternal;
import com.example.radyapp.DoctorSide.Adapters.AppointmentsAdapter;
import com.example.radyapp.DoctorSide.ResponseModels.DocAppointmentModel;
import com.example.radyapp.DoctorSide.ResponseModels.PrescriptionModel;
import com.example.radyapp.DoctorSide.ResponseModels.TextModel;
import com.example.radyapp.PatientSide.ModelsP.PatientApppointmentModel;
import com.example.radyapp.R;

import java.util.ArrayList;

public class PatientAppointmentAdapter extends RecyclerView.Adapter<PatientAppointmentAdapter.PatientAppointmentsAdapterRvVH> {

    ArrayList<PatientApppointmentModel> patientApppointmentModels;
    ArrayList<PrescriptionModel> prescriptionModels;
    int code;

    public PatientAppointmentAdapter(ArrayList<PatientApppointmentModel> patientApppointmentModels, ArrayList<PrescriptionModel> prescriptionModels, int code) {
        this.patientApppointmentModels = patientApppointmentModels;
        this.prescriptionModels = prescriptionModels;
        this.code = code;
    }

    @NonNull
    @Override
    public PatientAppointmentsAdapterRvVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (code == 0)
            return new PatientAppointmentsAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.appointment_model_rv_layout, parent, false));

        else
            return new PatientAppointmentsAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_refer_rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PatientAppointmentsAdapterRvVH holder, int position) {

        if (code == 0)
            holder.populatePatientAppointments(patientApppointmentModels.get(position));

        else
            holder.populatePatientPrescriptions(prescriptionModels.get(position));
    }

    @Override
    public int getItemCount() {
        if (code == 0)
            return patientApppointmentModels.size();
        else
            return prescriptionModels.size();
    }

    public class PatientAppointmentsAdapterRvVH extends RecyclerView.ViewHolder {
        TextView patientName, time;
        TextView doctorName;

        public PatientAppointmentsAdapterRvVH(@NonNull View itemView) {
            super(itemView);

            if (code == 0) {
                patientName = itemView.findViewById(R.id.name);
                time = itemView.findViewById(R.id.time);
            } else
                doctorName = itemView.findViewById(R.id.name);
        }

        public void populatePatientAppointments(PatientApppointmentModel patientApppointmentModel) {



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent appointmentInternal = new Intent(itemView.getContext(), DoctorAppointmentInternal.class);
                    itemView.getContext().startActivity(appointmentInternal);
                }
            });
        }

        public void populatePatientPrescriptions(PrescriptionModel prescriptionModel) {

        }
    }

    {
    }
}
