package com.profiler.service;

import com.profiler.service.bean.RoleService;
import com.profiler.service.dto.RoleDto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by pavel on 4/28/16.
 */
public class RoleServiceCrudTest extends GenericTest{

    private static final String ADMIN_ROLE = "Admin_Role";

    @Autowired
    private RoleService roleService;

    private Long id;

    @Before
    public void init() {
        RoleDto roleDto = new RoleDto();
        roleDto.setName(ADMIN_ROLE);
        id = roleService.save(roleDto);
    }

    @Test
    public void findByIdTest() {
        RoleDto roleDto = roleService.getById(id);
        assertNotNull(roleDto);
        assertEquals(ADMIN_ROLE, roleDto.getName());
    }

}
