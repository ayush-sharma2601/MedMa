package com.example.radyapp.DoctorSide.ResponseModels;

public class DocAppointmentModel {

    String patientName;
    String time;

    public DocAppointmentModel(String patientName, String time) {
        this.patientName = patientName;
        this.time = time;
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
}
