package com.profiler.service.converter.impl;

import com.profiler.service.converter.ModelConverterComponent;
import com.profiler.service.converter.contract.Convert;
import com.profiler.service.converter.contract.ConvertType;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by pavel on 4/16/16.
 */
@Component("modelConverterComponent")
public class ModelConverterComponentBean implements ModelConverterComponent {

    @Override
    public <T> T convertToModel(Object dtoObject, Class<T> modelClass)
            throws ReflectiveOperationException {

        T t = modelClass.newInstance();
        Method[] methods = dtoObject.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            if(method.isAnnotationPresent(Convert.class)
                    && ConvertType.TO_MODEL == method.getAnnotation(Convert.class).convertType()) {
                String setterMethodName = method.getAnnotation(Convert.class).name();
                Class<?> inputType = method.getAnnotation(Convert.class).type();
                t.getClass().getMethod(setterMethodName, inputType).invoke(t, method.invoke(dtoObject));
            }
        }

        return t;
    }

    @Override
    public <T> T convertToDto(Object modelObject, Class<T> dtoClass)
            throws ReflectiveOperationException {

        T t = dtoClass.newInstance();
        Method[] methods = dtoClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            if(method.isAnnotationPresent(Convert.class)
                    && ConvertType.TO_DTO == method.getAnnotation(Convert.class).convertType()) {
                String getterMethod = method.getAnnotation(Convert.class).name();
                method.invoke(t, modelObject.getClass().getMethod(getterMethod).invoke(modelObject));
            }
        }

        return t;
    }

}
