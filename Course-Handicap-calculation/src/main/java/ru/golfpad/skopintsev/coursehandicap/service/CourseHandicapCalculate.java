package ru.golfpad.skopintsev.coursehandicap.service;

import org.springframework.stereotype.Service;

@Service
public class CourseHandicapCalculate {

    public double calculateHandicap(double handicapIndex, double slopeRating, double courseRating, double par) {
        return (handicapIndex * slopeRating / 113) + (courseRating - par);
    }
}
