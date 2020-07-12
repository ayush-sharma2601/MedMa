package com.example.radyapp.PatientSide.ActivitiesP;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.radyapp.PatientSide.AdaptersP.DoctorListAdapter;
import com.example.radyapp.PatientSide.ModelsP.DoctorListModel;
import com.example.radyapp.R;

import java.util.ArrayList;

public class PatientDoctors extends AppCompatActivity {

    RecyclerView doctorRv;
    DoctorListAdapter doctorListAdapter;
    ArrayList<DoctorListModel> doctorListModels;
    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_doctors);

        attachId();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        attachLayout();

        initArrarList();

        addData();

        initAdapter();

        attachAdapter();

        refreshAdapter();
    }

    private void attachId() {
        doctorRv=findViewById(R.id.doctor_list_rv);
        backButton=findViewById(R.id.doctor_list_back_btn);
    }

    private void attachLayout() {
        doctorRv.setLayoutManager(new LinearLayoutManager(PatientDoctors.this,LinearLayoutManager.VERTICAL,false));
    }

    private void initArrarList() {
        doctorListModels=new ArrayList<>(3);
    }

    private void addData() {
            doctorListModels.add(new DoctorListModel("Dr. Baggha","ENT","Ward E-210"));
        doctorListModels.add(new DoctorListModel("Dr. Singh","HOD,Dental","Ward F-21"));
        doctorListModels.add(new DoctorListModel("Dr. Kumar","Gastro","Ward D-68"));
        doctorListModels.add(new DoctorListModel("Dr. Anil","Sub,gastro","Ward E-215"));
        doctorListModels.add(new DoctorListModel("Dr. Makkhani","sub,ENT","Ward E-220"));
        doctorListModels.add(new DoctorListModel("Dr. Batra","Neuro","Ward G-55"));
        doctorListModels.add(new DoctorListModel("Dr. Aggrawal","Neuro","Ward E-51"));
        doctorListModels.add(new DoctorListModel("Dr. Sharma","ENT","Ward g-35"));
        doctorListModels.add(new DoctorListModel("Dr. Gajendra","Dental","Ward A-62"));
        doctorListModels.add(new DoctorListModel("Dr. Garg","ENT","Ward A-245"));

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