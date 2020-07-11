package com.example.radyapp.DoctorSide.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.DoctorSide.Activities.DoctorAppointmentInternal;
import com.example.radyapp.DoctorSide.ResponseModels.DocAppointmentModel;
import com.example.radyapp.DoctorSide.ResponseModels.TextModel;
import com.example.radyapp.R;

import java.util.ArrayList;

public class AppointmentsAdapter extends RecyclerView.Adapter<AppointmentsAdapter.AppointmentsAdapterRvVH> {

    ArrayList<DocAppointmentModel> docAppointmentModels;
    ArrayList<TextModel> doctorModels;
    int code;

    public AppointmentsAdapter(ArrayList<DocAppointmentModel> docAppointmentModels, ArrayList<TextModel> doctorModels, int code) {
        this.docAppointmentModels = docAppointmentModels;
        this.doctorModels = doctorModels;
        this.code = code;
    }

    @NonNull
    @Override
    public AppointmentsAdapterRvVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (code==0)
        return new AppointmentsAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.appointment_model_rv_layout,parent,false));

        else
            return new AppointmentsAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_refer_rv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentsAdapterRvVH holder, int position) {

        if (code==0)
        holder.populateDocAppointments(docAppointmentModels.get(position));

        else
            holder.populateDoctorName(doctorModels.get(position));
    }

    @Override
    public int getItemCount() {
        if (code==0)
        return docAppointmentModels.size();
        else
            return doctorModels.size();
    }

    public class AppointmentsAdapterRvVH extends RecyclerView.ViewHolder
    {
        TextView patientName,time;
        TextView doctorName;

        public AppointmentsAdapterRvVH(@NonNull View itemView) {
            super(itemView);

            if (code==0) {
                patientName = itemView.findViewById(R.id.name);
                time = itemView.findViewById(R.id.time);
            }

            else
                doctorName=itemView.findViewById(R.id.name);
        }

        public void populateDocAppointments(DocAppointmentModel docAppointmentModel) {

            patientName.setText(docAppointmentModel.getPatientName());
            time.setText(docAppointmentModel.getTime());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent appointmentInternal=new Intent(itemView.getContext(), DoctorAppointmentInternal.class);
                    itemView.getContext().startActivity(appointmentInternal);
                }
            });
        }

        public void populateDoctorName(TextModel doctorModel) {

            doctorName.setText(doctorModel.getText());
        }
    }
}
