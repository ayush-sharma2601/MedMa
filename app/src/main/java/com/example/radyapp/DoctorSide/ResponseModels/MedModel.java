package com.example.radyapp.DoctorSide.ResponseModels;

public class MedModel {

    String medName;
    int stock;

    public MedModel(String text,int stock) {
        this.medName = text;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }
}
