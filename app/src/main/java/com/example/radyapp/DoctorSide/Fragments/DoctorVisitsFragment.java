package com.example.radyapp.DoctorSide.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.DoctorSide.ResponseModels.DoctorVisitsModel;
import com.example.radyapp.R;

import java.util.ArrayList;


public class DoctorVisitsFragment extends Fragment {
        View view;
        RecyclerView doctorVisitsRv;
        ArrayList<DoctorVisitsModel> doctorVisitsModels;


    public DoctorVisitsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_doctor_visits, container, false);
        return  view;

    }
}