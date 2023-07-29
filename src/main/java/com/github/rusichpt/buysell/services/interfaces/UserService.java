package com.github.rusichpt.buysell.services.interfaces;

import com.github.rusichpt.buysell.models.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    boolean createUser(User user);

    List<User> findAll();

    void banUser(Long id);

    void changeUserRoles(User user, Map<String, String> form);
}
