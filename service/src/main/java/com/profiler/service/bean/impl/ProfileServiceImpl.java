package com.profiler.service.bean.impl;

import com.profiler.dal.dao.ProfileDao;
import com.profiler.dal.entity.Profile;
import com.profiler.service.bean.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author pavel
 */
@Service("profileService")
@Transactional(readOnly = true)
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileDao profileDao;
    
    @Override
    public Profile getById(Long id) {
        return profileDao.getById(id);
    }

    @Override
    public Profile save(Profile profile) {
        Long id = profileDao.save(profile);
        profile.setId(id);
        return profile;
    }

    @Override
    public Profile update(Profile profile) {
        return profileDao.update(profile);
    }

    @Override
    public void delete(Profile profile) {
        profileDao.delete(profile);
    }

    @Override
    public List<Profile> getAll() {
        return profileDao.getAll();
    }

}
