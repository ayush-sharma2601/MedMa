package com.example.radyapp.DoctorSide.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.radyapp.DoctorSide.Adapters.HomePageAdapter;
import com.example.radyapp.DoctorSide.Adapters.SummonPagerAdapter;
import com.example.radyapp.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class DoctorSummonFragment extends Fragment {
        View view;
    TabLayout tabLayout;
    TabItem availableTab, assignedTab;
    ViewPager viewPager;
    Fragment fragment;
    SummonPagerAdapter summonPagerAdapter;

    public DoctorSummonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_doctor_summon, container, false);

        attachId();

        loadFragment(new DoctorSummonAvailableFragment());

        summonPagerAdapter=new SummonPagerAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,tabLayout.getTabCount());
        viewPager.setAdapter(summonPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());


                switch(tab.getPosition())
                {
                    case 0: fragment=new DoctorSummonAvailableFragment();
                        loadFragment(fragment);
                        break;
                    case 1: fragment=new DoctorSummonAssignedFragment();
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

    private void attachId() {
        tabLayout=view.findViewById(R.id.summon_tab_layout);
        availableTab =view.findViewById(R.id.doctor_available_tab);
        assignedTab =view.findViewById(R.id.doctor_assigned_tab);
        viewPager=view.findViewById(R.id.summon_viewpager);
    }

    public void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_summon,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}