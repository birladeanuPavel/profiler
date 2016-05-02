package com.profiler.service;

import com.profiler.dal.enums.Gender;
import com.profiler.service.bean.ProfileService;
import com.profiler.service.bean.RoleService;
import com.profiler.service.bean.UserService;
import com.profiler.service.dto.ProfileDto;
import com.profiler.service.dto.RoleDto;
import com.profiler.service.dto.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author pavel
 */
public class UserServiceCrudTest extends GenericTest{

    private static final String USER_FIRST_NAME = "admin";
    private static final String ADMIN_PROFILE = "Admin_Profile";
    private static final String ADMIN_ROLE = "Admin_Role";
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private ProfileService profileService;
    
    @Autowired
    private UserService userService;
            
    private Long id;
    
    @Before
    public void init() {
        RoleDto roleDto = new RoleDto();
        roleDto.setName(ADMIN_ROLE);

        ProfileDto profileDto = new ProfileDto();
        profileDto.setName(ADMIN_PROFILE);
        profileDto.setRoles(new HashSet<>(Arrays.asList(roleDto)));
        profileDto.setId(profileService.save(profileDto));

        UserDto user = new UserDto();
        user.setAvatar(new byte[2]);
        user.setFirstName(USER_FIRST_NAME);
        user.setLastName("admin");
        user.setBirthDate(new Date());
        user.setEmail("admin@emai.ro");
        user.setPassword("123456");
        user.setProfile(profileDto);
        user.setGender(Gender.MALE);
        id = userService.save(user);
    }
 
    @Test
    public void getUserById() {
        UserDto user = userService.getById(id);
        
        assertNotNull(user);
        assertEquals(Gender.MALE, user.getGender());
        assertEquals(1, user.getProfile().getRoles().size());
        assertEquals(ADMIN_PROFILE, user.getProfile().getName());
        assertEquals(ADMIN_ROLE, user.getProfile().getRoles().iterator().next().getName());
    }
    
}
