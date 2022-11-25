package com.ambokiledailycodebuffer.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.ambokiledailycodebuffer.user.VO.Department;
import com.ambokiledailycodebuffer.user.VO.ResponseTemplateVO;
import com.ambokiledailycodebuffer.user.entity.User;
import com.ambokiledailycodebuffer.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("inside saveUser method of UserService");
        return userRepository.save(user);
    }


    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("inside getUserWithDepartment method of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByuserId(userId);


        Department department = restTemplate.getForObject("http://localhost:9002/departments/" + user.getDepartmentId(), Department.class);


        vo.setUser(user);
        vo.setDepartment(department);


        return vo;
      
    }
    
}
