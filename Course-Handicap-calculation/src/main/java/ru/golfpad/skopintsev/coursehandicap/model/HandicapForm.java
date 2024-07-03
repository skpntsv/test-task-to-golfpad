package ru.golfpad.skopintsev.coursehandicap.model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class HandicapForm {

    @NotNull
    @Max(54)
    private Double handicapIndex;

    @NotNull
    @Min(55)
    @Max(155)
    private Double slopeRating;

    @NotNull
    private Double courseRating;

    @NotNull
    @Min(20)
    @Max(90)
    private Double par;
}
