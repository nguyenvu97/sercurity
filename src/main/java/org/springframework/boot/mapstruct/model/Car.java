package org.springframework.boot.mapstruct.model;



import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Car {

    private String name;
    private String make;
    private String model;
    private String year;
    private String engine;
    private Category category;

}
