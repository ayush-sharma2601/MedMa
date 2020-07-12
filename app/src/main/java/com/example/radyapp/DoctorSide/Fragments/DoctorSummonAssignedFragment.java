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
import com.example.radyapp.R;

import java.util.ArrayList;

public class DoctorSummonAssignedFragment extends Fragment {

    View view;
    RecyclerView assignedRv;
    SummonAdapter assignedAdapter;
    ArrayList<AssignedModel> assignedModels;
    ArrayList<AvailableModel> availableModels;


    public DoctorSummonAssignedFragment() {
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
        view= inflater.inflate(R.layout.fragment_doctor_summon_assigned, container, false);

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
        assignedRv=view.findViewById(R.id.doctor_summon_assigned_rv);
    }

    private void attachLayout() {
        assignedRv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
    }

    private void initArrarList() {
        assignedModels=new ArrayList<>(3);
    }

    private void addData() {
        for (int i=0;i<10;i++)
            assignedModels.add(new AssignedModel("Paritosh Varshney","Head Female Nurse","Dr. Boora","1 hr"));
    }

    private void initAdapter() {
        assignedAdapter=new SummonAdapter(assignedModels,availableModels,1);
    }

    private void attachAdapter() {
        assignedRv.setAdapter(assignedAdapter);
    }

    private void refreshAdapter() {
        assignedAdapter.notifyDataSetChanged();
    }

}
