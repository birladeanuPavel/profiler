package com.profiler.service.dto;

import com.profiler.service.converter.contract.Convert;
import com.profiler.service.converter.contract.ConvertType;

/**
 * Created by pavel on 4/16/16.
 */
public class RoleDto {

    private Long id;

    private String name;

    @Convert(name = "setId", type = Long.class)
    public Long getId() {
        return id;
    }

    @Convert(name = "getId", convertType = ConvertType.TO_DTO)
    public void setId(Long id) {
        this.id = id;
    }

    @Convert(name = "setName", type = String.class)
    public String getName() {
        return name;
    }

    @Convert(name = "getName", convertType = ConvertType.TO_DTO)
    public void setName(String name) {
        this.name = name;
    }
}
