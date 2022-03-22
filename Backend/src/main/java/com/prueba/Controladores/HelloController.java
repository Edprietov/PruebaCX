package com.prueba.Controladores;

import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

	@GetMapping("/")
	public ResponseEntity<Object> index() {
		//Get data from service layer into entityList.

		List<JSONObject> entities = new ArrayList<JSONObject>();
			JSONObject entity = new JSONObject();
			entity.put("aa", "bb");
			entities.add(entity);

		return new ResponseEntity<Object>(entities, HttpStatus.OK);
	}

	}

