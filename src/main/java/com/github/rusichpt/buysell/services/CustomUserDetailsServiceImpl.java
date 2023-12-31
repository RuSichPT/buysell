package com.github.rusichpt.buysell.services;

import com.github.rusichpt.buysell.models.User;
import com.github.rusichpt.buysell.repositories.UserRepository;
import com.github.rusichpt.buysell.services.interfaces.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null)
            throw new UsernameNotFoundException("Пользователь не зарегистророван!");
        System.out.println(user.getPassword());
        return user;
    }
}
