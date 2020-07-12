package com.example.radyapp.StaffSide.FragmentsS;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.radyapp.R;
import com.example.radyapp.StaffSide.AdaptersS.PatientRVAdapter;
import com.example.radyapp.StaffSide.ModelsS.NoteModel;
import com.example.radyapp.StaffSide.ModelsS.PatientModel;

import java.util.ArrayList;


public class HelperSchedule extends Fragment {

  View view;
  RecyclerView patientRv;
  ArrayList<PatientModel> patientModels;
  PatientRVAdapter patientRVAdapter;
  ArrayList<NoteModel> noteModels;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_helper_schedule, container, false);

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
        patientRv=view.findViewById(R.id.helper_patientt_list_rv);
    }

    private void attachLayout() {
        patientRv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
    }

    private void initArrayList() {
        patientModels=new ArrayList<>(3);
    }

    private void addData() {
        for (int i=0;i<10;i++)
            patientModels.add(new PatientModel("Rishabh Singh","Dr. Boora"
                    ,"129","4:20",
                    "Bohot zyada beemar lagta hai Shayad na bach paaye"));
    }

    private void initAdapter() {

        patientRVAdapter=new PatientRVAdapter(0,patientModels,noteModels);
    }

    private void attachAdapter() {
        patientRv.setAdapter(patientRVAdapter);
    }

    private void refreshAdapter() {
        patientRVAdapter.notifyDataSetChanged();
    }
}