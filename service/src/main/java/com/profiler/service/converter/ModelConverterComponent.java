package com.profiler.service.converter;

/**
 * Created by pavel on 4/16/16.
 */
public interface ModelConverterComponent {

    <T> T convertToDto(Object modelClass, Class<T> dtoClass);

    <T> T convertToModel(Object dtoObject, Class<T> modelClass);

}
