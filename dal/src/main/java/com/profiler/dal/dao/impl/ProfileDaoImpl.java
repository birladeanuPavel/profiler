package com.profiler.dal.dao.impl;

import com.profiler.dal.dao.ProfileDao;
import com.profiler.dal.entity.Profile;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pavel
 */
@Repository("profileDao")
public class ProfileDaoImpl extends GenericDaoImpl<Long, Profile> 
    implements ProfileDao{
    
}
