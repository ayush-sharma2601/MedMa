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

        doctorVisitsModels.add(new DoctorVisitsModel("Mukund Garg","4:30","Ward E-320",true));
        doctorVisitsModels.add(new DoctorVisitsModel("Harsh Nigam","5:30","Ward D-160",true));
        doctorVisitsModels.add(new DoctorVisitsModel("Rishabh Singh","6:30","Ward A-182",true));
        doctorVisitsModels.add(new DoctorVisitsModel("Ayush Sharma","7:30","Ward E-147",true));
        doctorVisitsModels.add(new DoctorVisitsModel("Shivansh Bansal","8:30","Ward A-388",true));
        doctorVisitsModels.add(new DoctorVisitsModel("Ankit Anand","9:30","Ward A-400",true));
        doctorVisitsModels.add(new DoctorVisitsModel("Akshat Pandit","9:50","Ward E-26",true));

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