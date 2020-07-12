package com.example.radyapp.PatientSide.ModelsP;

public class PatientApppointmentModel {
    private String doctorNAme;
    private String dept;
    private boolean status;
    private String roomNo;
    private String date;
    private String time;

    public PatientApppointmentModel(String doctorNAme, String dept, boolean status, String roomNo, String date, String time) {
        this.doctorNAme = doctorNAme;
        this.dept = dept;
        this.status = status;
        this.roomNo = roomNo;
        this.date = date;
        this.time = time;
    }

    public String getDoctorNAme() {
        return doctorNAme;
    }

    public void setDoctorNAme(String doctorNAme) {
        this.doctorNAme = doctorNAme;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
