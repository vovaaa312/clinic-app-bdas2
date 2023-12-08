package com.clinicappbdas2.service;

import com.clinicappbdas2.model.exception.AccessProhibitedException;
import com.clinicappbdas2.model.exception.ServiceException;
import com.clinicappbdas2.model.request.NewPasswordRequest;
import com.clinicappbdas2.model.request.RegisterRequest;
import com.clinicappbdas2.model.security.User;
import com.clinicappbdas2.model.security.UserRole;
import com.clinicappbdas2.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JdbcTemplate jdbcTemplate;

    public void register(RegisterRequest request) {
        userRepository.register(request);
    }

    public User getUserByLogin(String login){
        return userRepository.getUserByLogin(login);
    }

    public User getUserDetailsByLogin(String username){
        User user = getUserByLogin(username);

        if (user == null){
            throw new UsernameNotFoundException(format("User: %s, not found", username));
        }

        return user;
    }

    public void changePassword(NewPasswordRequest request){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user == null || (user.getRole() == UserRole.USER && user.getId() != request.getId())){
            throw new AccessProhibitedException("Access denied");
        }

        userRepository.changePassword(request);
    }

    public void resetPassword(User user){
        if (user.getRole() != UserRole.USER){
            throw new ServiceException("It's forbidden to reset passwords for admins");
        }

        userRepository.resetPassword(user);
    }

    public void blockUser(User user){
        if (user.getRole() != UserRole.USER){
            throw new ServiceException("It's forbidden to block admins");
        }

        userRepository.blockUser(user);
    }

    public void unblockUser(User user){
        if (user.getRole() != UserRole.USER){
            throw new ServiceException("It's forbidden to unblock admins");
        }

        userRepository.unblockUser(user);
    }


    public void changeUserRole(int userId, String roleName) {
        userRepository.changeUserRole(userId, roleName);
    }

    public List<User> getAll(){
        return userRepository.getAllUsers();
    }

    public void create(User user) {
        userRepository.createUser(user);
    }

    public void update(User user){
        userRepository.updateUser(user);
    }

    public User getById(int id){
        return userRepository.getUserById(id);
    }

    public void delete(int id){userRepository.deleteById(id);}


}
