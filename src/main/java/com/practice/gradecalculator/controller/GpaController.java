package com.practice.gradecalculator.controller;

import com.practice.gradecalculator.model.GradeForm;
import com.practice.gradecalculator.model.GpaResult;
import com.practice.gradecalculator.service.GpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GpaController {

    @Autowired
    private GpaService gpaService;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("gradeForm", new GradeForm());
        return "index";
    }

    @PostMapping("/calculate")
    public String calculateGPA(@ModelAttribute GradeForm gradeForm, Model model) {
        // Convert grades to GPA
        float designGPA = gpaService.gradeToGPA(gradeForm.getDesignGrade());
        float devGPA = gpaService.gradeToGPA(gradeForm.getDevGrade());
        float mlGPA = gpaService.gradeToGPA(gradeForm.getMlGrade());
        float asdGPA = gpaService.gradeToGPA(gradeForm.getAsdGrade());
        float mobileGPA = gpaService.gradeToGPA(gradeForm.getMobileGrade());
        float capstoneGPA = gpaService.gradeToGPA(gradeForm.getCapstoneGrade());

        // Calculate GPAs
        float currentGPA = gpaService.calculateCurrentGPA(designGPA, devGPA);
        float predictedGPA = gpaService.calculatePredictedGPA(designGPA, devGPA, mlGPA,
                asdGPA, mobileGPA, capstoneGPA);

        // Create result object
        GpaResult result = new GpaResult(
                currentGPA,
                predictedGPA,
                gradeForm.getDesignGrade(),
                gradeForm.getDevGrade(),
                gradeForm.getMlGrade(),
                gradeForm.getAsdGrade(),
                gradeForm.getMobileGrade(),
                gradeForm.getCapstoneGrade()
        );

        model.addAttribute("gradeForm", gradeForm);
        model.addAttribute("result", result);
        return "index";
    }
}