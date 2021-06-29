package com.nadim.springsecurity2;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
public class FooBarUser implements UserDetails {

    /*
        Authority: admin
        Role: ROLE_admin
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String userName;
    private String password;
    private boolean isActive;
    private String authorities;
    private boolean isAccountNonExpired;

    public FooBarUser() {
    }

    public FooBarUser(String userName, String password, boolean isActive, String authorities, boolean isAccountNonExpired) {
        this.userName = userName;
        this.password = password;
        this.isActive = isActive;
        this.authorities = authorities;
        this.isAccountNonExpired = isAccountNonExpired;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities_list = new ArrayList<>();
        String[] auth_array = this.authorities.split(":");
        for (int i = 0; i < auth_array.length; i++) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(auth_array[i]);
            authorities_list.add(grantedAuthority);
        }
        return authorities_list;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    @Override
    public String toString() {
        return "FooBarUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", authorities='" + authorities + '\'' +
                ", isAccountNonExpired=" + isAccountNonExpired +
                '}';
    }
}
