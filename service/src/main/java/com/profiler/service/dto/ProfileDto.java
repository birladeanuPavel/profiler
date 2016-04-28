package com.profiler.service.dto;

import com.profiler.dal.entity.Role;
import com.profiler.service.converter.contract.Convert;
import com.profiler.service.converter.contract.ConvertType;

import java.util.Set;

/**
 * Created by pavel on 4/25/16.
 */
public class ProfileDto {

    private String name;

    private Set<RoleDto> roles;

    @Convert(name = "setName", type = String.class)
    public String getName() {
        return name;
    }

    @Convert(name = "getName", convertType = ConvertType.TO_DTO)
    public void setName(String name) {
        this.name = name;
    }

    @Convert(name = "setRoles", type = Role.class, isCollection = true)
    public Set<RoleDto> getRoles() {
        return roles;
    }

    @Convert(name = "getRoles", type = RoleDto.class, convertType = ConvertType.TO_DTO, isCollection = true)
    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }
}
