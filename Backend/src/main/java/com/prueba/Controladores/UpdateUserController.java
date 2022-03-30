package com.prueba.Controladores;

import com.prueba.herramientas.Autentication;
import com.prueba.pojo.CreateContactPOJO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
public class UpdateUserController {

    @PostMapping ("/actualizar/{id}")
    private ResponseEntity<String> actualizarUsuario(@RequestBody CreateContactPOJO contactPOJO, @PathVariable String id){
        contactPOJO.setPaisContacto((contactPOJO.getPaisContacto().equals("Colombia"))? "CO" : "US");
        String requestJson = "{\"emails\":{\"addressType\":{\"id\":0}} ,\"phones\":{\"number\":\"" +  contactPOJO.getCelularContacto() + "\",\"phoneType\":{\"id\":1}},\"address\":{\"city\":\"" + contactPOJO.getCiudadContacto() + "\",\"postalCode\":\"" + contactPOJO.getCodigoContacto() + "\",\"country\": { \"id\":\"" + contactPOJO.getPaisContacto() + "\"}  ,\"street\":\"" + contactPOJO.getDireccionContacto() +"\"}}";
        RestTemplate restTemplate = new RestTemplate();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);
        restTemplate.setRequestFactory(requestFactory);
        HttpEntity<String> entity = new HttpEntity<String>(requestJson, Autentication.createHeaders(Autentication.getUSER(), Autentication.getPASSWORD()));
        ResponseEntity<String> result = restTemplate.exchange
                (Autentication.getURI() + "/"+ id, HttpMethod.PATCH, entity, String.class);
        return result ;
    }

}
