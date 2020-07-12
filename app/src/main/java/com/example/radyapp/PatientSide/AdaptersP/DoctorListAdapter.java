package com.example.radyapp.PatientSide.AdaptersP;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.PatientSide.ModelsP.DoctorListModel;
import com.example.radyapp.R;

import java.util.ArrayList;

public class DoctorListAdapter extends RecyclerView.Adapter<DoctorListAdapter.DoctorListAdapterRvVH> {

    ArrayList<DoctorListModel> doctorListModels;

    public DoctorListAdapter(ArrayList<DoctorListModel> doctorListModels) {
        this.doctorListModels = doctorListModels;
    }

    @NonNull
    @Override
    public DoctorListAdapterRvVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DoctorListAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_list_rv_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorListAdapterRvVH holder, int position) {
        holder.populateDoctorList(doctorListModels.get(position));
    }

    @Override
    public int getItemCount() {
        return doctorListModels.size();
    }

    public class DoctorListAdapterRvVH extends RecyclerView.ViewHolder
    {
        TextView doctorName,doctorDept,doctorRoom;

        public DoctorListAdapterRvVH(@NonNull View itemView) {
            super(itemView);
            doctorName=itemView.findViewById(R.id.doctor_list_name);
            doctorDept=itemView.findViewById(R.id.doctor_list_dept);
            doctorRoom=itemView.findViewById(R.id.doctor_list_room);
        }

        public void populateDoctorList(DoctorListModel doctorListModel) {

            doctorName.setText(doctorListModel.getDoctorName());
            doctorDept.setText(doctorListModel.getDoctorDept());
            doctorRoom.setText(doctorListModel.getDoctorRoom());
        }
    }
}
