package com.prueba.Controladores;

import com.prueba.pojo.CreateContactPOJO;
import com.prueba.herramientas.Autentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
public class CreateContactController {

    @PostMapping("/crear")
    private ResponseEntity<String> crearUsuario(@RequestBody CreateContactPOJO contactPOJO ){
        contactPOJO.setPaisContacto((contactPOJO.getPaisContacto().equals("Colombia"))? "CO" : "US");
        String requestJson = "{\"name\":{\"first\": \""+ contactPOJO.getNombreContacto() + "\",  \"last\":  \""+ contactPOJO.getApellidoContacto() + "\"},\"emails\":{\"address\":\""+ contactPOJO.getCorreoContacto() + "\",\"addressType\":{\"id\":0}} ,\"phones\":{\"number\":\"" +  contactPOJO.getCelularContacto() + "\",\"phoneType\":{\"id\":1}},\"address\":{\"city\":\"" + contactPOJO.getCiudadContacto() + "\",\"postalCode\":\"" + contactPOJO.getCodigoContacto() + "\",\"country\": { \"id\":\"" + contactPOJO.getPaisContacto() + "\"}  ,\"street\":\"" + contactPOJO.getDireccionContacto() +"\"}}";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<String>(requestJson, Autentication.createHeaders(Autentication.getUSER(), Autentication.getPASSWORD()));
        ResponseEntity<String> result = restTemplate.exchange
                (Autentication.getURI(), HttpMethod.POST, entity, String.class);
        return result ;
    }

}
