package com.example.radyapp.DoctorSide.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.radyapp.DoctorSide.Adapters.NoticesAdapter;
import com.example.radyapp.DoctorSide.Adapters.PrescriptionAdapter;
import com.example.radyapp.DoctorSide.ResponseModels.NoticeModel;
import com.example.radyapp.DoctorSide.ResponseModels.PrescriptionModel;
import com.example.radyapp.R;

import java.util.ArrayList;

public class DoctorAppointmentInternal extends AppCompatActivity {

    TextView patientName,lastVisited,gender,age,uhid,refer,done,showMedicalHistoryButton;
    EditText comments;
    ImageView backButton,addMedBtn;
    RecyclerView prescribedMedicine;
    ArrayList<PrescriptionModel> prescriptions;
    PrescriptionAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_appointment_internal);

        attachID();

        attachLayout();

        initArrarList();

        addData();

        initAdapter();

        attachAdapter();

        refreshAdapter();

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

        addMedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DoctorAppointmentInternal.this,PrescriptionActivity.class);
                startActivity(intent1);
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
        addMedBtn = findViewById(R.id.add_medicine_btn);
    }

    private void attachAdapter() {

        prescribedMedicine.setAdapter(adapter);
    }

    private void addData() {
        prescriptions.add(new PrescriptionModel("Azithrol 200 mg","2 times a day","after lunch, after dinner"));
        prescriptions.add(new PrescriptionModel("Glycomet GP 850 mg","3 times a day","after each meal"));
        prescriptions.add(new PrescriptionModel("Dexilant 500 mg","Once","Before going to bed"));

    }

    private void refreshAdapter() {

        adapter.notifyDataSetChanged();
    }

    private void attachLayout() {
        prescribedMedicine.setLayoutManager(new LinearLayoutManager(DoctorAppointmentInternal.this,LinearLayoutManager.VERTICAL,false));
    }

    private void initArrarList() {

        prescriptions=new ArrayList<>(3);
    }

    private void initAdapter() {
        adapter =new PrescriptionAdapter(prescriptions);
    }

}