package com.bancodebogota.fdsm.ejemplogradle.controller;

import com.bancodebogota.fdsm.ejemplogradle.dto.UserDto;
import com.bancodebogota.fdsm.ejemplogradle.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {

    final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping(value="/create", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public UserDto create(@RequestBody UserDto user) {
        return userService.addUser(user);
    }
    
    @RequestMapping(value="/list", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<UserDto> list() {
        return userService.getUsers();
    }

}
