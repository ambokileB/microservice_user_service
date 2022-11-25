package com.ambokiledailycodebuffer.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ambokiledailycodebuffer.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByuserId(Long userId);
    
}
