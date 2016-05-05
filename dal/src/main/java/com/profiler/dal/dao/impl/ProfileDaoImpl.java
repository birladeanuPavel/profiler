package com.profiler.dal.dao.impl;

import com.profiler.dal.dao.ProfileDao;
import com.profiler.dal.entity.Profile;
import com.profiler.dal.entity.QProfile;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pavel
 */
@Repository("profileDao")
public class ProfileDaoImpl extends GenericDaoImpl<Long, Profile> 
    implements ProfileDao{

    private QProfile qProfile = QProfile.profile;

    @Override
    public Profile getByName(String name) {
        return queryFactory.from(qProfile)
                .where(qProfile.name.eq(name)).uniqueResult(qProfile);
    }
}
