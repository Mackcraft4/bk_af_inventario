package com.paramonga.ssff.mapper;

import java.util.List;

public interface GenericMapper<E, D> {
    D toDto(E entity);
    E toEntity(D dto);
    List<D> toListDto(List<E> entity);
    List<E> toListEntity(List<D> dto);
}
