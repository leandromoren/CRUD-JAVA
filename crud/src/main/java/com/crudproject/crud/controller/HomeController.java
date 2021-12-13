package com.crudproject.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String inicio() {
		return "index";
	}
	
	@GetMapping("/add-form")
	public String agregarMas() {
		return "formularioAgregar/addForm";
	}
}
