package ru.golfpad.skopintsev.coursehandicap.model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class HandicapForm {

    @NotNull(message = "{handicapForm.handicapIndex.range}")
    @Min(value = -100, message = "{handicapForm.handicapIndex.range}")
    @Max(value = 54, message = "{handicapForm.handicapIndex.range}")
    private Double handicapIndex;

    @Min(value = 0, message = "{handicapForm.courseRating.range}")
    @NotNull(message = "{handicapForm.courseRating.notNull}")
    private Double courseRating;

    @NotNull(message = "{handicapForm.slopeRating.range}")
    @Min(value = 55, message = "{handicapForm.slopeRating.range}")
    @Max(value = 155, message = "{handicapForm.slopeRating.range}")
    private Integer slopeRating;

    @NotNull(message = "{handicapForm.par.range}")
    @Min(value = 20, message = "{handicapForm.par.range}")
    @Max(value = 90, message = "{handicapForm.par.range}")
    private Integer par;

    @NotNull
    private String holeType;
}
