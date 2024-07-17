package org.springframework.boot.mapstruct.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Category {
    private String name;
    private String description;
    private String categoryType;


}
