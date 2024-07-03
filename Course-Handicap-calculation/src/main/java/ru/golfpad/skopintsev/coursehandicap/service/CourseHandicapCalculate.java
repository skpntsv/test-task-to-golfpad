package ru.golfpad.skopintsev.coursehandicap.service;

import org.springframework.stereotype.Service;
import ru.golfpad.skopintsev.coursehandicap.model.HandicapForm;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CourseHandicapCalculate {

    public double calculateHandicap(HandicapForm handicapForm) {
        double adjustedHandicapIndex = handicapForm.getHandicapIndex();

        if (!handicapForm.getHoleType().equals("18")) {
            adjustedHandicapIndex = BigDecimal.valueOf(handicapForm.getHandicapIndex() / 2)
                    .setScale(1, RoundingMode.HALF_UP)
                    .doubleValue();
        }

        return calculateHandicap(
                adjustedHandicapIndex,
                handicapForm.getSlopeRating(),
                handicapForm.getCourseRating(),
                handicapForm.getPar()
        );
    }

    private double calculateHandicap(double handicapIndex, double slopeRating, double courseRating, double par) {
        double courseHandicap = (handicapIndex * slopeRating / 113) + (courseRating - par);
        return new BigDecimal(courseHandicap)
                .setScale(0, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
