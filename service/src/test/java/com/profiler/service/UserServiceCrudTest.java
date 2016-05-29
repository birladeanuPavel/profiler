package com.profiler.service;

import com.profiler.dal.enums.Gender;
import com.profiler.service.bean.UserService;
import com.profiler.service.dto.RoleDto;
import com.profiler.service.dto.UserDto;
import com.profiler.service.enums.ProfileEnum;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author pavel
 */
public class UserServiceCrudTest extends GenericTest{

    private static final String USER_FIRST_NAME = "admin";
    private static final String ADMIN_PROFILE = "ADMIN";
    private static final String ADMIN_ROLE = "Admin_Role";
    
    @Autowired
    private UserService userService;
            
    private Long id;
    
    @Before
    public void init() {
        RoleDto roleDto = new RoleDto();
        roleDto.setName(ADMIN_ROLE);

        UserDto user = new UserDto();
        user.setAvatar("img");
        user.setFirstName(USER_FIRST_NAME);
        user.setLastName("admin");
        user.setBirthDate(new Date());
        user.setEmail("admin@emai.ro");
        user.setPassword("123456");
        user.setGender(Gender.MALE);
        user.setProfileType(ProfileEnum.ADMIN);
        id = userService.save(user);
    }
 
    @Test
    public void getUserById() {
        Optional<UserDto> optional = userService.getById(id);
        UserDto user = optional.get();
        
        assertNotNull(user);
        assertEquals(Gender.MALE, user.getGender());
        assertEquals(1, user.getProfile().getRoles().size());
        assertEquals(ADMIN_PROFILE, user.getProfile().getName());
    }
    
}
