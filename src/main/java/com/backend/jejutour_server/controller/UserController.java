package com.backend.jejutour_server.controller;


import com.backend.jejutour_server.dto.UserDto;
import com.backend.jejutour_server.entity.UserEntity;
import com.backend.jejutour_server.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@Log4j2
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserEntity> registerUser(@RequestBody UserDto userdto) {
        try {
            UserEntity user = new UserEntity();
            user.setName(userdto.getName());
            user.setEmail(userdto.getEmail());
            user.setFirebaseUid(userdto.getFirebaseUid());

            UserEntity registeredUser = userService.registerUser(user);
            System.out.println("user 정보 저장 성공");
            return ResponseEntity.ok(registeredUser);
        } catch  (EntityNotFoundException e) {
            System.out.println("user 정보 저장 실패");
            return null;
        }
    }
}