package com.example.radyapp.PatientSide.ModelsP;

public class PatientBedModel {

    String bedClass;
    String occupancy;
    String vacancy;
    String wardManager;
    String wardNumber;

    public PatientBedModel(String bedClass, String occupancy, String vacancy, String wardManager, String wardNumber) {
        this.bedClass = bedClass;
        this.occupancy = occupancy;
        this.vacancy = vacancy;
        this.wardManager = wardManager;
        this.wardNumber = wardNumber;
    }

    public String getBedClass() {
        return bedClass;
    }

    public void setBedClass(String bedClass) {
        this.bedClass = bedClass;
    }

    public String getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(String occupancy) {
        this.occupancy = occupancy;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

    public String getWardManager() {
        return wardManager;
    }

    public void setWardManager(String wardManager) {
        this.wardManager = wardManager;
    }

    public String getWardNumber() {
        return wardNumber;
    }

    public void setWardNumber(String wardNumber) {
        this.wardNumber = wardNumber;
    }
}
