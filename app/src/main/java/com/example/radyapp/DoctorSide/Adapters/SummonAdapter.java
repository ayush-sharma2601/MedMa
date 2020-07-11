package com.example.radyapp.DoctorSide.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.DoctorSide.ResponseModels.AssignedModel;
import com.example.radyapp.DoctorSide.ResponseModels.AvailableModel;
import com.example.radyapp.R;

import java.util.ArrayList;

public class SummonAdapter extends RecyclerView.Adapter<SummonAdapter.SummonAdapterRvVH>{

    ArrayList<AssignedModel> assignedModels;
    ArrayList<AvailableModel> availableModels;
    int code;

    public SummonAdapter(ArrayList<AssignedModel> assignedModels, ArrayList<AvailableModel> availableModels, int code) {
        this.assignedModels = assignedModels;
        this.availableModels = availableModels;
        this.code = code;
    }

    @NonNull
    @Override
    public SummonAdapterRvVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (code==0)
        {
            return new SummonAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.available_model_rv_layout,parent,false));
        }
        else
        {
            return new SummonAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.assigned_model_rv_layout,parent,false));
        }

    }

    @Override
    public void onBindViewHolder(@NonNull SummonAdapterRvVH holder, int position) {

        if (code==0)
        {
            holder.populateAvailable(availableModels.get(position));
        }
        else
        {
            holder.populateAssigned(assignedModels.get(position));
        }
    }

    @Override
    public int getItemCount() {

        if (code==0)
        {
            return availableModels.size();
        }
        else
        {
            return assignedModels.size();
        }
    }

    public class SummonAdapterRvVH extends RecyclerView.ViewHolder
    {
        TextView availableName,availablePost;
        TextView assignedName,assignedPost,assignedDoctor,assignedTimeElapsed;

        public SummonAdapterRvVH(@NonNull View itemView) {
            super(itemView);

            if (code==0)
            {
                availableName=itemView.findViewById(R.id.available_nurse_name);
                availablePost=itemView.findViewById(R.id.available_nurse_post);
            }

            else
            {
                assignedName=itemView.findViewById(R.id.nurse_name);
                assignedPost=itemView.findViewById(R.id.nurse_post);
                assignedDoctor=itemView.findViewById(R.id.nurse_doctor);
                assignedTimeElapsed=itemView.findViewById(R.id.time_elapsed);
            }
        }

        public void populateAvailable(AvailableModel availableModel) {

            availableName.setText(availableModel.getName());
            availablePost.setText(availableModel.getPost());

        }

        public void populateAssigned(AssignedModel assignedModel) {

            assignedName.setText(assignedModel.getName());
            assignedPost.setText(assignedModel.getPost());
            assignedDoctor.setText(assignedModel.getDoctorAssigned());
            assignedTimeElapsed.setText(assignedModel.getTimeElapsed());
        }
    }
}
