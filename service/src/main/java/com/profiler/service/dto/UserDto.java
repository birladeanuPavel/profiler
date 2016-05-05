package com.profiler.service.dto;

import com.profiler.dal.entity.Profile;
import com.profiler.dal.enums.Gender;
import com.profiler.service.converter.contract.Convert;
import com.profiler.service.converter.contract.ConvertType;
import com.profiler.service.enums.ProfileEnum;

import java.util.Date;

/**
 * Created by pavel on 4/25/16.
 */
public class UserDto {

    private Long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private Date birthDate;

    private byte[] avatar;

    private Gender gender;

    private ProfileDto profile;

    private ProfileEnum profileType;

    @Convert(name = "setId", type = Long.class)
    public Long getId() {
        return id;
    }

    @Convert(name = "getId", convertType = ConvertType.TO_DTO)
    public void setId(Long id) {
        this.id = id;
    }


    @Convert(name = "setEmail", type = String.class)
    public String getEmail() {
        return email;
    }

    @Convert(name = "getEmail", convertType = ConvertType.TO_DTO)
    public void setEmail(String email) {
        this.email = email;
    }

    @Convert(name = "setPassword", type = String.class)
    public String getPassword() {
        return password;
    }

    @Convert(name = "getPassword", convertType = ConvertType.TO_DTO)
    public void setPassword(String password) {
        this.password = password;
    }

    @Convert(name = "setFirstName", type = String.class)
    public String getFirstName() {
        return firstName;
    }

    @Convert(name = "getFirstName", convertType = ConvertType.TO_DTO)
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Convert(name = "setLastName", type = String.class)
    public String getLastName() {
        return lastName;
    }

    @Convert(name = "getLastName", convertType = ConvertType.TO_DTO)
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Convert(name = "setBirthDate", type = Date.class)
    public Date getBirthDate() {
        return birthDate;
    }

    @Convert(name = "getBirthDate", convertType = ConvertType.TO_DTO)
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Convert(name = "setAvatar", type = byte[].class)
    public byte[] getAvatar() {
        return avatar;
    }

    @Convert(name = "getAvatar", convertType = ConvertType.TO_DTO)
    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    @Convert(name = "setGender", type = Gender.class)
    public Gender getGender() {
        return gender;
    }

    @Convert(name = "getGender", convertType = ConvertType.TO_DTO)
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Convert(name = "setProfile", type = Profile.class, doNeedConversion = true)
    public ProfileDto getProfile() {
        return profile;
    }

    @Convert(name = "getProfile", type = ProfileDto.class, convertType = ConvertType.TO_DTO, doNeedConversion = true)
    public void setProfile(ProfileDto profileDto) {
        this.profile = profileDto;
    }

    public ProfileEnum getProfileType() {
        return profileType;
    }

    public void setProfileType(ProfileEnum profileType) {
        this.profileType = profileType;
    }
}
