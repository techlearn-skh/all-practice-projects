package com.skh.services;

import com.skh.entities.UserEntity;
import com.skh.repoitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity registerUser(String username, String password, String role) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        // SUPER_ADMIN / MANAGER / SUPERVISOR / EXECUTIVE / VIEWER / CREATOR / AUTHOR / EDITOR / MODERATOR /
        // SUPPORT / HELPDESK / BUYER / CUSTOMER /
        // INSTRUCTOR / TEACHER / STUDENT
        return userRepository.save(user);
    }
}