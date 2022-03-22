package com.prueba.Controladores;

import com.prueba.herramientas.Autentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CreateUserController {

    @PostMapping("/crear")
    private ResponseEntity<String> crearUsuario( ){

        String requestJson = "{\"name\":{\"first\": \"Pepe\" ,  \"last\": \"Perez\"}}";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<String>(requestJson, Autentication.createHeaders(Autentication.getUSER(), Autentication.getPASSWORD()));
        ResponseEntity<String> result = restTemplate.exchange
                (Autentication.getURI(), HttpMethod.POST, entity, String.class);
        return result ;
    }

}
