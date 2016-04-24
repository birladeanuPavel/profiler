package com.profiler.service.converter;

/**
 * Created by pavel on 4/16/16.
 */
public interface ModelConverterComponent {

    <T> T convertToDto(Object dtoObject, Class<T> modelClass)
            throws ReflectiveOperationException;

    <T> T convertToModel(Object modelObject, Class<T> dtoClass)
            throws ReflectiveOperationException;

}
