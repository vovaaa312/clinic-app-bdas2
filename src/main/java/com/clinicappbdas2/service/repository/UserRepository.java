package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.request.NewPasswordRequest;
import com.clinicappbdas2.model.request.RegisterRequest;
import com.clinicappbdas2.model.security.User;
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


    /**
     * REPLACE PROCEDURE
     */

    public void register(RegisterRequest request) {
        final var existingUser = getUserByLogin(request.getUsername());
        if (existingUser == null) {
            // Обратите внимание, что USER_ID больше не включен в запрос
            String query = "INSERT INTO USERS (LOGIN, PASSWORD, ID_ROLE) " +
                    "VALUES (?, ?, ?)";

            final var login = request.getUsername();
            final var password = passwordEncoder.encode(request.getPassword());
            final var role = request.getRole().equals("ADMIN") ? 210008 : 210009;

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

    public void createUser(User user){
        final var existingUser = getUserByLogin(user.getLogin());
        if (existingUser==null){
            String sql = "INSERT INTO USERS (LOGIN, PASSWORD, ID_ROLE) VALUES (?, ?, ?)";
            final var password = passwordEncoder.encode(user.getPassword());
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection
                        .prepareStatement(sql, new String[]{"USER_ID"});
                ps.setString(1, user.getLogin());
                ps.setString(2, password);
                ps.setInt(3, roleValueOf(user.getRoleName()));
                return ps;
            });
            System.out.println("User created");

        }
    }

//<<<<<<< HEAD
//
//=======
//    // TODO:
//
//    /**
//     * 1. triggers + sequences for each table to insert id (replace if passed by sequence value)
//     * 2. view `USER join USER_ROLE by roleId`
//     * 3. change `USERS` by view name
//     * 4. change User.getusermapper()
//     */
//>>>>>>> origin/master
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

    public List<User> getAllUsers() {
        String sql = "SELECT USER_ID, LOGIN, PASSWORD, ID_ROLE, NAZEV_ROLE FROM USERS_VIEW";
        return jdbcTemplate.query(sql, User.getUserDataMapper());
    }

    public User getUserById(Long id){
        String sql = "SELECT USER_ID, LOGIN, PASSWORD, ID_ROLE,ID_PACIENT,ID_ZAMESTNANEC, NAZEV_ROLE FROM USERS_VIEW WHERE USER_ID = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                User.getUserDataMapper()
        );
    }

    public void updateUser(User user){
        String sql = "UPDATE USERS SET  LOGIN=?, PASSWORD=?, ID_ROLE=? WHERE USER_ID=?";
        jdbcTemplate.update(sql,
                user.getLogin(), user.getPassword(), user.getRoleId(), user.getId());
    }

    public void deleteById(Integer id){
        String sql = "DELETE FROM USERS WHERE USER_ID = ?";
        jdbcTemplate.update(sql, id);

    }
    public void changeUserRole(int userId, String roleName) {
        String procedureCall = "{call ChangeUsersRole(?, ?)}";
        jdbcTemplate.update(procedureCall, userId, roleName);
    }

    public void setPacientUser(int pacientId, int userId){
        String procedureCall = "{call NASTAV_PACIENT_USER(?, ?)}";
        jdbcTemplate.update(procedureCall, pacientId, userId);
    }

    private Integer roleValueOf(String roleName){
        switch (roleName){
            case "ADMIN": return 210008;
            case "UZIVATEL": return 210009;
            case "ZAMESTNANEC":return 210010;
            case "ZAMESTNANEC_NADRIZENY":return 210011;
            default: return 210009;
        }

    }
}

