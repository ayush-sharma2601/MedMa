package com.example.radyapp.PatientSide.ActivitiesP;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.radyapp.PatientSide.AdaptersP.DoctorListAdapter;
import com.example.radyapp.PatientSide.ModelsP.DoctorListModel;
import com.example.radyapp.R;

import java.util.ArrayList;

public class PatientDoctors extends AppCompatActivity {

    RecyclerView doctorRv;
    DoctorListAdapter doctorListAdapter;
    ArrayList<DoctorListModel> doctorListModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_doctors);

        attachId();

        attachLayout();

        initArrarList();

        addData();

        initAdapter();

        attachAdapter();

        refreshAdapter();
    }

    private void attachId() {
        doctorRv=findViewById(R.id.doctor_list_rv);
    }

    private void attachLayout() {
        doctorRv.setLayoutManager(new LinearLayoutManager(PatientDoctors.this,LinearLayoutManager.VERTICAL,false));
    }

    private void initArrarList() {
        doctorListModels=new ArrayList<>(3);
    }

    private void addData() {
        for (int i=0;i<10;i++)
            doctorListModels.add(new DoctorListModel("Dr. Boora","ENT","69"));
    }

    private void initAdapter() {
        doctorListAdapter=new DoctorListAdapter(doctorListModels);
    }

    private void attachAdapter() {
        doctorRv.setAdapter(doctorListAdapter);
    }

    private void refreshAdapter() {
        doctorListAdapter.notifyDataSetChanged();
    }
}