package com.backend.jejutour_server.service;

import com.backend.jejutour_server.entity.UserEntity;
import com.backend.jejutour_server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity registerUser(UserEntity user) {
        return userRepository.save(user);
    }
}
