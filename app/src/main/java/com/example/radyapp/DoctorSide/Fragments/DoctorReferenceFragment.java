package com.example.radyapp.DoctorSide.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.DoctorSide.Adapters.VisitsAdapter;
import com.example.radyapp.DoctorSide.ResponseModels.DoctorReferencesModel;
import com.example.radyapp.DoctorSide.ResponseModels.DoctorVisitsModel;
import com.example.radyapp.R;

import java.util.ArrayList;


public class DoctorReferenceFragment extends Fragment {
    View view;
    RecyclerView doctorReferencesRv;
    ArrayList<DoctorVisitsModel> doctorVisitsModels;
    ArrayList<DoctorReferencesModel> doctorReferencesModels;
    VisitsAdapter referAdapter;

    public DoctorReferenceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_doctor_references, container, false);

        attachId();

        attachLayout();

        initArrarList();

        addData();

        initAdapter();

        attachAdapter();

        refreshAdapter();

        return view;

    }

    private void attachId() {
        doctorReferencesRv=view.findViewById(R.id.doctor_appointments_rv);
    }

    private void attachLayout() {
        doctorReferencesRv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
    }

    private void initArrarList() {
        doctorReferencesModels=new ArrayList<>(3);
    }

    private void addData() {
        for (int i=0;i<10;i++)
            doctorReferencesModels.add(new DoctorReferencesModel("Rishabh Singh","5:30","Dr. Ayush Sharma",true,"Dr. DBM"));
    }

    private void initAdapter() {
        referAdapter=new VisitsAdapter(1,doctorVisitsModels,doctorReferencesModels);
    }

    private void attachAdapter() {
        doctorReferencesRv.setAdapter(referAdapter);
    }

    private void refreshAdapter() {
        referAdapter.notifyDataSetChanged();
    }
}