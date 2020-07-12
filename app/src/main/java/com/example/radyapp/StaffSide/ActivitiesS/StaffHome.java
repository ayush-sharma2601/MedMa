package com.example.radyapp.StaffSide.ActivitiesS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.radyapp.Activities.LoginActivity;
import com.example.radyapp.PatientSide.FragmentsP.EmergencyFragment;
import com.example.radyapp.PatientSide.FragmentsP.PatientBedFragment;
import com.example.radyapp.PatientSide.FragmentsP.PatientScheduleFragment;
import com.example.radyapp.R;
import com.example.radyapp.StaffSide.FragmentsS.HelperSchedule;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class StaffHome extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menuBtn;
    FrameLayout frameLayout;
    AnimatedBottomBar bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_home);

        attachID();

        loadFragment(new PatientScheduleFragment());


        bottomNavigationView.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int i, @Nullable AnimatedBottomBar.Tab tab, int i1, @NotNull AnimatedBottomBar.Tab tab1) {
                switch (tab1.getId()){
                    case R.id.helper_schedule:{
                        loadFragment(new HelperSchedule());
                        break;
                    }
                    case R.id.helper_notes:{
                        loadFragment(new EmergencyFragment());
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

    public void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void HelperProfile(MenuItem item) {
    }

    public void HelperNotices(MenuItem item) {
        Intent intent = new Intent(StaffHome.this,HelperNotices.class);
        startActivity(intent);
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    public void helper_logout(MenuItem item) {
        Intent intent = new Intent(StaffHome.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}