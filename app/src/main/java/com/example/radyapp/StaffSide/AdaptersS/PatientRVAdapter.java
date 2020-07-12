package com.example.radyapp.StaffSide.AdaptersS;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.R;
import com.example.radyapp.StaffSide.ModelsS.NoteModel;
import com.example.radyapp.StaffSide.ModelsS.PatientModel;

import java.util.ArrayList;



public class PatientRVAdapter extends RecyclerView.Adapter<PatientRVAdapter.PatientRVAdapterVH> {

    int code;
    ArrayList<PatientModel> patientModels;
    ArrayList<NoteModel> noteModels;

    public  PatientRVAdapter(int code, ArrayList<PatientModel> patientModels, ArrayList<NoteModel> noteModels) {
        this.code = code;
        this.patientModels = patientModels;
        this.noteModels = noteModels;

    }

//    private void loadTasks(){
//        RealmQuery<NoteModel> query = realm.where(NoteModel.class);
//        RealmResults<NoteModel> results = query.findAll();
//        noteModels.addAll(results);
//        notifyDataSetChanged();
//
//    }
//    public void addTask(NoteModel task){
//        noteModels.add(task);
//        realm.beginTransaction();
//        realm.insertOrUpdate(task);
//        realm.commitTransaction();
//        notifyDataSetChanged();
//
//    }

    @NonNull
    @Override
    public PatientRVAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (code==0)
        {
            return new PatientRVAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.helper_visit_model_rv_layout,parent,false));
        }

        else
        {
            return new PatientRVAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.helper_note_layout,parent,false));

        }
    }

    @Override
    public void onBindViewHolder(@NonNull PatientRVAdapterVH holder, int position) {

        if (code==0)
        {
            holder.populatePatients(patientModels.get(position));

        }
        else
        {
            holder.populateNotes(noteModels.get(position));
        }

    }

    @Override
    public int getItemCount() {
        if (code==0)
        {
            return patientModels.size();
        }
        else
        {
            return noteModels.size();
        }

    }

    public class PatientRVAdapterVH extends RecyclerView.ViewHolder
    {
        TextView patientName,patientRoom,patientTime;
        TextView helperNotes;
        CheckBox checkBox;

        public PatientRVAdapterVH(@NonNull View itemView) {
            super(itemView);

            if (code==0) {
                patientName = itemView.findViewById(R.id.name);
                patientRoom = itemView.findViewById(R.id.room);
                patientTime = itemView.findViewById(R.id.time);
            }

            else
            {
                helperNotes=itemView.findViewById(R.id.helper_note);
                checkBox=itemView.findViewById(R.id.helper_task_check);
            }
        }

        public void populatePatients(PatientModel patientModel) {

            patientName.setText(patientModel.getPatientName());
            patientRoom.setText(patientModel.getPatientRoom());
            patientTime.setText(patientModel.getPatientTime());
        }

        public void populateNotes(NoteModel noteModel) {
            helperNotes.setText(noteModel.getNote());
            checkBox.setChecked(noteModel.isDone());
        }
    }
}
