package com.example.radyapp.PatientSide.FragmentsP;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.DoctorSide.ResponseModels.PrescriptionModel;
import com.example.radyapp.PatientSide.AdaptersP.PatientAppointmentAdapter;
import com.example.radyapp.PatientSide.ModelsP.PatientApppointmentModel;
import com.example.radyapp.R;

import java.util.ArrayList;

public class PatientRoutineFragment extends Fragment {

    View view;


    public PatientRoutineFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_patient_routine, container, false);

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


    }

    private void addData() {
//        for (int i=0;i<10;i++)
//
    }

    private void refreshAdapter() {


    }

    private void attachLayout() {
    }

    private void initArrarList() {

    }

    private void initAdapter() {
    }

    private void attachId() {
    }
}
