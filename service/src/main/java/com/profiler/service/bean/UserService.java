package com.profiler.service.bean;


import com.profiler.service.dto.UserDto;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author pavel
 */
public interface UserService {
    
    Optional<UserDto> getById(Long id);
    
    Long save(UserDto user);
    
    UserDto update(UserDto user);

    void delete(Long id);

    List<UserDto> getAll();
}
