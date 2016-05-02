package com.profiler.service.bean;


import com.profiler.service.dto.UserDto;

import java.util.List;

/**
 *
 * @author pavel
 */
public interface UserService {
    
    UserDto getById(Long id);
    
    Long save(UserDto user);
    
    UserDto update(UserDto user);

    void delete(UserDto user);

    List<UserDto> getAll();
}
