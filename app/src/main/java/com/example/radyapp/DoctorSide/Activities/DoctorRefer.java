package com.example.radyapp.DoctorSide.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.radyapp.DoctorSide.Adapters.AppointmentsAdapter;
import com.example.radyapp.DoctorSide.ResponseModels.DocAppointmentModel;
import com.example.radyapp.DoctorSide.ResponseModels.TextModel;
import com.example.radyapp.R;

import java.util.ArrayList;

public class DoctorRefer extends AppCompatActivity {

    RecyclerView doctorReferRv;
    ArrayList<TextModel> doctorModels;
    AppointmentsAdapter doctorAdapter;
    ArrayList<DocAppointmentModel> docAppointmentModels;
    ImageView backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_refer);

        attachId();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        initArrarList();

        attachLayout();

        addData();

        initAdapter();

        attachAdapter();

        refreshAdapter();

    }

    private void initArrarList() {
        doctorModels=new ArrayList<>(3);
    }

    private void addData() {
        doctorModels.add(new TextModel("Dr. Vishal Boora"));
        doctorModels.add(new TextModel("Dr. Santosh Yadav"));
        doctorModels.add(new TextModel("Dr. Masira Siddhiqi"));
        doctorModels.add(new TextModel("Dr. Shravi Mishra"));
        doctorModels.add(new TextModel("Dr. Virendra Singh"));
        doctorModels.add(new TextModel("Dr. Suraj Singh"));
        doctorModels.add(new TextModel("Dr. Yathartha Swaroop"));
        doctorModels.add(new TextModel("Dr. Paurush Punyasheel"));
        doctorModels.add(new TextModel("Dr. Himanshu Singh"));
        doctorModels.add(new TextModel("Dr. Aniket Sinha"));
    }

    private void initAdapter() {
        doctorAdapter=new AppointmentsAdapter(docAppointmentModels,doctorModels,1);
    }

    private void attachAdapter() {
        doctorReferRv.setAdapter(doctorAdapter);
    }

    private void refreshAdapter() {

        doctorAdapter.notifyDataSetChanged();
    }

    private void attachLayout() {
        doctorReferRv.setLayoutManager(new LinearLayoutManager(DoctorRefer.this,LinearLayoutManager.VERTICAL,false));
    }

    private void attachId() {
        backButton=findViewById(R.id.back_button);
        doctorReferRv=findViewById(R.id.doctor_refer_list_rv);
    }
}