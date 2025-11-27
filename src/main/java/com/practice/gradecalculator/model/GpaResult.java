package com.practice.gradecalculator.model;

public class GpaResult {
    private float currentGPA;
    private float predictedGPA;
    private String designGrade;
    private String devGrade;
    private String mlGrade;
    private String asdGrade;
    private String mobileGrade;
    private String capstoneGrade;

    // Constructor
    public GpaResult(float currentGPA, float predictedGPA, String designGrade,
                     String devGrade, String mlGrade, String asdGrade,
                     String mobileGrade, String capstoneGrade) {
        this.currentGPA = currentGPA;
        this.predictedGPA = predictedGPA;
        this.designGrade = designGrade;
        this.devGrade = devGrade;
        this.mlGrade = mlGrade;
        this.asdGrade = asdGrade;
        this.mobileGrade = mobileGrade;
        this.capstoneGrade = capstoneGrade;
    }

    // Getters
    public float getCurrentGPA() {
        return currentGPA;
    }

    public float getPredictedGPA() {
        return predictedGPA;
    }

    public String getDesignGrade() {
        return designGrade;
    }

    public String getDevGrade() {
        return devGrade;
    }

    public String getMlGrade() {
        return mlGrade;
    }

    public String getAsdGrade() {
        return asdGrade;
    }

    public String getMobileGrade() {
        return mobileGrade;
    }

    public String getCapstoneGrade() {
        return capstoneGrade;
    }
}