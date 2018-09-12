/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancodebogota.fdsm.ejemplogradle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author jpramirez
 */
@RestController("/index")
public class HolaMundo {
   
@RequestMapping(value="/create", method = RequestMethod.GET)
    public String helloGradle() {
        return "Hello Gradle!";
    }
}
