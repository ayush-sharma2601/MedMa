package com.example.radyapp.PatientSide.FragmentsP;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.PatientSide.AdaptersP.PatientBedAdapter;
import com.example.radyapp.PatientSide.ModelsP.PatientBedModel;
import com.example.radyapp.R;

import java.util.ArrayList;

public class PatientBedFragment extends Fragment {

    View view;
    RecyclerView bedRv;
    PatientBedAdapter patientBedAdapter;
    ArrayList<PatientBedModel> patientBedModels;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_patient_bed, container, false);

        attachId();

        attachLayout();

        initArrayList();

        addData();

        initAdapter();

        attachAdapter();

        refreshAdapter();

        return view;
    }

    private void attachId() {
        bedRv=view.findViewById(R.id.patient_bed_rv);
    }

    private void attachLayout() {
        bedRv.setLayoutManager(new LinearLayoutManager(view.getContext(),
                LinearLayoutManager.VERTICAL,false));
    }

    private void initArrayList() {
        patientBedModels=new ArrayList<>(3);
    }

    private void addData() {
        for (int i=0;i<10;i++)
            patientBedModels.add(new PatientBedModel("Private","300"
                    ,"80","Karen","9318458933"));
    }

    private void initAdapter() {

        patientBedAdapter=new PatientBedAdapter(patientBedModels);
    }

    private void attachAdapter() {
        bedRv.setAdapter(patientBedAdapter);
    }

    private void refreshAdapter() {
        patientBedAdapter.notifyDataSetChanged();
    }
}
