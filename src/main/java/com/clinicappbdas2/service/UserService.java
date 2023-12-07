package com.clinicappbdas2.service;

import com.clinicappbdas2.model.exception.AccessProhibitedException;
import com.clinicappbdas2.model.exception.ServiceException;
import com.clinicappbdas2.model.request.NewPasswordRequest;
import com.clinicappbdas2.model.request.RegisterRequest;
import com.clinicappbdas2.model.security.User;
import com.clinicappbdas2.model.security.UserRole;
import com.clinicappbdas2.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

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
}
