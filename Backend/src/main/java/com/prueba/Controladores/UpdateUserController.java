package com.prueba.Controladores;

import com.prueba.herramientas.Autentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.client.RestTemplate;

public class UpdateUserController {

    @PatchMapping ("/actualizar/{id}")
    private ResponseEntity<String> actualizarUsuario(){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange
                (Autentication.getURI(), HttpMethod.PATCH, new HttpEntity(Autentication.createHeaders(Autentication.getUSER(), Autentication.getPASSWORD())), String.class);
        return result ;
    }

}
