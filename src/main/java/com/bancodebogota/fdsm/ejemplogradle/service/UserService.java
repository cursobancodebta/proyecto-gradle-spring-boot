package com.bancodebogota.fdsm.ejemplogradle.service;

import com.bancodebogota.fdsm.ejemplogradle.dto.UserDto;
import java.util.List;

public interface UserService {
    public UserDto addUser(UserDto user);
    public void deleteUser(UserDto user);
    public List<UserDto> getUsers();
    public UserDto getUserByLogin(String login);
    
}
