package com.backend.jejutour_server.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class UserEntity {

    @Id
    @Column(name = "user_id")
    private Long uid;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "email", length = 255)
    private String email;

    // ... 기타 필요한 메서드나 필드
}