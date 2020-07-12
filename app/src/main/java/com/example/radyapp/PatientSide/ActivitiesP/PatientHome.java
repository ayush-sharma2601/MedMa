package com.example.radyapp.PatientSide.ActivitiesP;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.radyapp.Activities.LoginActivity;
import com.example.radyapp.DoctorSide.Fragments.DoctorInventoryFragment;
import com.example.radyapp.DoctorSide.Fragments.DoctorScheduleFragment;
import com.example.radyapp.PatientSide.FragmentsP.EmergencyFragment;
import com.example.radyapp.PatientSide.FragmentsP.PatientAppointmentFragment;
import com.example.radyapp.PatientSide.FragmentsP.PatientBedFragment;
import com.example.radyapp.PatientSide.FragmentsP.PatientScheduleFragment;
import com.example.radyapp.R;
import com.example.radyapp.StaffSide.ActivitiesS.StaffHome;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class PatientHome extends AppCompatActivity {


    DrawerLayout drawerLayout;
    ImageView menuBtn;
    FrameLayout frameLayout;
    AnimatedBottomBar bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);
        attachID();

        loadFragment(new PatientScheduleFragment());


        bottomNavigationView.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int i, @Nullable AnimatedBottomBar.Tab tab, int i1, @NotNull AnimatedBottomBar.Tab tab1) {
                switch (tab1.getId()){
                    case R.id.patient_schedule:{
                        loadFragment(new PatientScheduleFragment());
                        break;
                    }
                    case R.id.patient_emergency:{
                        loadFragment(new EmergencyFragment());
                        break;
                    }
                    case R.id.patient_rooms:{
                        loadFragment(new PatientBedFragment());
                        break;

                    }
                }
            }

            @Override
            public void onTabReselected(int i, @NotNull AnimatedBottomBar.Tab tab) {

            }
        });

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }

    private void attachID() {
        drawerLayout = findViewById(R.id.drawer_layout);
        menuBtn = findViewById(R.id.menu_btn);
        frameLayout = findViewById(R.id.frame_layout);
        bottomNavigationView = findViewById(R.id.bottom_bar);
    }


    public void DoctorProfile(MenuItem item) {
    }

    public void DoctorNotices(MenuItem item) {
    }

    public void DoctorLogout(MenuItem item) {
    }

    public void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void PatientProfile(MenuItem item) {
        Intent profileintent=new Intent(PatientHome.this,PatientProfile.class);
        startActivity(profileintent);
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    public void DoctorList(MenuItem item) {
        Intent doctorIntent=new Intent(PatientHome.this,PatientDoctors.class);
        startActivity(doctorIntent);
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    public void PatientLogout(MenuItem item) {
        Intent intent = new Intent(PatientHome.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}