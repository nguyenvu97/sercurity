package org.springframework.boot.mapstruct.mapper;

import org.mapstruct.Mapper;

import java.util.List;

public interface MapperOk <E,D>{
    E toDto(D d);
    D toEntity(E e);
    List<E> toListEntity(List<D> d);
    List<D> toListDto(List<E> e);
}
