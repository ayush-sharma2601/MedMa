package com.example.radyapp.DoctorSide.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.DoctorSide.ResponseModels.DoctorReferencesModel;
import com.example.radyapp.DoctorSide.ResponseModels.DoctorVisitsModel;
import com.example.radyapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class VisitsAdapter extends RecyclerView.Adapter<VisitsAdapter.VisitsAdapterRvVH> {

    int code;
    ArrayList<DoctorVisitsModel> doctorVisitsModels;
    ArrayList<DoctorReferencesModel> doctorReferencesModels;

    public VisitsAdapter(int code, ArrayList<DoctorVisitsModel> doctorVisitsModels, ArrayList<DoctorReferencesModel> doctorReferencesModels) {
        this.code = code;
        this.doctorVisitsModels = doctorVisitsModels;
        this.doctorReferencesModels = doctorReferencesModels;
    }

    @NonNull
    @Override
    public VisitsAdapterRvVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (code==0)
        return new VisitsAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.visits_model_rv_layout,parent,false));

        else
            return new VisitsAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.reference_model_rv_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VisitsAdapterRvVH holder, int position) {

        if (code==0)
        {
            holder.populateDoctorVisits(doctorVisitsModels.get(position));
        }

        else
        {
            holder.populateDoctorReferences(doctorReferencesModels.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if (code==0)
        return doctorVisitsModels.size();
        else
            return doctorReferencesModels.size();
    }

    public class VisitsAdapterRvVH extends RecyclerView.ViewHolder
    {
        TextView visitingPatientName,visitingPatientTime,visitingPatientRoom;


        public VisitsAdapterRvVH(@NonNull View itemView) {
            super(itemView);
        }

        public void populateDoctorReferences(DoctorReferencesModel doctorReferencesModel) {
        }

        public void populateDoctorVisits(DoctorVisitsModel doctorVisitsModel) {
        }
    }
}
