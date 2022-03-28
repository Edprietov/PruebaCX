package com.prueba.Controladores;

import com.prueba.herramientas.Autentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
public class GetCountriesController {

    @GetMapping ("/paises")
    private ResponseEntity<String> getCountries(){

        try{
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> result = restTemplate.exchange
                    (Autentication.getURIG()+"?query=select id, name from countries", HttpMethod.GET, new HttpEntity(Autentication.createHeaders(Autentication.getUSER(),  Autentication.getPASSWORD())), String.class);
            return result;
        } catch (RestClientException e) {
            e.printStackTrace();
            return new ResponseEntity<>("No existe!", HttpStatus.OK);
        }

    }


}
