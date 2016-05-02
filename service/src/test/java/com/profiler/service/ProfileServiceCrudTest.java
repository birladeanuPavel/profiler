package com.profiler.service;

import com.profiler.service.bean.ProfileService;
import com.profiler.service.bean.RoleService;
import com.profiler.service.dto.ProfileDto;
import com.profiler.service.dto.RoleDto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * Created by pavel on 4/28/16.
 */
public class ProfileServiceCrudTest extends GenericTest {

    private static final String ADMIN_PROFILE = "Admin_Profile";
    private static final String ADMIN_ROLE = "Admin_Role";

    @Autowired
    private ProfileService profileService;

    @Autowired
    private RoleService roleService;

    private Long id;

    @Before
    public void init() {
        RoleDto roleDto = new RoleDto();
        roleDto.setName(ADMIN_ROLE);

        ProfileDto profileDto = new ProfileDto();
        profileDto.setName(ADMIN_PROFILE);
        profileDto.setRoles(new HashSet<>(Arrays.asList(roleDto)));
        id = profileService.save(profileDto);
    }

    @Test
    public void findByIdTest() {
        ProfileDto profileDto = profileService.getById(id);
        assertNotNull(profileDto);
        assertTrue(profileDto.getRoles() != null && !profileDto.getRoles().isEmpty());
        assertEquals(ADMIN_PROFILE, profileDto.getName());
        assertEquals(ADMIN_ROLE, profileDto.getRoles().iterator().next().getName());
    }
}
