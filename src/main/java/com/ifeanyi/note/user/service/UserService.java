package com.ifeanyi.note.user.service;

import com.ifeanyi.note.user.entity.User;
import com.ifeanyi.note.user.entity.model.UserModel;

public interface UserService {

    User createUser(UserModel userModel);
    User updateUser(UserModel userModel,Long userId);
    User getUser(Long userId);
    void deleteUser(Long userId);

}
