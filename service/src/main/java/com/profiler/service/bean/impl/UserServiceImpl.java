package com.profiler.service.bean.impl;

import com.profiler.dal.dao.UserDao;
import com.profiler.dal.entity.User;
import com.profiler.service.bean.ProfileService;
import com.profiler.service.bean.UserService;
import com.profiler.service.converter.ModelConverterComponent;
import com.profiler.service.dto.ProfileDto;
import com.profiler.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author pavel
 */
@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;

    @Autowired
    private ModelConverterComponent modelConverterComponent;

    @Autowired
    private ProfileService profileService;

    @Override
    public UserDto getById(Long id) {
        return modelConverterComponent.convertToDto(userDao.getById(id), UserDto.class);
    }

    @Override
    @Transactional
    public Long save(UserDto user) {
        addProfile(user);
        return userDao.save(modelConverterComponent.convertToModel(user, User.class));
    }

    @Override
    @Transactional
    public UserDto update(UserDto user) {
        addProfile(user);
        User userUpdated = userDao.update(modelConverterComponent.convertToModel(user, User.class));
        return modelConverterComponent.convertToDto(userUpdated, UserDto.class);
    }

    private void addProfile(UserDto user) {
        ProfileDto profile = profileService.geByName(user.getProfileType());
        user.setProfile(profile);
    }

    @Override
    @Transactional
    public void delete(UserDto user) {
        userDao.delete(modelConverterComponent.convertToModel(user, User.class));
    }

    @Override
    public List<UserDto> getAll() {
        return userDao.getAll()
                .stream().map(u -> modelConverterComponent.convertToDto(u, UserDto.class))
                .collect(Collectors.toList());
    }

}
