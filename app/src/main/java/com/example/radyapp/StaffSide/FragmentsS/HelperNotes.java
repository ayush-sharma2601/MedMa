package com.example.radyapp.StaffSide.FragmentsS;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.radyapp.DoctorSide.Adapters.InventoryAdapter;
import com.example.radyapp.DoctorSide.ResponseModels.MedModel;
import com.example.radyapp.DoctorSide.ResponseModels.NoticeModel;
import com.example.radyapp.R;
import com.example.radyapp.StaffSide.AdaptersS.PatientRVAdapter;
import com.example.radyapp.StaffSide.ModelsS.NoteModel;

import java.util.ArrayList;


public class HelperNotes extends Fragment {

   View view;
    RecyclerView notesRV;
    PatientRVAdapter noteadapter;
    ArrayList<NoteModel> notes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_helper_notes, container, false);
        attachId();

        attachLayout();

        initArrarList();

        addData();

        initAdapter();

        attachAdapter();

        refreshAdapter();
        return view;
    }

    private void addData() {
        for (int i=0;i<10;i++)
            notes.add(new NoteModel("First Note",false));
    }

    private void refreshAdapter() {

        noteadapter.notifyDataSetChanged();
    }

    private void attachLayout() {
        notesRV.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
    }

    private void initArrarList() {

        notes=new ArrayList<>(3);
    }

    private void initAdapter() {
        noteadapter =new PatientRVAdapter(notes,0);
    }

    private void attachId() {
        notesRV=view.findViewById(R.id.helper_notes_rv);
    }
    private void attachAdapter() {

        notesRV.setAdapter(noteadapter);
    }
}