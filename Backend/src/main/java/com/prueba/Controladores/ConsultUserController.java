package com.prueba.Controladores;

import com.prueba.herramientas.Autentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;


@CrossOrigin
@RestController
public class ConsultUserController {


        @GetMapping("/consultar")
        private ResponseEntity<String> consultarTodos(){

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> result = restTemplate.exchange
                    (Autentication.getURIG() + "?query=select id,  name.first, name.last,  address.city, address.country,  emails.address, phones.number  from contacts  where emails.address is not null  and phones.phoneType = 1 order by id;", HttpMethod.GET, new HttpEntity(Autentication.createHeaders(Autentication.getUSER(), Autentication.getPASSWORD())), String.class);
                    System.out.println("Consultar todos");
            return result ;
        }

    @GetMapping("/consultar/{id}")
    private ResponseEntity<String> consultarPorId(@PathVariable String id){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange
                (Autentication.getURI()+"/"+id, HttpMethod.GET, new HttpEntity(Autentication.createHeaders(Autentication.getUSER(),  Autentication.getPASSWORD())), String.class);
        return result ;
    }


}
