package com.example.radyapp.DoctorSide.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.radyapp.DoctorSide.Fragments.DoctorAppointmentFragment;
import com.example.radyapp.DoctorSide.Fragments.DoctorReferenceFragment;
import com.example.radyapp.DoctorSide.Fragments.DoctorVisitsFragment;

public class HomePageAdapter extends FragmentPagerAdapter {

    private int noOfTabs;
    Context context;


    public HomePageAdapter(@NonNull FragmentManager fm, int behavior, int noOfTabs) {
        super(fm, behavior);
        this.noOfTabs = noOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                {
                return new DoctorAppointmentFragment();
                }

            case 1: {
                return new DoctorVisitsFragment();
            }

            case 2:
                return new DoctorReferenceFragment();
            default:return null;
        }

    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
