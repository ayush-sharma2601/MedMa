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

            patientModels.add(new PatientModel("Rishabh Singh","Dr. Baggha"
                    ,"Ward E-129","12:50 AM",
                    "needs more dosage of IV drops"));
        patientModels.add(new PatientModel("Rakehs Mittal","Dr. Baggha"
                ,"Ward E-130","1:50 PM",
                "head injury; needs 2 week rest"));
        patientModels.add(new PatientModel("Suresh Matt","Dr. Batra"
                ,"Ward E-139","3:10 PM",
                "aenestheshia injection"));
        patientModels.add(new PatientModel("Paritosh Varshney","Dr. Dutt"
                ,"Ward E-159","4:50 PM",
                "needs more dosage of IV drops"));
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