package com.example.radyapp.PatientSide.ModelsP;

public class PatientNotesModel {

    String doctorName;
    String doctorComments;

    public PatientNotesModel(String doctorName, String doctorComments) {
        this.doctorName = doctorName;
        this.doctorComments = doctorComments;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorComments() {
        return doctorComments;
    }

    public void setDoctorComments(String doctorComments) {
        this.doctorComments = doctorComments;
    }
}
