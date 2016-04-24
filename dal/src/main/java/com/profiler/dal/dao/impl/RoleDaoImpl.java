package com.profiler.dal.dao.impl;

import com.profiler.dal.dao.RoleDao;
import com.profiler.dal.entity.Role;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pavel
 */
@Repository("roleDao")
public class RoleDaoImpl extends GenericDaoImpl<Long, Role>
    implements RoleDao {

}
