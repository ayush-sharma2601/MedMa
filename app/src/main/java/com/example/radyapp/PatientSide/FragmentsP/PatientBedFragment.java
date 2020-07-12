package com.example.radyapp.PatientSide.FragmentsP;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.R;

public class PatientBedFragment extends Fragment {

    View view;
    RecyclerView bedRv;


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
    }

    private void attachLayout() {
    }

    private void initArrayList() {
    }

    private void addData() {
    }

    private void initAdapter() {
    }

    private void attachAdapter() {
    }

    private void refreshAdapter() {
    }
}
