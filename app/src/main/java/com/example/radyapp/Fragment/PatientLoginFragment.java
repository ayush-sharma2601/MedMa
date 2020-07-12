package com.example.radyapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.radyapp.Activities.LoginActivity;
import com.example.radyapp.DoctorSide.Activities.DoctorHome;
import com.example.radyapp.PatientSide.ActivitiesP.PatientHome;
import com.example.radyapp.R;
import com.example.radyapp.RetrofitClient;
import com.example.radyapp.StaffSide.ActivitiesS.StaffHome;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
//                    Intent mainIntent = new Intent(view.getContext(), DoctorHome.class);
//                    startActivity(mainIntent);

                    loginUser(patientUsername.getText().toString(),patientPassword.getText().toString(),"patient");
                    Intent mainIntent = new Intent(view.getContext(), StaffHome.class);
                    startActivity(mainIntent);
                }
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.getInstance().loadFragment(new SignupFragment());
            }
        });

        return view ;
    }

    private void loginUser(String username, String password,String role) {
        Map<String,String> body = new HashMap<>();
        body.put("email",username);
        body.put("password",password);

        Call<String> call = RetrofitClient.getClient().registerUser(body);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {


                //Idhar kya krna hai?
                Toast.makeText(getContext(),response.body().toString(),Toast.LENGTH_LONG).show();
                Intent intent =new Intent(getActivity(), DoctorHome.class);

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getContext(),"Could not register",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void attachId() {
        loginButton=view.findViewById(R.id.fragment_patient_login_button);
        registerButton=view.findViewById(R.id.fragment_patient_login_register_button);
        patientUsername=view.findViewById(R.id.fragment_login_patient_email_et);
        patientPassword=view.findViewById(R.id.fragment_patient_login_password_et);
    }
}

