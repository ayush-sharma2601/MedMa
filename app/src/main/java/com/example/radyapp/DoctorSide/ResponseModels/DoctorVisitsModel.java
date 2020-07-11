package com.example.radyapp.DoctorSide.ResponseModels;

public class DoctorVisitsModel {

    String patientName;
    String time;
    String roomNo;
    Boolean isDone;

    public DoctorVisitsModel(String patientName, String time, String roomNo, Boolean isDone) {
        this.patientName = patientName;
        this.time = time;
        this.roomNo = roomNo;
        this.isDone = isDone;
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

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }
}
