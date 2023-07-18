package com.github.rusichpt.buysell.services;

import com.github.rusichpt.buysell.models.Role;
import com.github.rusichpt.buysell.models.User;
import com.github.rusichpt.buysell.repositories.UserRepository;
import com.github.rusichpt.buysell.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean createUser(User user) {
        String email = user.getEmail();
        if (userRepository.findByEmail(email) != null)
            return false;
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.USER);
        log.info("Saving new user with email: {}", email);
        userRepository.save(user);
        return true;
    }
}
