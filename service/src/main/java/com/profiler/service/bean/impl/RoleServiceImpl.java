package com.profiler.service.bean.impl;

import com.profiler.dal.dao.RoleDao;
import com.profiler.dal.entity.Role;
import com.profiler.service.bean.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author pavel
 */
@Service("roleService")
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    
    @Override
    public Role getById(Long id) {
        return roleDao.getById(id);
    }

    @Override
    public Role save(Role role) {
        Long id = roleDao.save(role);
        role.setId(id);
        return role;
    }

    @Override
    public Role update(Role role) {
        return roleDao.update(role);
    }

    @Override
    public void delete(Role role) {
        roleDao.delete(role);
    }

    @Override
    public List<Role> getAll() {
        return roleDao.getAll();
    }

}
