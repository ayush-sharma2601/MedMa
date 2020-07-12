package com.example.radyapp.PatientSide.ModelsP;

public class PatientPrescriptionModel {
    String medName;
    String dosage;
    String comments;
    String doctorName;


    public PatientPrescriptionModel(String medName, String dosage, String comments, String doctorName) {
        this.medName = medName;
        this.dosage = dosage;
        this.comments = comments;
        this.doctorName = doctorName;
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

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
