package com.example.radyapp.PatientSide.AdaptersP;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.DoctorSide.ResponseModels.PrescriptionModel;
import com.example.radyapp.PatientSide.ModelsP.PatientNotesModel;
import com.example.radyapp.PatientSide.ModelsP.PatientPrescriptionModel;
import com.example.radyapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PatientTaskAdapter extends RecyclerView.Adapter<PatientTaskAdapter.PatientTaskAdapterRvVH> {

    int code;
    ArrayList<PatientPrescriptionModel> patientPrescriptionModels;
    ArrayList<PatientNotesModel> patientNotesModels;

    public PatientTaskAdapter(int code, ArrayList<PatientPrescriptionModel> patientPrescriptionModels, ArrayList<PatientNotesModel> patientNotesModels) {
        this.code = code;
        this.patientPrescriptionModels = patientPrescriptionModels;
        this.patientNotesModels = patientNotesModels;
    }

    @NonNull
    @Override
    public PatientTaskAdapterRvVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (code==0)
        {
            return new PatientTaskAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.patient_prescription_rv_layout,parent,false));
        }

        else
        {
            return new PatientTaskAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.doctornote_model_rv_layout,parent,false));

        }
    }

    @Override
    public void onBindViewHolder(@NonNull PatientTaskAdapterRvVH holder, int position) {

        if (code==0)
        {
            holder.populatePrescription(patientPrescriptionModels.get(position));
        }

        else
        {
            holder.populateNotes(patientNotesModels.get(position));
        }
    }

    @Override
    public int getItemCount() {

        if (code==0)
        {
            return patientPrescriptionModels.size();
        }

        else
        {
            return patientNotesModels.size();
        }

    }

    public  class PatientTaskAdapterRvVH extends RecyclerView.ViewHolder
    {
        TextView prescriptionMedName,prescriptionMedDosage,prescriptionComments,prescriptionDoctorName;
        TextView notesDoctorName,notesDoctorComments;

        public PatientTaskAdapterRvVH(@NonNull View itemView) {
            super(itemView);

            if (code==0)
            {
                prescriptionMedName=itemView.findViewById(R.id.patient_pres_name);
                prescriptionMedDosage=itemView.findViewById(R.id.patient_pres_dosage);
                prescriptionComments=itemView.findViewById(R.id.patient_pres_comment);
                prescriptionDoctorName=itemView.findViewById(R.id.pres_doctor);
            }

            else
            {
                notesDoctorName=itemView.findViewById(R.id.note_doctor_name);
                notesDoctorComments=itemView.findViewById(R.id.time);//check id here
            }
        }

        public void populateNotes(PatientNotesModel patientNotesModel) {
            notesDoctorName.setText(patientNotesModel.getDoctorName());
            notesDoctorComments.setText(patientNotesModel.getDoctorComments());

        }

        public void populatePrescription(PatientPrescriptionModel patientPrescriptionModel) {
            prescriptionDoctorName.setText(patientPrescriptionModel.getDoctorName());
            prescriptionMedName.setText(patientPrescriptionModel.getMedName());
            prescriptionMedDosage.setText(patientPrescriptionModel.getDosage());
            prescriptionComments.setText(patientPrescriptionModel.getComments());
        }
    }
}
