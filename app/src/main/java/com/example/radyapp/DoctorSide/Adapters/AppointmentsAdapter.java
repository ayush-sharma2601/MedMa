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
import com.example.radyapp.R;

import java.util.ArrayList;

public class AppointmentsAdapter extends RecyclerView.Adapter<AppointmentsAdapter.AppointmentsAdapterRvVH> {

    ArrayList<DocAppointmentModel> docAppointmentModels;


    public AppointmentsAdapter(ArrayList<DocAppointmentModel> docAppointmentModels) {
        this.docAppointmentModels = docAppointmentModels;
    }

    @NonNull
    @Override
    public AppointmentsAdapterRvVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new AppointmentsAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.appointment_model_rv_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentsAdapterRvVH holder, int position) {

        holder.populateDocAppointments(docAppointmentModels.get(position));
    }

    @Override
    public int getItemCount() {
        return docAppointmentModels.size();
    }

    public class AppointmentsAdapterRvVH extends RecyclerView.ViewHolder
    {
        TextView patientName,time;

        public AppointmentsAdapterRvVH(@NonNull View itemView) {
            super(itemView);

            patientName =itemView.findViewById(R.id.name);
            time=itemView.findViewById(R.id.time);
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
    }
}
