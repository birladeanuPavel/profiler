package com.profiler.service.bean;


import com.profiler.dal.entity.Profile;
import com.profiler.service.dto.ProfileDto;
import com.profiler.service.enums.ProfileEnum;

import java.util.List;

/**
 *
 * @author pavel
 */
public interface ProfileService {

    ProfileDto getById(Long id);

    Long save(ProfileDto profile);

    ProfileDto update(ProfileDto profile);

    void delete(ProfileDto profile);

    List<ProfileDto> getAll();

    ProfileDto geByName(ProfileEnum profileType);
}
