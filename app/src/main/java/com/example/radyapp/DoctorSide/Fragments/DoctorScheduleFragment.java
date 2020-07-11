package com.example.radyapp.DoctorSide.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.radyapp.DoctorSide.Adapters.HomePageAdapter;
import com.example.radyapp.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class DoctorScheduleFragment extends Fragment {

    View view;
    TabLayout tabLayout;
    TabItem appointmentTab,visitsTab;
    ViewPager viewPager;
    Fragment fragment;
    HomePageAdapter homePageAdapter;


    public DoctorScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_doctor_schedule, container, false);
        attachID();
        loadFragment(new DoctorAppointmentFragment());

        homePageAdapter=new HomePageAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,tabLayout.getTabCount());
        viewPager.setAdapter(homePageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());


                switch(tab.getPosition())
                {
                    case 0: fragment=new DoctorAppointmentFragment();
                        loadFragment(fragment);
                        break;
                    case 1: fragment=new DoctorVisitsFragment();
                        loadFragment(fragment);
                        break;
                    case 2: fragment=new DoctorReferenceFragment();
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
        tabLayout=view.findViewById(R.id.doctor_home_tab_layout);
        appointmentTab=view.findViewById(R.id.doctor_appointments_tab);
        visitsTab=view.findViewById(R.id.doctor_visits_tab);
        viewPager=view.findViewById(R.id.home_viewpager);
    }

    public void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_schedule,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}