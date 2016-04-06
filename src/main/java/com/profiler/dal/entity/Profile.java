package com.profiler.dal.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author pavel
 */
@Entity
@Table(name = "profile")
public class Profile extends MainEntity implements Serializable{

    @Column(name = "name", length = 25, nullable = false, unique = true)
    private String name;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "profile_role", 
        joinColumns = { @JoinColumn(name = "id_role") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_profile") })
    private Set<Role> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Profile other = (Profile) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.roles, other.roles);
    }

    @Override
    public String toString() {
        return "Profile{" + "name=" + name + ", roles=" + roles + '}';
    }

}
