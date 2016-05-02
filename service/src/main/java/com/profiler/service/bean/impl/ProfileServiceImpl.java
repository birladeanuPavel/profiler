package com.profiler.service.bean.impl;

import com.profiler.dal.dao.ProfileDao;
import com.profiler.dal.entity.Profile;
import com.profiler.service.bean.ProfileService;
import com.profiler.service.converter.ModelConverterComponent;
import com.profiler.service.dto.ProfileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author pavel
 */
@Service("profileService")
@Transactional(readOnly = true)
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileDao profileDao;

    @Autowired
    private ModelConverterComponent modelConverterComponent;
    
    @Override
    public ProfileDto getById(Long id) {
        return modelConverterComponent.convertToDto(profileDao.getById(id), ProfileDto.class);
    }

    @Override
    public Long save(ProfileDto profile) {
        return profileDao.save(modelConverterComponent.convertToModel(profile, Profile.class));
    }

    @Override
    public ProfileDto update(ProfileDto profile) {
        Profile profileUpdated = profileDao.update(modelConverterComponent.convertToModel(profile, Profile.class));
        return modelConverterComponent.convertToDto(profileUpdated, ProfileDto.class);
    }

    @Override
    public void delete(ProfileDto profile) {
        profileDao.delete(modelConverterComponent.convertToModel(profile, Profile.class));
    }

    @Override
    public List<ProfileDto> getAll() {
        return profileDao.getAll()
                .stream().map(p -> modelConverterComponent.convertToDto(p, ProfileDto.class))
                .collect(Collectors.toList());
    }

}
