package com.profiler.service.dto;

import com.profiler.service.converter.contract.Convert;
import com.profiler.service.converter.contract.ConvertType;

/**
 * Created by pavel on 4/16/16.
 */
public class RoleDto {

    private String name;

    @Convert(name = "setName", type = String.class)
    public String getName() {
        return name;
    }

    @Convert(name = "getName", convertType = ConvertType.TO_DTO)
    public void setName(String name) {
        this.name = name;
    }
}
