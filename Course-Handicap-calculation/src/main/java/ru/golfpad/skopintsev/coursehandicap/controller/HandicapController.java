package ru.golfpad.skopintsev.coursehandicap.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.golfpad.skopintsev.coursehandicap.model.HandicapForm;
import ru.golfpad.skopintsev.coursehandicap.service.CourseHandicapCalculate;

@Controller
public class HandicapController {
    private final CourseHandicapCalculate courseHandicapCalculate;

    @Autowired
    public HandicapController(CourseHandicapCalculate courseHandicapCalculate) {
        this.courseHandicapCalculate = courseHandicapCalculate;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("handicapForm", new HandicapForm());
        return "handicapForm";
    }

    @PostMapping("/calculate")
    public String calculateHandicap(
            @Valid HandicapForm handicapForm,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("handicapForm", handicapForm);
            return "handicapForm";
        }

        model.addAttribute("courseHandicap",
                courseHandicapCalculate.calculateHandicap(handicapForm));

        model.addAttribute("handicapForm", handicapForm);
        return "handicapForm";
    }
}
