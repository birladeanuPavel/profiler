package com.profiler.service.converter.impl;

import com.profiler.dal.entity.Profile;
import com.profiler.service.converter.ModelConverterComponent;
import com.profiler.service.converter.contract.Convert;
import com.profiler.service.converter.contract.ConvertType;
import com.profiler.service.dto.ProfileDto;
import com.profiler.service.dto.RoleDto;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by pavel on 4/16/16.
 */
@Component("modelConverterComponent")
public class ModelConverterComponentBean implements ModelConverterComponent {

//    @Override
//    public <T> T convertToModel(Object dtoObject, Class<T> modelClass)
//            throws ReflectiveOperationException {
//
//        T t = modelClass.newInstance();
//        Method[] methods = dtoObject.getClass().getMethods();
//        for (int i = 0; i < methods.length; i++) {
//            Method method = methods[i];
//            if(method.isAnnotationPresent(Convert.class)
//                    && ConvertType.TO_MODEL == method.getAnnotation(Convert.class).convertType()) {
//                String setterMethodName = method.getAnnotation(Convert.class).name();
//                Class<?> inputType = method.getAnnotation(Convert.class).type();
//                t.getClass().getMethod(setterMethodName, inputType).invoke(t, method.invoke(dtoObject));
//            }
//        }
//
//        return t;
//    }
//
//    @Override
//    public <T> T convertToDto(Object modelObject, Class<T> dtoClass)
//            throws ReflectiveOperationException {
//
//        T t = dtoClass.newInstance();
//        Method[] methods = dtoClass.getMethods();
//        for (int i = 0; i < methods.length; i++) {
//            Method method = methods[i];
//            if(method.isAnnotationPresent(Convert.class)
//                    && ConvertType.TO_DTO == method.getAnnotation(Convert.class).convertType()) {
//                String getterMethod = method.getAnnotation(Convert.class).name();
//                method.invoke(t, modelObject.getClass().getMethod(getterMethod).invoke(modelObject));
//            }
//        }
//
//        return t;
//    }

    @Override
    public <T> T convertToModel(Object dtoObject, Class<T> modelClass) {
        T t = null;
        try {
            t = modelClass.newInstance();
            Method[] methods = dtoObject.getClass().getMethods();
            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                if (method.isAnnotationPresent(Convert.class)
                        && ConvertType.TO_MODEL == method.getAnnotation(Convert.class).convertType()) {

                    Convert convertMethodAnnotation = method.getAnnotation(Convert.class);
                    String setterMethodName = method.getAnnotation(Convert.class).name();
                    Class<?> type = method.getAnnotation(Convert.class).type();

                    if (convertMethodAnnotation.isCollection()) {
                        Collection<Object> collection = (Collection<Object>) method.invoke(dtoObject);
                        if (collection != null) {
                            Class<?> collectionModelClass = convertMethodAnnotation.type();
                            Stream<Object> stream =
                                    collection.stream().map(o -> convertToModel(o, collectionModelClass));

                            Collection<Object> collectionMapped;
                            Class<?> collectionClass;
                            if (convertMethodAnnotation.isSet()) {
                                collectionMapped = stream.collect(Collectors.toSet());
                                collectionClass = Set.class;
                            } else {
                                collectionMapped = stream.collect(Collectors.toList());
                                collectionClass = List.class;
                            }

                            t.getClass().getMethod(setterMethodName, collectionClass).invoke(t, collectionMapped);
                        }
                    } else if (convertMethodAnnotation.doNeedConversion()) {
                        Object object = method.invoke(dtoObject);
                        if (object != null) {
                            Class<?> collectionModelClass = convertMethodAnnotation.type();
                            t.getClass().getMethod(setterMethodName, type).invoke(t, convertToModel(object, collectionModelClass));
                        }
                    } else {
                        t.getClass().getMethod(setterMethodName, type).invoke(t, method.invoke(dtoObject));
                    }
                }
            }
        } catch (InstantiationException | IllegalAccessException
                | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return t;
    }

    @Override
    public <T> T convertToDto(Object modelObject, Class<T> dtoClass) {

        T t = null;
        try {
            t = dtoClass.newInstance();
            Method[] methods = dtoClass.getMethods();
            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                if (method.isAnnotationPresent(Convert.class)
                        && ConvertType.TO_DTO == method.getAnnotation(Convert.class).convertType()) {

                    Convert convertMethodAnnotation = method.getAnnotation(Convert.class);
                    String getterMethod = convertMethodAnnotation.name();

                    if (convertMethodAnnotation.isCollection()) {
                        Collection<Object> collection =
                                (Collection<Object>) modelObject.getClass().getMethod(getterMethod).invoke(modelObject);
                        if (collection != null) {
                            Class<?> collectionDtoClass = convertMethodAnnotation.type();
                            Stream<Object> stream =
                                    collection.stream().map(o -> convertToDto(o, collectionDtoClass));

                            Collection<Object> collectionMapped;
                            if (convertMethodAnnotation.isSet()) {
                                collectionMapped = stream.collect(Collectors.toSet());
                            } else {
                                collectionMapped = stream.collect(Collectors.toList());
                            }

                            method.invoke(t, collectionMapped);
                        }
                    } else if (convertMethodAnnotation.doNeedConversion()) {
                        Object object = modelObject.getClass().getMethod(getterMethod).invoke(modelObject);
                        if(object != null) {
                            Class<?> collectionDtoClass = convertMethodAnnotation.type();
                            method.invoke(t, convertToDto(object, collectionDtoClass));
                        }

                    } else {
                        method.invoke(t, modelObject.getClass().getMethod(getterMethod).invoke(modelObject));
                    }

                }
            }
        } catch (InstantiationException | IllegalAccessException
                | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return t;
    }

}
