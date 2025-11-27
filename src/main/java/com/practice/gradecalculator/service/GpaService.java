package com.practice.gradecalculator.service;

import org.springframework.stereotype.Service;

@Service
public class GpaService {

    public float gradeToGPA(String grade) {
        if (grade == null) {
            return 5f;
        }

        switch (grade.toLowerCase().trim()) {
            case "f":
                return 0f;
            case "d":
                return 1f;
            case "dpos":
            case "d+":
                return 1.5f;
            case "c":
                return 2f;
            case "cpos":
            case "c+":
                return 2.5f;
            case "bneg":
            case "b-":
                return 3f;
            case "b":
                return 3.5f;
            case "bpos":
            case "b+":
                return 4f;
            case "aneg":
            case "a-":
                return 4.5f;
            case "a":
                return 5f;
            case "apos":
            case "a+":
                return 5f;
            default:
                return 5f;
        }
    }

    public float calculateCurrentGPA(float designGPA, float devGPA) {
        return (designGPA + devGPA) / 2;
    }

    public float calculatePredictedGPA(float designGPA, float devGPA, float mlGPA,
                                       float asdGPA, float mobileGPA, float capstoneGPA) {
        return (designGPA + devGPA + mlGPA + asdGPA + mobileGPA + capstoneGPA) / 6;
    }
}
