package com.appsdeveloperblog.app.ws.service.impl;

import com.appsdeveloperblog.app.ws.UserRepository;
import com.appsdeveloperblog.app.ws.io.entity.UserEntity;
import com.appsdeveloperblog.app.ws.service.UserService;
import com.appsdeveloperblog.app.ws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user,userEntity);

        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("test UserId");

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnVale = new UserDto();
        BeanUtils.copyProperties(storedUserDetails,returnVale);

        return returnVale;
    }
}
