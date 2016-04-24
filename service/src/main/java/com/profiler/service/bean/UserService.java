package com.profiler.service.bean;


import com.profiler.dal.entity.User;

import java.util.List;

/**
 *
 * @author pavel
 */
public interface UserService {
    
    User getById(Long id);
    
    User save(User user);
    
    User update(User user);

    void delete(User user);

    List<User> getAll();
}
