package com.example.radyapp.PatientSide.ModelsP;

public class DoctorListModel {

    String doctorName;
    String doctorDept;
    String doctorRoom;

    public DoctorListModel(String doctorName, String doctorDept, String doctorRoom) {
        this.doctorName = doctorName;
        this.doctorDept = doctorDept;
        this.doctorRoom = doctorRoom;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorDept() {
        return doctorDept;
    }

    public void setDoctorDept(String doctorDept) {
        this.doctorDept = doctorDept;
    }

    public String getDoctorRoom() {
        return doctorRoom;
    }

    public void setDoctorRoom(String doctorRoom) {
        this.doctorRoom = doctorRoom;
    }
}
