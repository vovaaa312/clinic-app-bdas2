package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.request.NewPasswordRequest;
import com.clinicappbdas2.model.request.RegisterRequest;
import com.clinicappbdas2.model.security.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterRequest request) {
        final var existingUser = getUserByLogin(request.getLogin());
        if (existingUser == null) {
            String query = "INSERT INTO UZIVATELE (LOGIN, PASSWORD, ROLE) " +
                    "VALUES (?, ?, ?)";

            final var result = jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection
                        .prepareStatement(query, new String[]{"ID"});
                ps.setString(1, request.getLogin());
                ps.setString(2, request.getPassword());
                ps.setString(3, request.getRole().toString());
                return ps;
            });
            System.out.println("Registered with ID: " + result);
        }
    }

    public User getUserByLogin(String login) {
        String query = "SELECT * FROM UZIVATELE WHERE LOGIN like ?";
        List<User> foundUsers = jdbcTemplate.query(query, new Object[]{login}, User.getUserMapper());
        if (foundUsers.size() != 1) {
            return null;
        }
        return foundUsers.get(0);
    }

    public void changePassword(NewPasswordRequest request) {
        String query = "UPDATE UZIVATELE SET PASSWORD = ? " +
                "WHERE ID = ?";

        jdbcTemplate.update(query, new Object[]{request.getPassword(), request.getId()});
    }

    public void resetPassword(User user) {
        String query = "UPDATE UZIVATELE SET PASSWORD = ? " +
                "WHERE ID = ?";

        String password = passwordEncoder.encode("secret");

        jdbcTemplate.update(query, new Object[]{password, user.getId()});
    }

    public void blockUser(User user) {
        String query = "UPDATE UZIVATELE SET AKTIVNI = 0 " +
                "WHERE ID = ?";

        jdbcTemplate.update(query, new Object[]{user.getId()});
    }

    public void unblockUser(User user) {
        String query = "UPDATE UZIVATELE SET AKTIVNI = 1 " +
                "WHERE ID = ?";

        jdbcTemplate.update(query, new Object[]{user.getId()});
    }


}
