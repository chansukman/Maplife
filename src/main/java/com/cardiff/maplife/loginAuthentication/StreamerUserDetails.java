package com.cardiff.maplife.loginAuthentication;

import com.cardiff.maplife.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StreamerUserDetails implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> authorities;


    public StreamerUserDetails(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.authorities = setUserAuthorities(user.isRegistered());
    }

    public List<GrantedAuthority> setUserAuthorities(boolean isAdmin) {
        //set USER/ADMIN authorities
        if(isAdmin){
            return new ArrayList(Collections.singleton(new SimpleGrantedAuthority("ROLE_REGISTERED")));
        } else {
            return new ArrayList(Collections.singleton(new SimpleGrantedAuthority("ROLE_NOT_REGISTERED")));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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







}
