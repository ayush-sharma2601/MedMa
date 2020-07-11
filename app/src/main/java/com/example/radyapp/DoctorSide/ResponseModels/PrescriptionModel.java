package com.example.radyapp.DoctorSide.ResponseModels;

public class PrescriptionModel {
    String medName;
    String dosage;
    String comments;

    public PrescriptionModel(String medName, String dosage, String comments) {
        this.medName = medName;
        this.dosage = dosage;
        this.comments = comments;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
