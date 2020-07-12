package com.example.radyapp.DoctorSide.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.DoctorSide.Adapters.AppointmentsAdapter;
import com.example.radyapp.DoctorSide.ResponseModels.DocAppointmentModel;
import com.example.radyapp.DoctorSide.ResponseModels.TextModel;
import com.example.radyapp.R;

import java.util.ArrayList;


public class DoctorAppointmentFragment extends Fragment {
    View view;
    RecyclerView appointmentsRv;
    AppointmentsAdapter appointmentsAdapter;
    ArrayList<DocAppointmentModel> docAppointmentModels;
    ArrayList<TextModel> doctorModels;

    public DoctorAppointmentFragment() {
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
        view= inflater.inflate(R.layout.fragment_doctor_appointments, container, false);

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

        appointmentsRv.setAdapter(appointmentsAdapter);
    }

    private void addData() {
        docAppointmentModels.add(new DocAppointmentModel("Rishabh Singh","11:15 am"));
        docAppointmentModels.add(new DocAppointmentModel("Ayush Sharma","11:40 am"));
        docAppointmentModels.add(new DocAppointmentModel("Paritosh Varshney","12:000 pm"));
        docAppointmentModels.add(new DocAppointmentModel("Divyam Aggarwal","12:20 pm"));
        docAppointmentModels.add(new DocAppointmentModel("Yatik Budhrani","12:40 pm"));
        docAppointmentModels.add(new DocAppointmentModel("Aditya Sharma","1:00 pm"));
        docAppointmentModels.add(new DocAppointmentModel("Utkarsh Kere","1:30 pm"));
        docAppointmentModels.add(new DocAppointmentModel("Shivansh Bansal","1:50 pm"));
        docAppointmentModels.add(new DocAppointmentModel("Arushi Tiwari","2:30 pm"));
        docAppointmentModels.add(new DocAppointmentModel("Sachit Pant","2:50 pm"));

    }

    private void refreshAdapter() {

        appointmentsAdapter.notifyDataSetChanged();
    }

    private void attachLayout() {
        appointmentsRv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
    }

    private void initArrarList() {

        docAppointmentModels=new ArrayList<>(3);
    }

    private void initAdapter() {
        appointmentsAdapter =new AppointmentsAdapter(docAppointmentModels,doctorModels,0);
    }

    private void attachId() {
        appointmentsRv=view.findViewById(R.id.doctor_appointments_rv1);
    }
}