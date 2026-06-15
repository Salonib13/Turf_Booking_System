package com.turf.service.impl;

import com.turf.model.User;
import com.turf.repository.UserRepository;
import com.turf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    
    public User registerUser(User user) {

        
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }

        
        if (user.getName() == null || user.getName().isEmpty()) {
            user.setName("Unknown");
        }

        return userRepository.save(user);
    }

    @Override
    public User loginUser(String email, String password) {
        return userRepository.findAll()
                .stream()
                .filter(u -> u.getEmail().equals(email)
                        && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}