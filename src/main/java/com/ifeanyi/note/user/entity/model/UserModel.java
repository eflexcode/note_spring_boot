package com.ifeanyi.note.user.entity.model;

import lombok.Data;

@Data
public class UserModel {
    private String name;
    private String email;
    private String password;
    private String profileImageUrl;
}
