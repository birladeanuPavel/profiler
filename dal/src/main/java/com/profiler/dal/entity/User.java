package com.profiler.dal.entity;

import com.profiler.dal.enums.Gender;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author pavel
 */
@Entity
@Table(name = "user")
public class User extends MainEntity implements Serializable{
    
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;
    
    @Column(name = "password", length = 50, nullable = false)
    private String password;
    
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;
    
    @Column(name = "birth_date", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthDate;
    
    @Column(name = "avatar")
    @Lob
    private String avatar;
    
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    @OneToOne
    @JoinColumn(name="id_profile")
    private Profile profile;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.email);
        hash = 43 * hash + Objects.hashCode(this.password);
        hash = 43 * hash + Objects.hashCode(this.firstName);
        hash = 43 * hash + Objects.hashCode(this.lastName);
        hash = 43 * hash + Objects.hashCode(this.birthDate);
        hash = 43 * hash + Objects.hashCode(this.avatar);
        hash = 43 * hash + Objects.hashCode(this.gender);
        hash = 43 * hash + Objects.hashCode(this.profile);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.birthDate, other.birthDate)) {
            return false;
        }
        if (!Objects.equals(this.avatar, other.avatar)) {
            return false;
        }
        if (this.gender != other.gender) {
            return false;
        }
        return Objects.equals(this.profile, other.profile);
    }

    @Override
    public String toString() {
        return "User{" + "email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", avatar=" + avatar + ", gender=" + gender + ", profile=" + profile + '}';
    }

}
