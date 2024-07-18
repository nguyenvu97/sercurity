package org.springframework.boot.mapstruct.mapper;

import org.mapstruct.Mapper;
import org.springframework.boot.mapstruct.dto.CategoryDto;
import org.springframework.boot.mapstruct.model.Category;

import java.util.List;

@Mapper(config =MapperConfig.class)
public interface CatergoryMapper  extends MapperOk<Category , CategoryDto> {
    @Override
    Category toDto(CategoryDto categoryDto);

    @Override
    CategoryDto toEntity(Category category);

    @Override
    List<Category> toListEntity(List<CategoryDto> d);

    @Override
    List<CategoryDto> toListDto(List<Category> e);
}
