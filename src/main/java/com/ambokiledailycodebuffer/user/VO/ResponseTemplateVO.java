package com.ambokiledailycodebuffer.user.VO;

import com.ambokiledailycodebuffer.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResponseTemplateVO {
    private User user;
    private Department department;
    
}
