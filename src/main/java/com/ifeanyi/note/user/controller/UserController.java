package com.ifeanyi.note.user.controller;

import com.ifeanyi.note.user.entity.User;
import com.ifeanyi.note.user.entity.model.UserModel;
import com.ifeanyi.note.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public User ceateUser(UserModel userModel) {
        return userService.createUser(userModel);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(UserModel userModel, @RequestParam(name = "user_id") Long userId) {
        return userService.updateUser(userModel, userId);
    }

    @PostMapping("/get/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable(name = "user_id") Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@RequestParam(name = "user_id") Long userId) {
        userService.deleteUser(userId);
    }


}
