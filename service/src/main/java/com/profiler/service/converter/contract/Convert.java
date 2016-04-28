package com.profiler.service.converter.contract;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by pavel on 4/16/16.
 *
 * Set name for the mapped method, if mapped method is setter you have to specify input type,
 * it must be the same as getter method.
 * Because conversion could be bidirectional there must be a flag to specify direction
 * default is from dto to model, also for collections you have to specify the type.
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface Convert {

    String name() default "";

    Class<?> type() default Object.class;

    ConvertType convertType() default ConvertType.TO_MODEL;

    boolean isCollection() default false;

    boolean isSet() default true;

    boolean doNeedConversion() default false;

}
