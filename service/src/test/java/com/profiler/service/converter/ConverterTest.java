package com.profiler.service.converter;

import com.profiler.dal.entity.Role;
import com.profiler.service.GenericTest;
import com.profiler.service.dto.RoleDto;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by pavel on 4/16/16.
 */
public class ConverterTest extends GenericTest {

    @Autowired
    private ModelConverterComponent modelConverterComponent;

    @Test
    public void converterDtoToModelTest() throws ReflectiveOperationException {
        RoleDto roleDto = new RoleDto();
        roleDto.setName("admin");
        Role role = modelConverterComponent.convertToModel(roleDto, Role.class);
        Assert.assertNotNull(role);
        Assert.assertEquals(roleDto.getName(), role.getName());
    }

    @Test
    public void converterModelToDtoTest() throws ReflectiveOperationException {
        Role role = new Role();
        role.setName("admin");
        RoleDto roleDto = modelConverterComponent.convertToDto(role, RoleDto.class);
        Assert.assertNotNull(roleDto);
        Assert.assertEquals(role.getName(), roleDto.getName());
    }

}
