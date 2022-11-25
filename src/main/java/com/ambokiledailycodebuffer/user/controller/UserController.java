package com.ambokiledailycodebuffer.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ambokiledailycodebuffer.user.VO.ResponseTemplateVO;
import com.ambokiledailycodebuffer.user.entity.User;
import com.ambokiledailycodebuffer.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("inside saveUser method for UserController ");
        return userService.saveUser(user);

    }
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("inside getUserWithDepartment method for UserController ");
        return userService.getUserWithDepartment(userId);
    }
   


    
}
