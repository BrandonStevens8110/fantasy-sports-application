package com.fantasy.sports.transformer;

public interface Transformer<D, E> {

    E convertToEntity(D dto);
    D convertToDTO(E entity);

//    void convertToEntity(S dto, D entity);
//
//    void convertToDTO(D entity, S dto);

}
