package com.practice.gradecalculator.service;

import org.springframework.stereotype.Service;

@Service
public class GpaService {

    // ===== Module Units =====
    private static final float DESIGN_UNITS = 8f;
    private static final float DEV_UNITS = 8f;
    private static final float MOBILE_UNITS = 8f;
    private static final float ML_UNITS = 6f;
    private static final float ASD_UNITS = 4f;
    private static final float CAPSTONE_UNITS = 6f;

    private static final float CURRENT_TOTAL_UNITS =
            DESIGN_UNITS + DEV_UNITS + MOBILE_UNITS + ML_UNITS + ASD_UNITS;

    private static final float FINAL_TOTAL_UNITS =
            CURRENT_TOTAL_UNITS + CAPSTONE_UNITS;


    // ===== Convert Grade String → GPA Point =====
    public float gradeToGPA(String grade) {

        if (grade == null) return 0f;

        switch (grade.toLowerCase().trim()) {
            case "f": return 0f;
            case "d": return 1f;
            case "d+":
            case "dpos": return 1.5f;
            case "c": return 2f;
            case "c+":
            case "cpos": return 2.5f;
            case "b-":
            case "bneg": return 3f;
            case "b": return 3.5f;
            case "b+":
            case "bpos": return 4f;
            case "a-":
            case "aneg": return 4.5f;
            case "a":
            case "a+":
            case "apos": return 5f;
            default: return 0f;
        }
    }


    // ===== CURRENT GPA (without capstone) =====
    public float calculateCurrentGPA(float designGPA,
                                     float devGPA,
                                     float mlGPA,
                                     float asdGPA,
                                     float mobileGPA) {

        float totalPoints =
                designGPA * DESIGN_UNITS +
                        devGPA * DEV_UNITS +
                        mobileGPA * MOBILE_UNITS +
                        mlGPA * ML_UNITS +
                        asdGPA * ASD_UNITS;

        return totalPoints / CURRENT_TOTAL_UNITS;
    }


    // ===== PREDICTED GPA (including capstone) =====
    public float calculatePredictedGPA(float designGPA,
                                       float devGPA,
                                       float mlGPA,
                                       float asdGPA,
                                       float mobileGPA,
                                       float capstoneGPA) {

        float totalPoints =
                designGPA * DESIGN_UNITS +
                        devGPA * DEV_UNITS +
                        mobileGPA * MOBILE_UNITS +
                        mlGPA * ML_UNITS +
                        asdGPA * ASD_UNITS +
                        capstoneGPA * CAPSTONE_UNITS;

        return totalPoints / FINAL_TOTAL_UNITS;
    }

}