package com.example.radyapp.Fragment;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
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
import androidx.fragment.app.FragmentTransaction;

import com.example.radyapp.Activities.LoginActivity;
import com.example.radyapp.DoctorSide.Activities.DoctorHome;
import com.example.radyapp.Models.LoginCall;
import com.example.radyapp.R;
import com.example.radyapp.RetrofitClient;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignupFragment extends Fragment {

    View view;
    EditText firstNameET,pinET,addressET,genderET,dobET;
    Button registerBtn;
    TextView loginIntent;
    EditText emailET,passswordET,confirmPasswordET,phoneNumberET;

    public SignupFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_signup,container,false);

        attachId();

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstNameET.getText().toString().trim().equals(""))
                {
                    firstNameET.setError("Field Empty");
                    firstNameET.requestFocus();
                }
                if(pinET.getText().toString().trim().equals(""))
                {
                    pinET.setError("Field Empty");
                    pinET.requestFocus();
                }if(addressET.getText().toString().trim().equals(""))
                {
                    addressET.setError("Field Empty");
                    addressET.requestFocus();
                }if(dobET.getText().toString().trim().equals(""))
                {
                    dobET.setError("Field Empty");
                    dobET.requestFocus();
                }if(genderET.getText().toString().trim().equals(""))
                {
                    genderET.setError("Field Empty");
                    genderET.requestFocus();
                }if(emailET.getText().toString().trim().equals(""))
                {
                    emailET.setError("Field Empty");
                    emailET.requestFocus();
                }if(phoneNumberET.getText().toString().trim().equals(""))
                {
                    phoneNumberET.setError("Field Empty");
                    phoneNumberET.requestFocus();
                }if(passswordET.getText().toString().trim().equals(""))
                {
                    passswordET.setError("Field Empty");
                    passswordET.requestFocus();
                }if(confirmPasswordET.getText().toString().trim().equals(""))
                {
                    confirmPasswordET.setError("Field Empty");
                    confirmPasswordET.requestFocus();
                }
                if(!confirmPasswordET.getText().toString().trim().equals(passswordET.getText().toString().trim()))
                {
                    confirmPasswordET.setError("passwords do not match");
                    confirmPasswordET.requestFocus();
                }

                if(addressET.getError()==null && dobET.getError()==null && firstNameET.getError()==null && genderET.getError()==null && phoneNumberET.getError()==null && pinET.getError()==null && emailET.getError()==null && passswordET.getError()==null && confirmPasswordET.getError()==null)
                {
                    String fullName = firstNameET.getText().toString().trim();
                    String address1 = addressET.getText().toString();
                    String pin = pinET.getText().toString();
                    String address = address1 + " " + pin;
                    String gender = genderET.getText().toString().trim();
                    String dob = dobET.getText().toString();
                    String email = emailET.getText().toString().trim();
                    String phone = phoneNumberET.getText().toString().trim();
                    String password = passswordET.getText().toString().trim();
                    registerUser(fullName,address,phone,email,password,gender,dob);
                }

            }
        });

        loginIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new LoginFragment());
            }
        });

        return view;
    }

    private void registerUser(String fullName, String address, String phone, String email, String password, String gender, String dob) {
        Map<String,String> body = new HashMap<>();


        Call<LoginCall> call = RetrofitClient.getClient().registerUser(fullName,dob,gender,phone,address,"patient",email,password);
        call.enqueue(new Callback<LoginCall>() {
            @Override
            public void onResponse(Call<LoginCall> call, Response<LoginCall> response) {
                Toast.makeText(getContext(),response.body().toString(),Toast.LENGTH_LONG).show();
                if (response.body().getSuccess()){
                    Intent intent = new Intent(view.getContext(), LoginActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(view.getContext(),"unsuccessful",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<LoginCall> call, Throwable t) {
                Toast.makeText(getContext(),"Could not register",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void attachId() {
        firstNameET = view.findViewById(R.id.register_first_name);
        emailET = view.findViewById(R.id.register_email);
        passswordET = view.findViewById(R.id.register_password);
        confirmPasswordET = view.findViewById(R.id.register_password_confirm);
        phoneNumberET = view.findViewById(R.id.register_phone);
        registerBtn = view.findViewById(R.id.register_button);
        loginIntent = view.findViewById(R.id.login_intent_btn);
        loginIntent.setPaintFlags(loginIntent.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        pinET = view.findViewById(R.id.register_pincode);
        dobET=view.findViewById(R.id.register_dob);
        addressET =  view.findViewById(R.id.register_address);
        genderET = view.findViewById(R.id.gender);
    }

    private void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.login_frame_layout,fragment);//Replace framelayout with the fragment
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
}
