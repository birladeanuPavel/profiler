package com.profiler.service.bean;

import com.profiler.dal.entity.Profile;
import java.util.List;

/**
 *
 * @author pavel
 */
public interface ProfileService {

    Profile getById(Long id);

    Profile save(Profile profile);

    Profile update(Profile profile);

    void delete(Profile profile);

    List<Profile> getAll();
}
