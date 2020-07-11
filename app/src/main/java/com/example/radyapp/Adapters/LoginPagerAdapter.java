package com.example.radyapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.radyapp.Fragment.PatientLoginFragment;
import com.example.radyapp.Fragment.StaffLoginFragment;

public class LoginPagerAdapter extends FragmentPagerAdapter {

    int noOfTabs;


    public LoginPagerAdapter(@NonNull FragmentManager fm, int behavior, int noOfTabs) {
        super(fm, behavior);
        this.noOfTabs = noOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch(position)
        {
            case 0:
                return new PatientLoginFragment();

            case 1:
                return new StaffLoginFragment();

            default:return null;
        }

    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
