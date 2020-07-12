package com.example.radyapp.Fragment;

import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.radyapp.Adapters.LoginPagerAdapter;
import com.example.radyapp.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class LoginFragment extends Fragment {

    View view;
    TabLayout loginTabLayout;
    TabItem patientLogin,staffLogin;
    ViewPager loginViewPager;
    LoginPagerAdapter loginPagerAdapter;
    Fragment fragment;

    public LoginFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_login,container,false);

        attachId();

        loginPagerAdapter=new LoginPagerAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,loginTabLayout.getTabCount());
        loginViewPager.setAdapter(loginPagerAdapter);

        loginTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                loginViewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()) {
                    case 0:
                        fragment = new PatientLoginFragment();
                        loadFragment(fragment);
                        break;
                    case 1:
                        fragment = new StaffLoginFragment();
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

        loginViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(loginTabLayout));

        return view;
    }

    private void attachId() {

        loginTabLayout=view.findViewById(R.id.login_tablayout);
        patientLogin=view.findViewById(R.id.login_tab_patient);
        staffLogin=view.findViewById(R.id.login_tab_staff);
        loginViewPager=view.findViewById(R.id.login_viewpager);

    }

    private void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.login_activity_frameLayout,fragment);//Replace framelayout with the fragment
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
}
