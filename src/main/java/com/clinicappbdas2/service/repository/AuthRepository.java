package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.security.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AuthRepository {

    private final JdbcTemplate jdbcTemplate;

    public User getUserByLogin(String login) {
        String query = "SELECT * FROM USERS WHERE LOGIN like ?";
        List<User> foundUsers = jdbcTemplate.query(query, new Object[]{login}, User.getUserMapper());
        if (foundUsers.size() != 1) {
            return null;
        }
        return foundUsers.get(0);
    }

}
