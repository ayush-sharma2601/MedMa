package com.example.radyapp.DoctorSide.ResponseModels;

public class DoctorReferencesModel {

    String patientName;
    String time;
    String currentDoctorName;
    Boolean isDone;
    String referredDoctorName;

    public DoctorReferencesModel(String patientName, String time, String currentDoctorName, Boolean isDone, String referredDoctorName) {
        this.patientName = patientName;
        this.time = time;
        this.currentDoctorName = currentDoctorName;
        this.isDone = isDone;
        this.referredDoctorName = referredDoctorName;
    }


    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCurrentDoctorName() {
        return currentDoctorName;
    }

    public void setCurrentDoctorName(String currentDoctorName) {
        this.currentDoctorName = currentDoctorName;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public String getReferredDoctorName() {
        return referredDoctorName;
    }

    public void setReferredDoctorName(String referredDoctorName) {
        this.referredDoctorName = referredDoctorName;
    }
}
