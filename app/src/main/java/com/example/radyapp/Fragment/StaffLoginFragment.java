package com.example.radyapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.radyapp.Activities.LoginActivity;
import com.example.radyapp.DoctorSide.Activities.DoctorHome;
import com.example.radyapp.R;
import com.example.radyapp.StaffSide.ActivitiesS.StaffHome;

public class StaffLoginFragment extends Fragment {

    View view;
    Button loginButtton;
    TextView registerButton;

    public StaffLoginFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_staff_login,container,false);

        attachId();

        loginButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent=new Intent(view.getContext(), StaffHome.class);
                startActivity(mainIntent);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginActivity.getInstance().loadFragment(new SignupFragment());

            }
        });

        return view ;
    }

    private void attachId() {
        loginButtton=view.findViewById(R.id.fragment_staff_login_button);
        registerButton=view.findViewById(R.id.fragment_staff_login_register_button);
    }
}
