package com.example.radyapp.DoctorSide.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.radyapp.DoctorSide.Adapters.InventoryAdapter;
import com.example.radyapp.DoctorSide.ResponseModels.MedModel;
import com.example.radyapp.DoctorSide.ResponseModels.PrescriptionModel;
import com.example.radyapp.R;

import java.util.ArrayList;

public class PrescriptionActivity extends AppCompatActivity {
    RecyclerView medRV;
    InventoryAdapter medADapter;
    ArrayList<MedModel> meds;
    ArrayList<PrescriptionModel> prescriptionModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);
        attachId();

        attachLayout();

        initArrarList();

        addData();

        initAdapter();

        attachAdapter();

        refreshAdapter();
    }

    private void attachAdapter() {

        medRV.setAdapter(medADapter);
    }

    private void addData() {
        meds.add(new MedModel("Zoratol",110));
        meds.add(new MedModel("Crocin",500));
        meds.add(new MedModel("Disprin",250));
        meds.add(new MedModel("Asithrol",250));
        meds.add(new MedModel("Paracetamol",500));
        meds.add(new MedModel("Nimusalide",300));
        meds.add(new MedModel("Glycomet GP",850));
        meds.add(new MedModel("Trinicalm",250));
        meds.add(new MedModel("Clonotril",500));
        meds.add(new MedModel("Lipitor",250));
        meds.add(new MedModel("Demerol",500));
        meds.add(new MedModel("Dexilant",250));
    }

    private void refreshAdapter() {

        medADapter.notifyDataSetChanged();
    }

    private void attachLayout() {
        medRV.setLayoutManager(new LinearLayoutManager(PrescriptionActivity.this,LinearLayoutManager.VERTICAL,false));
    }

    private void initArrarList() {

        meds=new ArrayList<>(3);
    }

    private void initAdapter() {
        medADapter =new InventoryAdapter(meds,1);
    }

    private void attachId() {
        medRV=findViewById(R.id.prescription_rv);
    }
}