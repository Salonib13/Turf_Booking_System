package com.turf.service;

import com.turf.model.User;
import java.util.List;

public interface UserService {

    User registerUser(User user);

    User loginUser(String email, String password);

    List<User> getAllUsers();

    User getUserById(Long id);
}