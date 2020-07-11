package com.example.radyapp.DoctorSide.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.radyapp.DoctorSide.Adapters.InventoryAdapter;
import com.example.radyapp.DoctorSide.Adapters.NoticesAdapter;
import com.example.radyapp.DoctorSide.ResponseModels.MedModel;
import com.example.radyapp.DoctorSide.ResponseModels.NoticeModel;
import com.example.radyapp.R;

import java.util.ArrayList;

public class DoctorNotices extends AppCompatActivity {
    RecyclerView noticeRV;
    NoticesAdapter noticeAdappter;
    ArrayList<NoticeModel> notices;
    ImageView backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_notices);

        attachId();

        attachLayout();

        initArrarList();

        addData();

        initAdapter();

        attachAdapter();

        refreshAdapter();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void attachAdapter() {

        noticeRV.setAdapter(noticeAdappter);
    }

    private void addData() {
        for (int i=0;i<10;i++)
            notices.add(new NoticeModel("Conference on Human Mind and Mental Disability by Dr Shetty","Admin","21 Jul 2020","The content of notice.."));
    }

    private void refreshAdapter() {

        noticeAdappter.notifyDataSetChanged();
    }

    private void attachLayout() {
        noticeRV.setLayoutManager(new LinearLayoutManager(DoctorNotices.this,LinearLayoutManager.VERTICAL,false));
    }

    private void initArrarList() {

        notices=new ArrayList<>(3);
    }

    private void initAdapter() {
        noticeAdappter =new NoticesAdapter(notices);
    }

    private void attachId() {
        noticeRV = findViewById(R.id.doctor_notices_rv);
        backBtn = findViewById(R.id.doctor_notices_back_btn);
    }
}