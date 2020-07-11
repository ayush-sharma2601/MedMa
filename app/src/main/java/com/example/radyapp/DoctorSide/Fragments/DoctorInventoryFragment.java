package com.example.radyapp.DoctorSide.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.DoctorSide.Adapters.AppointmentsAdapter;
import com.example.radyapp.DoctorSide.Adapters.InventoryAdapter;
import com.example.radyapp.DoctorSide.ResponseModels.DocAppointmentModel;
import com.example.radyapp.DoctorSide.ResponseModels.MedModel;
import com.example.radyapp.DoctorSide.ResponseModels.TextModel;
import com.example.radyapp.R;

import java.util.ArrayList;


public class DoctorInventoryFragment extends Fragment {
        View view;
    RecyclerView medRV;
    InventoryAdapter medADapter;
    ArrayList<MedModel> meds;


    public DoctorInventoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_doctor_inventory, container, false);
        attachId();

        attachLayout();

        initArrarList();

        addData();

        initAdapter();

        attachAdapter();

        refreshAdapter();

        return view;

    }
    private void attachAdapter() {

        medRV.setAdapter(medADapter);
    }

    private void addData() {
        for (int i=0;i<10;i++)
            meds.add(new MedModel("Zoratol",110));
    }

    private void refreshAdapter() {

        medADapter.notifyDataSetChanged();
    }

    private void attachLayout() {
        medRV.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
    }

    private void initArrarList() {

        meds=new ArrayList<>(3);
    }

    private void initAdapter() {
        medADapter =new InventoryAdapter(meds);
    }

    private void attachId() {
        medRV=view.findViewById(R.id.med_RV);
    }
}