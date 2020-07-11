package com.example.radyapp.DoctorSide.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.DoctorSide.Adapters.SummonAdapter;
import com.example.radyapp.DoctorSide.ResponseModels.DocAppointmentModel;
import com.example.radyapp.DoctorSide.ResponseModels.TextModel;
import com.example.radyapp.R;

import java.util.ArrayList;

public class DoctorSummonAvailableFragment extends Fragment {

    View view;
    RecyclerView availableRv;
    SummonAdapter availableAdapter;
    ArrayList<DocAppointmentModel> docAppointmentModels;
    ArrayList<TextModel> doctorModels;

    public DoctorSummonAvailableFragment() {
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
        view= inflater.inflate(R.layout.fragment_doctor_summon_available, container, false);

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
        availableRv=view.findViewById(R.id.doctor_summon_available_rv);
    }

    private void attachLayout() {
    }

    private void initArrarList() {
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
