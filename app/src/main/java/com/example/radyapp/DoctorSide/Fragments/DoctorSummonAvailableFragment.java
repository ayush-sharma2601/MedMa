package com.example.radyapp.DoctorSide.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.DoctorSide.Adapters.SummonAdapter;
import com.example.radyapp.DoctorSide.ResponseModels.AssignedModel;
import com.example.radyapp.DoctorSide.ResponseModels.AvailableModel;
import com.example.radyapp.DoctorSide.ResponseModels.DocAppointmentModel;
import com.example.radyapp.DoctorSide.ResponseModels.TextModel;
import com.example.radyapp.R;

import java.util.ArrayList;

public class DoctorSummonAvailableFragment extends Fragment {

    View view;
    RecyclerView availableRv;
    SummonAdapter availableAdapter;
    ArrayList<AssignedModel> assignedModels;
    ArrayList<AvailableModel> availableModels;

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
        availableRv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
    }

    private void initArrarList() {
        availableModels=new ArrayList<>(3);
    }

    private void addData() {

        availableModels.add(new AvailableModel("Paritosh Varshney","Head Male Nurse"));
        availableModels.add(new AvailableModel("Masira Siddhiqi","Head Female Nurse"));
        availableModels.add(new AvailableModel("Shreya Sharma","Nurse"));
        availableModels.add(new AvailableModel("Shranay Swami","Wardboy"));
        availableModels.add(new AvailableModel("Shishir Upadhyay","Nurse"));
        availableModels.add(new AvailableModel("Dhananjay Shukla","Nurse"));
        availableModels.add(new AvailableModel("Abhinav Verma","Wardboy"));
        availableModels.add(new AvailableModel("Ashish Sharma","Wardboy"));
    }

    private void initAdapter() {
        availableAdapter=new SummonAdapter(assignedModels,availableModels,0);
    }

    private void attachAdapter() {
        availableRv.setAdapter(availableAdapter);
    }

    private void refreshAdapter() {
        availableAdapter.notifyDataSetChanged();
    }

}
