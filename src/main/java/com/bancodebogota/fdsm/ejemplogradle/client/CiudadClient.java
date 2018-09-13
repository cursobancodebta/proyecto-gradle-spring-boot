package com.bancodebogota.fdsm.ejemplogradle.client;

import edu.udem.bancodebogota.consumer.wsdl.GetCiudadRequest;
import edu.udem.bancodebogota.consumer.wsdl.GetCiudadResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Component
public class CiudadClient extends WebServiceGatewaySupport{
    private static final Logger log = LoggerFactory.getLogger(CiudadClient.class);

    public GetCiudadResponse getCiudad(String ciudad) {

        GetCiudadRequest request = new GetCiudadRequest();
        request.setNombre(ciudad);

        log.info("Requesting location for " + ciudad);

        GetCiudadResponse response = (GetCiudadResponse) getWebServiceTemplate()
                .marshalSendAndReceive("https://heroku-gradle-juanp.herokuapp.com/ws/countries", request,
                        new SoapActionCallback(
                                "https://heroku-gradle-juanp.herokuapp.com/ws"));

        return response;
    }

}