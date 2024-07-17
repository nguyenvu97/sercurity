package org.springframework.boot.mapstruct.mapper;

import org.mapstruct.*;
import org.springframework.boot.mapstruct.dto.CarDto;
import org.springframework.boot.mapstruct.model.Car;

import java.util.List;

@Mapper(
        config = MapperConfig.class )
public interface CarMapper extends MapperOk<Car,CarDto> {

    @Mapping(source = "categoryDto", target = "category")
    @Mapping(source = "carName",target = "name")
    @Mapping(source = "makeType",target = "make")
    @Override
    List<Car> toListEntity(List<CarDto> d);

    @Mapping(target = "categoryDto", source = "category")
    @Mapping(target = "carName",source = "name")
    @Mapping(target = "makeType",source = "make")
    @Override
    List<CarDto> toListDto(List<Car> e);

    @Mapping(source = "categoryDto", target = "category")
    @Mapping(source = "carName",target = "name")
    @Mapping(source = "makeType",target = "make")
    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @Override
    Car toDto(CarDto carDto);

    
    @Mapping(target = "categoryDto", source = "category")
    @Mapping(target = "carName",source = "name")
    @Mapping(target = "makeType",source = "make")
    @Mapping(target = "nameCar",expression = "java(null)")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @Override
    CarDto toEntity(Car car);
}
