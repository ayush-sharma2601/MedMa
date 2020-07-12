package com.example.radyapp.PatientSide.AdaptersP;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.radyapp.DoctorSide.Fragments.DoctorAppointmentFragment;
import com.example.radyapp.DoctorSide.Fragments.DoctorReferenceFragment;
import com.example.radyapp.DoctorSide.Fragments.DoctorVisitsFragment;
import com.example.radyapp.PatientSide.FragmentsP.PatientAppointmentFragment;
import com.example.radyapp.PatientSide.FragmentsP.PatientRoutineFragment;

public class PatientPageAdapter extends FragmentPagerAdapter {

    private int noOfTabs;
    Context context;


    public PatientPageAdapter(@NonNull FragmentManager fm, int behavior, int noOfTabs) {
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
                return new PatientAppointmentFragment();
            }

            case 1: {
                return new PatientRoutineFragment();//tasks
            }

            default:return null;
        }

    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
