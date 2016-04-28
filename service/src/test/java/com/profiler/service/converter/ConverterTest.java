package com.profiler.service.converter;

import com.profiler.dal.entity.Profile;
import com.profiler.dal.entity.Role;
import com.profiler.dal.entity.User;
import com.profiler.dal.enums.Gender;
import com.profiler.service.GenericTest;
import com.profiler.service.dto.ProfileDto;
import com.profiler.service.dto.RoleDto;
import com.profiler.service.dto.UserDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * Created by pavel on 4/16/16.
 */
public class ConverterTest extends GenericTest {

    @Autowired
    private ModelConverterComponent modelConverterComponent;

    @Test
    public void converterRole_dtoToModelTest() throws ReflectiveOperationException {
        RoleDto roleDto = new RoleDto();
        roleDto.setName("admin");
        Role role = modelConverterComponent.convertToModel(roleDto, Role.class);
        assertNotNull(role);
        assertEquals(roleDto.getName(), role.getName());
    }

    @Test
    public void converterRole_modelToDtoTest() throws ReflectiveOperationException {
        Role role = new Role();
        role.setName("admin");
        RoleDto roleDto = modelConverterComponent.convertToDto(role, RoleDto.class);
        assertNotNull(roleDto);
        assertEquals(role.getName(), roleDto.getName());
    }


    @Test
    public void convertUser_modelToDtoTest() {
        Profile profile = new Profile();
        profile.setName("adminProfile");

        User user = new User();
        user.setAvatar(new byte[2]);
        user.setFirstName("admin");
        user.setLastName("admin");
        user.setBirthDate(new Date());
        user.setEmail("admin@emai.ro");
        user.setPassword("123456");
        user.setProfile(profile);
        user.setGender(Gender.MALE);

        UserDto userDto = modelConverterComponent.convertToDto(user, UserDto.class);
        assertNotNull(userDto);
        assertEquals(user.getFirstName(), userDto.getFirstName());
        assertEquals(user.getAvatar(), userDto.getAvatar());
        assertEquals(user.getBirthDate(), userDto.getBirthDate());
        assertEquals(user.getGender(), userDto.getGender());
        assertNotNull(userDto.getProfile());
        assertEquals(user.getProfile().getName(), userDto.getProfile().getName());
    }

    @Test
    public void convertUser_dtoToModelTest() {
        ProfileDto profile = new ProfileDto();
        profile.setName("adminProfile");

        UserDto userDto = new UserDto();
        userDto.setAvatar(new byte[2]);
        userDto.setFirstName("admin");
        userDto.setLastName("admin");
        userDto.setBirthDate(new Date());
        userDto.setEmail("admin@emai.ro");
        userDto.setPassword("123456");
        userDto.setProfile(profile);
        userDto.setGender(Gender.MALE);

        User user = modelConverterComponent.convertToModel(userDto, User.class);
        assertNotNull(userDto);
        assertEquals(userDto.getFirstName(), user.getFirstName());
        assertEquals(userDto.getAvatar(), user.getAvatar());
        assertEquals(userDto.getBirthDate(), user.getBirthDate());
        assertEquals(userDto.getGender(), user.getGender());
        assertNotNull(userDto.getProfile());
        assertEquals(userDto.getProfile().getName(), user.getProfile().getName());
    }

    @Test
    public void convertProfile_modelToDtoTest() {
        Role roleUser = new Role();
        roleUser.setName("USER");

        Role roleAdmin = new Role();
        roleAdmin.setName("ADMIN");

        Profile profile = new Profile();
        profile.setName("ADMIN");
        profile.setRoles(new HashSet<>(Arrays.asList(roleUser, roleAdmin)));

        ProfileDto profileDto = modelConverterComponent.convertToDto(profile, ProfileDto.class);

        assertNotNull(profileDto);
        assertEquals(profile.getName(), profileDto.getName());
        assertNotNull(profileDto.getRoles());
        assertEquals(2, profileDto.getRoles().size());
        String name = profileDto.getRoles().iterator().next().getName();
        assertTrue("USER".equals(name) || "ADMIN".equals(name));
    }

    @Test
    public void convertProfile_dtoToModelTest() {
        RoleDto roleUser = new RoleDto();
        roleUser.setName("USER");

        RoleDto roleAdmin = new RoleDto();
        roleAdmin.setName("ADMIN");

        ProfileDto profileDto = new ProfileDto();
        profileDto.setName("ADMIN");
        profileDto.setRoles(new HashSet<>(Arrays.asList(roleAdmin, roleUser)));

        Profile profile = modelConverterComponent.convertToModel(profileDto, Profile.class);

        assertNotNull(profile);
        assertEquals(profileDto.getName(), profile.getName());
        assertNotNull(profile.getRoles());
        assertEquals(2, profile.getRoles().size());
        String name = profile.getRoles().iterator().next().getName();
        assertTrue("USER".equals(name) || "ADMIN".equals(name));

    }

}
