package com.bancodebogota.fdsm.ejemplogradle.controller;


import com.bancodebogota.fdsm.ejemplogradle.client.CiudadClient;
import edu.udem.bancodebogota.consumer.wsdl.Ciudad;
import edu.udem.bancodebogota.consumer.wsdl.GetCiudadResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("/ciudad")
public class CiudadController {


    CiudadClient ciudadClient;

    @Bean
    CiudadClient setCiudadClient (CiudadClient ciudadClient) {
        this.ciudadClient = ciudadClient;
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("edu.udem.bancodebogota.consumer.wsdl");
        ciudadClient.setDefaultUri("https://heroku-gradle-juanp.herokuapp.com/ws");
        ciudadClient.setMarshaller(marshaller);
        ciudadClient.setUnmarshaller(marshaller);
        return this.ciudadClient;
    }



    @RequestMapping(value="/list/{ciduad}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Ciudad getCiudad(@PathVariable("ciduad") String ciduad) {
        GetCiudadResponse response = ciudadClient.getCiudad(ciduad);
        return response.getCiudad();
    }


}
