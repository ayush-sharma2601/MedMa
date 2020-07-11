package com.example.radyapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.radyapp.Activities.LoginActivity;
import com.example.radyapp.DoctorSide.Activities.DoctorHome;
import com.example.radyapp.R;

public class PatientLoginFragment extends Fragment {

    View view;
    Button loginButton;
    TextView registerButton;
    EditText patientUsername,patientPassword;

    public PatientLoginFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_patient_login,container,false);

        attachId();



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (patientUsername.getText().toString().trim().equals(""))
                {
                    patientUsername.setError("Field Empty");
                    patientUsername.requestFocus();
                }

                if (patientPassword.getText().toString().trim().equals(""))
                {
                    patientPassword.setError("Field Empty");
                    patientPassword.requestFocus();
                }

                if (patientPassword.getError()==null&&patientUsername.getError()==null) {
                    Intent mainIntent = new Intent(view.getContext(), DoctorHome.class);
                    startActivity(mainIntent);
                }
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
        loginButton=view.findViewById(R.id.fragment_patient_login_button);
        registerButton=view.findViewById(R.id.fragment_patient_login_register_button);
        patientUsername=view.findViewById(R.id.fragment_login_patient_email_et);
        patientPassword=view.findViewById(R.id.fragment_patient_login_password_et);
    }
}

