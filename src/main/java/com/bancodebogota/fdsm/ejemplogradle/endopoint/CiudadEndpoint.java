/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancodebogota.fdsm.ejemplogradle.endopoint;

import com.bancodebogota.fdsm.ejemplogradle.dto.CiudadDto;
import com.bancodebogota.fdsm.ejemplogradle.service.CiudadService;
import edu.udem.bancodebogota.proyecto_gradle_spring_boot.Ciudad;
import edu.udem.bancodebogota.proyecto_gradle_spring_boot.GetCiudadRequest;
import edu.udem.bancodebogota.proyecto_gradle_spring_boot.GetCiudadResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class CiudadEndpoint {

    private static final String NAMESPACE_URI = "http://udem.edu/bancodebogota/proyecto-gradle-spring-boot";

    private CiudadService ciudadService;

    @Autowired
    public CiudadEndpoint(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCiudadRequest")
    @ResponsePayload
    public GetCiudadResponse getCountry(@RequestPayload GetCiudadRequest request) {
        GetCiudadResponse response = new GetCiudadResponse();
        CiudadDto ciudadDto = ciudadService.getCiudadByNombre(request.getNombre());
        response.setCiudad(getCiudad(ciudadDto));

        return response;
    }

    private Ciudad getCiudad(CiudadDto ciudadDto) {
        ModelMapper modelMapper = new ModelMapper();
        Ciudad entity = modelMapper.map(ciudadDto, Ciudad.class);
        return entity;
    }
        
}
