package com.example.radyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.widget.Button;

import com.example.radyapp.R;

import com.example.radyapp.R;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        attachID();
    }

    private void attachID() {
        drawerLayout = findViewById(R.id.drawer_layout);
    }
}