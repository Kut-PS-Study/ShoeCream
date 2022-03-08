package com.shoecream.store.user.service;

import com.shoecream.store.errors.NotFoundException;
import com.shoecream.store.user.entity.User;
import com.shoecream.store.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;


    @Transactional
    public User login(String username, String password) {

        User user = findByEmail(username)
                .orElseThrow(() -> new NotFoundException("Could not found user for " + username));
        user.login(passwordEncoder, password);
        return user;
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(Long userId) {

        return userRepository.findById(userId);
    }

    @Transactional(readOnly = true)
    public Optional<User> findByEmail(String username) {

        return userRepository.findByUsername(username);
    }
}
