package com.example.radyapp.StaffSide.FragmentsS;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.radyapp.DoctorSide.Adapters.InventoryAdapter;
import com.example.radyapp.DoctorSide.ResponseModels.MedModel;
import com.example.radyapp.DoctorSide.ResponseModels.NoticeModel;
import com.example.radyapp.R;
import com.example.radyapp.StaffSide.AdaptersS.PatientRVAdapter;
import com.example.radyapp.StaffSide.ModelsS.NoteModel;
import com.example.radyapp.StaffSide.ModelsS.PatientModel;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


public class HelperNotes extends Fragment {

    View view;

    TextView addButon,note;
    EditText taskET;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_helper_notes, container, false);
        attachId();

        SharedPreferences sharedPreferences = view.getContext().getSharedPreferences("MySharedPref",
                MODE_PRIVATE);
        final SharedPreferences.Editor myEdit
                = sharedPreferences.edit();

//        note.append(sharedPreferences.getString("name",null));

        addButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEdit.putString(
                        "name",
                        taskET.getText().toString());
            }
        });

        return view;
    }

//    private void addData() {
//        for (int i=0;i<10;i++)
//            notes.add(new NoteModel("First Note",false));
//    }
//
//    private void refreshAdapter() {
//
//        noteadapter.notifyDataSetChanged();
//    }
//
//    private void attachLayout() {
//        notesRV.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
//    }
//
//    private void initArrarList() {
//
//        notes=new ArrayList<>(3);
//    }
//
//    private void initAdapter() {
//        noteadapter =new PatientRVAdapter(1,patientModels,notes);
//    }
//
    private void attachId() {
        addButon = view.findViewById(R.id.add_notes);
        taskET = view.findViewById(R.id.task);
        note = view.findViewById(R.id.note);
    }
//
//    private void attachAdapter() {
//        notesRV.setAdapter(noteadapter);
//    }
}