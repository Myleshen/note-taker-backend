package com.myleshen.notes.security.model;

import com.myleshen.notes.security.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserModel implements UserDetails {

    private final String userName;
    private final String userPass;
    private final boolean active;
    private final List<GrantedAuthority> authorities;

    public UserModel(UserEntity userEntity) {
        this.userName = userEntity.getUserName();
        this.userPass = userEntity.getUserPass();
        this.active = userEntity.getActive();
        this.authorities = Arrays.stream(userEntity.getRoleList().split(","))
                            .map(SimpleGrantedAuthority::new)
                            .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return userPass;
    }

    @Override
    public String getUsername() {
        return userName;
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
        return active;
    }
}
