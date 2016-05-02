package com.profiler.service.bean;


import com.profiler.dal.entity.Role;
import com.profiler.service.dto.RoleDto;

import java.util.List;

/**
 *
 * @author pavel
 */
public interface RoleService {
    
    RoleDto getById(Long id);

    Long save(RoleDto role);

    RoleDto update(RoleDto role);

    void delete(RoleDto role);

    List<RoleDto> getAll();
}
