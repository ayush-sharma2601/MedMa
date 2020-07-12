package com.example.radyapp.PatientSide.ModelsP;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

public class customDialogClass extends Dialog {
    Context context;
    public customDialogClass(@NonNull Context context) {
        super(context);
        this.context=context;
    }
}
