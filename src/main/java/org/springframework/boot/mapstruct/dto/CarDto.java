package org.springframework.boot.mapstruct.dto;


import lombok.*;
@Data
public class CarDto {
    private String carName;
    private String makeType;
    private String model;
    private String year;
    private String engine;
    private String nameCar;
    private CategoryDto categoryDto;
}
