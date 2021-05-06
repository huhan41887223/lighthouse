package com.lighthouse.service;

import com.lighthouse.dao.UserRepository;
import com.lighthouse.entity.UserEntity;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BasicService {

    @Autowired
    UserRepository userRepository;

    public JPAQuery findUser(){
        return null;
    }
//
    public UserEntity selectA() {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("futureTask");
        userRepository.save(userEntity);
        return userRepository.save(userEntity);
    }

}