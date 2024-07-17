package org.springframework.boot.mapstruct;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.mapstruct.controller.Controller;
import org.springframework.boot.mapstruct.dto.CarDto;
import org.springframework.boot.mapstruct.mapper.CarMapper;
import org.springframework.boot.mapstruct.model.Car;
import org.springframework.boot.mapstruct.security.Sha256;

@SpringBootApplication
@RequiredArgsConstructor
public class MapstructApplication {


    public static void main(String[] args) {

        SpringApplication.run(MapstructApplication.class, args);
        System.out.println(Sha256.sha256("hello world"));


    }

}
