package com.bancodebogota.fdsm.ejemplogradle.service;

import com.bancodebogota.fdsm.ejemplogradle.dao.UserRepository;
import com.bancodebogota.fdsm.ejemplogradle.dto.UserDto;
import com.bancodebogota.fdsm.ejemplogradle.entities.UserEntity;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;
    

    @Override
    public UserDto addUser(UserDto user) {
        return this.getDTO(userRepository.save(this.getEntity(user)));
    }

    @Override
    public void deleteUser(UserDto user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserDto> getUsers() {
        List<UserDto> list = new ArrayList<UserDto>();
        List<UserEntity> list2 = this.userRepository.findAll();
        list2.stream().forEach(p -> list.add(this.getDTO(p)));
        
        return list;
       
    }

    @Override
    public UserDto getUserByLogin(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private UserDto getDTO(UserEntity user) {
        ModelMapper modelMapper = new ModelMapper();
        UserDto dto = modelMapper.map(user, UserDto.class);
        return dto;
    }
    
    private UserEntity getEntity(UserDto user) {
        ModelMapper modelMapper = new ModelMapper();
        UserEntity entity = modelMapper.map(user, UserEntity.class);
        return entity;
    }
    
    
}
