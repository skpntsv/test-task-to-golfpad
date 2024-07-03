package ru.golfpad.skopintsev.coursehandicap.model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class HandicapForm {

    @NotNull
    @Min(-100)
    @Max(54)
    private Double handicapIndex;

    @NotNull
    private Double courseRating;

    @NotNull
    @Min(55)
    @Max(155)
    private Integer slopeRating;

    @NotNull
    @Min(20)
    @Max(90)
    private Integer par;

    @NotNull
    private String holeType;
}
