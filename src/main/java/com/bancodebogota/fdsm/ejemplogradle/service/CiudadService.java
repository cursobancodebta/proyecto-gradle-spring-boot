/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancodebogota.fdsm.ejemplogradle.service;

import com.bancodebogota.fdsm.ejemplogradle.dto.CiudadDto;


public interface CiudadService {
    public CiudadDto getCiudadByNombre(String nombre);
}
