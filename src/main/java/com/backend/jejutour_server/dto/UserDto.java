package com.backend.jejutour_server.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String firebaseUid;
    private String name;
    private String email;

}
