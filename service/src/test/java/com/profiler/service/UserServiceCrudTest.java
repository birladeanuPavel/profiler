package com.profiler.service;

import com.profiler.dal.entity.Profile;
import com.profiler.dal.entity.Role;
import com.profiler.dal.entity.User;
import com.profiler.dal.enums.Gender;
import com.profiler.service.bean.ProfileService;
import com.profiler.service.bean.RoleService;
import com.profiler.service.bean.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author pavel
 */
public class UserServiceCrudTest extends GenericTest{

    private static final String USER_FIRST_NAME = "admin";
    private static final String ROLE_NAME = "role";
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private ProfileService profileService;
    
    @Autowired
    private UserService userService;
            
    User user;
    
    @Before
    public void init() {
        Role role = new Role();
        role.setName(ROLE_NAME);
        role = roleService.save(role);
        
        Profile profile = new Profile();
        profile.setName("adminProfile");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        profile.setRoles(roles);
        profile = profileService.save(profile);
        
        user = new User();
        user.setAvatar(new byte[2]);
        user.setFirstName(USER_FIRST_NAME);
        user.setLastName("admin");
        user.setBirthDate(new Date());
        user.setEmail("admin@emai.ro");
        user.setPassword("123456");
        user.setProfile(profile);
        user.setGender(Gender.MALE);
        user = userService.save(user);
    }
 
    @Test
    public void getUserById() {
        user = userService.getById(user.getId());
        
        Assert.assertNotNull(user);
        Assert.assertEquals(1, user.getProfile().getRoles().size());
    }
    
}
