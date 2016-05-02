package com.profiler.service.bean.impl;

import com.profiler.dal.dao.RoleDao;
import com.profiler.dal.entity.Role;
import com.profiler.service.bean.RoleService;
import com.profiler.service.converter.ModelConverterComponent;
import com.profiler.service.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author pavel
 */
@Service("roleService")
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private ModelConverterComponent modelConverterComponent;
    
    @Override
    public RoleDto getById(Long id) {
        return modelConverterComponent.convertToDto(roleDao.getById(id), RoleDto.class);
    }

    @Override
    public Long save(RoleDto role) {
        Long id = roleDao.save(modelConverterComponent.convertToModel(role, Role.class));
        return id;
    }

    @Override
    public RoleDto update(RoleDto role) {
        Role roleUpdate =
                roleDao.update(modelConverterComponent.convertToModel(role, Role.class));
        return modelConverterComponent.convertToDto(roleUpdate, RoleDto.class);
    }

    @Override
    public void delete(RoleDto role) {
        roleDao.delete(modelConverterComponent.convertToModel(role, Role.class));
    }

    @Override
    public List<RoleDto> getAll() {
        return roleDao.getAll()
                .stream().map(role -> modelConverterComponent.convertToDto(role, RoleDto.class))
                .collect(Collectors.toList());
    }

}
