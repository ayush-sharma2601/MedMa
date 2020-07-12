package com.example.radyapp.PatientSide.FragmentsP;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.radyapp.DoctorSide.Adapters.HomePageAdapter;
import com.example.radyapp.DoctorSide.Fragments.DoctorAppointmentFragment;
import com.example.radyapp.DoctorSide.Fragments.DoctorReferenceFragment;
import com.example.radyapp.DoctorSide.Fragments.DoctorVisitsFragment;
import com.example.radyapp.PatientSide.AdaptersP.PatientPageAdapter;
import com.example.radyapp.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class PatientScheduleFragment extends Fragment {
    View view;
    TabLayout tabLayout;
    TabItem appointmentsTab,routineTab;
    ViewPager viewPager;
    Fragment fragment;
    PatientPageAdapter patientPageAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_patient_schedule, container, false);

        attachID();

        loadFragment(new DoctorAppointmentFragment());

        patientPageAdapter=new PatientPageAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,tabLayout.getTabCount());
        viewPager.setAdapter(patientPageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());


                switch(tab.getPosition())
                {
                    case 0: fragment=new PatientAppointmentFragment();
                        loadFragment(fragment);
                        break;
                    case 1: fragment=new PatientRoutineFragment();//Make this fragment
                        loadFragment(fragment);
                        break;

                }
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }


        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        return view;
    }

    private void attachID() {
        tabLayout=view.findViewById(R.id.patient_home_tab_layout);
        appointmentsTab=view.findViewById(R.id.patient_appointments_tab);
        routineTab=view.findViewById(R.id.patients_tasks_tab);
        viewPager=view.findViewById(R.id.patient_home_viewpager);
    }

    public void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_schedule_patient,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}