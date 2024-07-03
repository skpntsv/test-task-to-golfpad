package ru.golfpad.skopintsev.coursehandicap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.golfpad.skopintsev.coursehandicap.service.CourseHandicapCalculate;

@Controller
public class HandicapController {
    private final CourseHandicapCalculate courseHandicapCalculate;

    @Autowired
    public HandicapController(CourseHandicapCalculate courseHandicapCalculate) {
        this.courseHandicapCalculate = courseHandicapCalculate;
    }

    @GetMapping("/")
    public String showForm() {


        return "handicapForm";
    }

    @PostMapping("/calculate")
    public String calculateHandicap(
            @RequestParam("handicapIndex") double handicapIndex,
            @RequestParam("slopeRating") double slopeRating,
            @RequestParam("courseRating") double courseRating,
            @RequestParam("par") double par,
            Model model) {

        model.addAttribute("courseHandicap",
                courseHandicapCalculate.calculateHandicap(handicapIndex, slopeRating, courseRating, par));

        return "result";
    }
}
