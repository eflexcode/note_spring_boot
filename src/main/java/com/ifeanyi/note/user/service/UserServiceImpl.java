package com.ifeanyi.note.user.service;

import com.ifeanyi.note.exception.NotFountException;
import com.ifeanyi.note.user.entity.User;
import com.ifeanyi.note.user.entity.model.UserModel;
import com.ifeanyi.note.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
@Data
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

    @Override
    public User createUser(UserModel userModel) {

        User user = new User();
        BeanUtils.copyProperties(userModel,user);

        return userRepository.save(user);
    }

    @Override
    public User updateUser(UserModel userModel,Long userId) throws NotFountException {

        User user = getUser(userId);// userRepository.findById(userId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        user.setName(userModel.getName() != null ? userModel.getName() : user.getName());
        user.setName(userModel.getEmail() != null ? userModel.getEmail() : user.getEmail());
        user.setName(userModel.getPassword() != null ? userModel.getPassword() : user.getPassword());
        user.setName(userModel.getProfileImageUrl() != null ? userModel.getProfileImageUrl() : user.getProfileImageUrl());

        return userRepository.save(user);
    }

    @Override
    public User getUser(Long userId) throws NotFountException {
        return userRepository.findById(userId).orElseThrow(()-> new NotFountException("No user found with id: "+userId));
    }

    @Override
    public void deleteUser(Long userId) {

        userRepository.deleteById(userId);

    }
}
