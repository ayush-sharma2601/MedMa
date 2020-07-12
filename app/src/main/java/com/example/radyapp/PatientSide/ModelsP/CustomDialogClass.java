package com.example.radyapp.PatientSide.ModelsP;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.radyapp.R;

public class CustomDialogClass extends Dialog {
    Context context;
    EditText problem;
    Button book;
    TextView status;
    public CustomDialogClass(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        setContentView(R.layout.appointment_dialog);
        problem = findViewById(R.id.app_probleem_et);
        book = findViewById(R.id.book_app_btn);
        status = findViewById(R.id.app_book_status);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                status.setVisibility(View.VISIBLE);

            }
        });


    }
}
