package com.example.radyapp.StaffSide.ModelsS;

public class PatientModel {
    String patientName;
    String patientDoctor;
    String patientRoom;
    String patientTime;
    String patientComment;

    public PatientModel(String patientName, String patientDoctor, String patientRoom, String patientTime, String patientComment) {
        this.patientName = patientName;
        this.patientDoctor = patientDoctor;
        this.patientRoom = patientRoom;
        this.patientTime = patientTime;
        this.patientComment = patientComment;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientDoctor() {
        return patientDoctor;
    }

    public void setPatientDoctor(String patientDoctor) {
        this.patientDoctor = patientDoctor;
    }

    public String getPatientRoom() {
        return patientRoom;
    }

    public void setPatientRoom(String patientRoom) {
        this.patientRoom = patientRoom;
    }

    public String getPatientTime() {
        return patientTime;
    }

    public void setPatientTime(String patientTime) {
        this.patientTime = patientTime;
    }

    public String getPatientComment() {
        return patientComment;
    }

    public void setPatientComment(String patientComment) {
        this.patientComment = patientComment;
    }
}
