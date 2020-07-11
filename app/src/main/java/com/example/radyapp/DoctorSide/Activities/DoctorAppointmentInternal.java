package com.example.radyapp.DoctorSide.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.radyapp.R;

public class DoctorAppointmentInternal extends AppCompatActivity {

    TextView patientName,lastVisited,gender,age,uhid,refer,done,showMedicalHistoryButton;
    EditText comments;
    ImageView backButton;
    RecyclerView prescribedMedicine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_appointment_internal);

        attachID();

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        refer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent referIntent=new Intent(DoctorAppointmentInternal.this,DoctorRefer.class);
                startActivity(referIntent);
            }
        });

    }

    private void attachID() {

        patientName=findViewById(R.id.name);
        lastVisited=findViewById(R.id.lad);
        gender=findViewById(R.id.gender);
        age=findViewById(R.id.agetv);
        uhid=findViewById(R.id.uhid);
        comments=findViewById(R.id.appointment_comments);
        done=findViewById(R.id.appointment_done_btn);
        refer=findViewById(R.id.appointment_refer_btn);
        backButton=findViewById(R.id.doctor_appointment_back_btn);
        showMedicalHistoryButton=findViewById(R.id.medical_record_btn);
        prescribedMedicine=findViewById(R.id.medicine_prescribed_rv);
    }

}