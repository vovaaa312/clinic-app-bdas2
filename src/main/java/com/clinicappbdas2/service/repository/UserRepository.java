package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.request.NewPasswordRequest;
import com.clinicappbdas2.model.request.RegisterRequest;
import com.clinicappbdas2.model.security.User;
import com.clinicappbdas2.model.security.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final PasswordEncoder passwordEncoder;

    private int userId = 1000;

    public void register(RegisterRequest request) {
        final var existingUser = getUserByLogin(request.getUsername());
        if (existingUser == null) {
            // Обратите внимание, что USER_ID больше не включен в запрос
            String query = "INSERT INTO USERS (LOGIN, PASSWORD, ID_ROLE) " +
                    "VALUES (?, ?, ?)";

            final var login = request.getUsername();
            final var password = passwordEncoder.encode(request.getPassword());
            final var role = request.getRole() == UserRole.ADMIN ? 210008 : 210009;

            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection
                        .prepareStatement(query, new String[]{"USER_ID"});
                ps.setString(1, login);
                ps.setString(2, password);
                ps.setInt(3, role);
                return ps;
            });

            System.out.println("User registered");
        }
    }


    public User getUserByLogin(String login) {
        String query = "SELECT * FROM USERS_VIEW WHERE LOGIN like ?";
        List<User> foundUsers = jdbcTemplate.query(query, new Object[]{login}, User.getUserMapper());
        if (foundUsers.size() != 1) {
            return null;
        }
        return foundUsers.get(0);
    }

    public void changePassword(NewPasswordRequest request) {
        String query = "UPDATE USERS SET PASSWORD = ? " +
                "WHERE ID = ?";

        jdbcTemplate.update(query, new Object[]{request.getPassword(), request.getId()});
    }

    public void resetPassword(User user) {
        String query = "UPDATE USERS SET PASSWORD = ? " +
                "WHERE ID = ?";

        String password = passwordEncoder.encode("secret");

        jdbcTemplate.update(query, new Object[]{password, user.getId()});
    }

    public void blockUser(User user) {
        String query = "UPDATE USERS SET AKTIVNI = 0 " +
                "WHERE ID = ?";

        jdbcTemplate.update(query, new Object[]{user.getId()});
    }

    public void unblockUser(User user) {
        String query = "UPDATE USERS SET AKTIVNI = 1 " +
                "WHERE ID = ?";

        jdbcTemplate.update(query, new Object[]{user.getId()});
    }


    public void changeUserRole(int userId, String roleName) {
        String procedureCall = "{call ChangeUsersRole(?, ?)}";
        jdbcTemplate.update(procedureCall, userId, roleName);
    }
}

