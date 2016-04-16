package com.profiler.service.converter.contract;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by pavel on 4/16/16.
 *
 * Set name for the mapped method, if mapped method is setter need to specify input type,
 * it must be the same as getter method.
 * Because of the reason that conversion could be bidirectional there must be a flag to specify direction
 * default is from dto to model.
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface Convert {

    String name() default "";

    Class<?> type() default Object.class;

    ConvertType convertType() default ConvertType.TO_MODEL;

}
