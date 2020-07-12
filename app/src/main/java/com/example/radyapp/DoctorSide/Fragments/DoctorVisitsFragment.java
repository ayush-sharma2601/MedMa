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


public class DoctorVisitsFragment extends Fragment {
        View view;
        RecyclerView doctorVisitsRv;
        ArrayList<DoctorVisitsModel> doctorVisitsModels;
        ArrayList<DoctorReferencesModel> doctorReferencesModels;
        VisitsAdapter visitsAdapter;

    public DoctorVisitsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_doctor_visits, container, false);

        attachId();

        attachLayout();

        initArrarList();

        addData();

        initAdapter();

        attachAdapter();

        refreshAdapter();

        return  view;

    }

    private void attachId() {
        doctorVisitsRv=view.findViewById(R.id.doctor_visits_rv);
    }

    private void attachLayout() {
        doctorVisitsRv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
    }

    private void initArrarList() {
        doctorVisitsModels=new ArrayList<>(3);
    }

    private void addData() {
        for (int i=0;i<10;i++)
            doctorVisitsModels.add(new DoctorVisitsModel("Rishabh Singh","4:30","330",true));
    }

    private void initAdapter() {
        visitsAdapter=new VisitsAdapter(0,doctorVisitsModels,doctorReferencesModels);
    }

    private void attachAdapter() {
        doctorVisitsRv.setAdapter(visitsAdapter);
    }

    private void refreshAdapter() {
        visitsAdapter.notifyDataSetChanged();
    }
}