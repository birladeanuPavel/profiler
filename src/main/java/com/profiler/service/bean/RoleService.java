package com.profiler.service.bean;

import com.profiler.dal.entity.Role;
import java.util.List;

/**
 *
 * @author pavel
 */
public interface RoleService {
    
    Role getById(Long id);
    
    Role save(Role role);
    
    Role update(Role role);

    void delete(Role role);

    List<Role> getAll();
}
