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
import com.example.radyapp.PatientSide.AdaptersP.PatientTaskAdapter;
import com.example.radyapp.PatientSide.ModelsP.PatientApppointmentModel;
import com.example.radyapp.PatientSide.ModelsP.PatientNotesModel;
import com.example.radyapp.PatientSide.ModelsP.PatientPrescriptionModel;
import com.example.radyapp.R;

import java.util.ArrayList;

public class PatientRoutineFragment extends Fragment {

    View view;
    RecyclerView prescriptionRv;
    RecyclerView taskRv;
    PatientTaskAdapter patientTaskAdapter,prescriptionAdapter;
    ArrayList<PatientPrescriptionModel> patientPrescriptionModels;
    ArrayList<PatientNotesModel> patientNotesModels;

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
        taskRv.setAdapter(patientTaskAdapter);
        prescriptionRv.setAdapter(prescriptionAdapter);
    }

    private void addData() {
            patientNotesModels.add(new PatientNotesModel("Dr. Singh","Exercise daily for 30 mins"));
            patientPrescriptionModels.add(new PatientPrescriptionModel("Dolomide 500 mg","3 time a day for 5 days","after each meal","Dr. Batra"));
        patientPrescriptionModels.add(new PatientPrescriptionModel("Azithrol 500 mg","2 time a day for 3 days","after each meal","Dr. Singh"));
        patientPrescriptionModels.add(new PatientPrescriptionModel("Disprin 50 mg","3 time a day for 5 days","after each meal","Dr. Kumar"));



    }

    private void refreshAdapter() {
        patientTaskAdapter.notifyDataSetChanged();
        prescriptionAdapter.notifyDataSetChanged();
    }

    private void attachLayout() {
        taskRv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
        prescriptionRv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
    }

    private void initArrarList() {
        patientPrescriptionModels=new ArrayList<>(3);
        patientNotesModels=new ArrayList<>(3);
    }

    private void initAdapter() {
        patientTaskAdapter=new PatientTaskAdapter(1,patientPrescriptionModels,patientNotesModels);
        prescriptionAdapter=new PatientTaskAdapter(0,patientPrescriptionModels,patientNotesModels);
    }

    private void attachId() {
        taskRv=view.findViewById(R.id.routine_notes_rv);
        prescriptionRv=view.findViewById(R.id.routine_prescription_rv);
    }
}
