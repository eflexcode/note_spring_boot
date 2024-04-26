package com.ifeanyi.note.user.service;

import com.ifeanyi.note.exception.NotFountException;
import com.ifeanyi.note.user.entity.User;
import com.ifeanyi.note.user.entity.model.UserModel;

public interface UserService {

    User createUser(UserModel userModel);
    User updateUser(UserModel userModel,Long userId) throws NotFountException;
    User getUser(Long userId) throws NotFountException;
    void deleteUser(Long userId);

}
