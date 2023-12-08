package com.clinicappbdas2.model.security;

import lombok.Data;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

@Data
public class User implements UserDetails, Serializable {
    private Integer id;
    private String login;
    private String password;
    private UserRole role;
    private String roleName;

    public static RowMapper<User> getUserMapper() {
        return (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("USER_ID"));
            user.setLogin(rs.getString("LOGIN"));
            user.setPassword(rs.getString("PASSWORD"));
            user.setRoleName(rs.getString("NAZEV_ROLE"));
            return user;
        };
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return getLogin();
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