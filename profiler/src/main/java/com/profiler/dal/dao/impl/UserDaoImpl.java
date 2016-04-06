package com.profiler.dal.dao.impl;

import com.profiler.dal.dao.UserDao;
import com.profiler.dal.entity.User;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pavel
 */
@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<Long, User> 
    implements UserDao{
    
}
