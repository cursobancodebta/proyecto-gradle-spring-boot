/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancodebogota.fdsm.ejemplogradle.service;

import com.bancodebogota.fdsm.ejemplogradle.dao.CiudadRepository;
import com.bancodebogota.fdsm.ejemplogradle.dto.CiudadDto;
import com.bancodebogota.fdsm.ejemplogradle.entities.CiudadEntity;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadServiceImpl implements CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    private CiudadDto getDTO(CiudadEntity ciudad) {
        ModelMapper modelMapper = new ModelMapper();
        CiudadDto dto = modelMapper.map(ciudad, CiudadDto.class);
        return dto;
    }

    private CiudadEntity getEntity(CiudadDto ciudad) {
        ModelMapper modelMapper = new ModelMapper();
        CiudadEntity entity = modelMapper.map(ciudad, CiudadEntity.class);
        return entity;
    }

    @Override
    public CiudadDto getCiudadByNombre(String nombre) {
        Optional<CiudadEntity> op = ciudadRepository.findById(nombre);
        return op.isPresent()? this.getDTO(op.get()): new CiudadDto();
    }

}
