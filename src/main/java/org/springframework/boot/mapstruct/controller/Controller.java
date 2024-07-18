package org.springframework.boot.mapstruct.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.mapstruct.dto.CarDto;
import org.springframework.boot.mapstruct.dto.CategoryDto;
import org.springframework.boot.mapstruct.mapper.CarMapper;
import org.springframework.boot.mapstruct.model.Car;
import org.springframework.boot.mapstruct.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    private final CarMapper carMapper;

    public Controller(CarMapper carMapper) {
        this.carMapper = carMapper;
    }

    @GetMapping("/test")
    public CarDto testCarMapping() {
        Category category = new Category();
        category.setName("hahahahm1");
        category.setDescription("ngon");
        category.setCategoryType("bo re");
        Car car = new Car("thaidui", null, "vip", "1997", "i8",category);
        return carMapper.toEntity(car);
    }
    @GetMapping("/testDto")
    public Car testCategoryMapping() {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName("hahahahm1");
        categoryDto.setDescription("ngon");
        categoryDto.setCategoryType("bo re");
        CarDto carDto = new CarDto();
        carDto.setCarName("thaidui");
        carDto.setEngine("i8");
        carDto.setModel("vip");
        carDto.setYear("1997");
        carDto.setMakeType(null);
        carDto.setNameCar("thaidui11111");
        carDto.setCategoryDto(categoryDto);
        return  carMapper.toDto(carDto);
    }
}
