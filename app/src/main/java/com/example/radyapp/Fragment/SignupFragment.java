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
import androidx.fragment.app.FragmentTransaction;

import com.example.radyapp.R;
import com.google.android.material.textfield.TextInputEditText;

public class SignupFragment extends Fragment {

    View view;
    EditText firstNameET,lastNameET;
    Button registerBtn;
    TextView loginIntent;
    TextInputEditText emailET,passswordET,confirmPasswordET;


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
                if(lastNameET.getText().toString().trim().equals(""))
                {
                    lastNameET.setError("Field Empty");
                    lastNameET.requestFocus();
                }if(emailET.getText().toString().trim().equals(""))
                {
                    emailET.setError("Field Empty");
                    emailET.requestFocus();
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

                if(firstNameET.getError()==null && lastNameET.getError()==null && emailET.getError()==null && passswordET.getError()==null && confirmPasswordET.getError()==null)
                {
                    loadFragment(new LoginFragment());
                    Toast.makeText(getContext(),"Registered",Toast.LENGTH_LONG).show();
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

    private void attachId() {
        firstNameET = view.findViewById(R.id.register_first_name);
        lastNameET = view.findViewById(R.id.register_last_name);
        emailET = view.findViewById(R.id.register_email);
        passswordET = view.findViewById(R.id.register_password);
        confirmPasswordET = view.findViewById(R.id.register_password_confirm);
        registerBtn = view.findViewById(R.id.register_button);
        loginIntent = view.findViewById(R.id.login_intent_btn);
    }

    private void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.login_frame_layout,fragment);//Replace framelayout with the fragment
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
}
