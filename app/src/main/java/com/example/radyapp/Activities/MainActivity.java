package com.example.radyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.radyapp.R;

import com.example.radyapp.R;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.RIGHT);
            }
        });

        attachID();
    }

    private void attachID() {
        drawerLayout = findViewById(R.id.drawer_layout);
        menuBtn = findViewById(R.id.menu_btn);
    }
}