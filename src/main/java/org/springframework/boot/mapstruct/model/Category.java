package org.springframework.boot.mapstruct.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Category implements Serializable {
    private String name;
    private String description;
    private String categoryType;


}
