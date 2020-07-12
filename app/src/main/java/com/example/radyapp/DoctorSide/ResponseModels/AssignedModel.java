package com.example.radyapp.DoctorSide.ResponseModels;

public class AssignedModel {

    String name;
    String post;
    String doctorAssigned;
    String timeElapsed;

    public AssignedModel(String name, String post, String doctorAssigned, String timeElapsed) {
        this.name = name;
        this.post = post;
        this.doctorAssigned = doctorAssigned;
        this.timeElapsed = timeElapsed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getDoctorAssigned() {
        return doctorAssigned;
    }

    public void setDoctorAssigned(String doctorAssigned) {
        this.doctorAssigned = doctorAssigned;
    }

    public String getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(String timeElapsed) {
        this.timeElapsed = timeElapsed;
    }
}
