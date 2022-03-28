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
public class DeleteUserController {

    @DeleteMapping ("/eliminar/{id}")
    private ResponseEntity<String> eliminarId(@PathVariable String id){

        try{
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> result = restTemplate.exchange
                    (Autentication.getURI()+"/"+id, HttpMethod.DELETE, new HttpEntity(Autentication.createHeaders(Autentication.getUSER(),  Autentication.getPASSWORD())), String.class);
            return result;
        } catch (RestClientException e) {
            e.printStackTrace();
            String respuesta= (String) e.getMessage().subSequence(0, e.getMessage().indexOf(":"));
            return new ResponseEntity<>(respuesta, HttpStatus.valueOf( Integer.parseInt(e.getMessage().substring(0,3))));
        }

    }

}
