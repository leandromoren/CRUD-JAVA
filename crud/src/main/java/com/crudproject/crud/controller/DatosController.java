package com.crudproject.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crudproject.crud.model.Datos;
import com.crudproject.crud.service.CrudService;

@Controller
@RequestMapping("/info")
public class DatosController {
	
	/**
	 * 
	 * Instancio el objeto con la anotacion <Autowired>
	 * para luego crear los diferentes metodos que le van a 
	 * dar funcionalidad a la tabla
	 */
	@Autowired
	private CrudService serviceCrud;	

	
	@GetMapping("/index")
	public String vistaDatos(Model model) {
		 List<Datos> lista = serviceCrud.buscarTodas();
		 model.addAttribute("datos",lista);
		 return "index";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editarDatos(@PathVariable("id") int idDatos, Model model) {
		Datos datos = serviceCrud.editar(idDatos);
		model.addAttribute("datos",datos);
		return "formularioAgregar/addForm";
	}
	
	
	@GetMapping("/delete/{id}")
	public String borrarDatos(@PathVariable("id") int idDatos, RedirectAttributes attributes) {
		try {
			serviceCrud.eliminar(idDatos);
			attributes.addFlashAttribute("msg", "Los datos fueron eliminados correctamente.");
		}catch(Exception e) {
			attributes.addFlashAttribute("msg", "No es posible eliminar los datos seleccionados.");
			System.out.println(e);
		}
		return "redirect:/info/index";
	}
	
	
	@PostMapping("/save")
	public String guardarDatos(Datos datos, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			System.out.println("Existieron errores en el metodo 'guardarDatos'");
			return "formularioAgregar/addForm";
		}
		serviceCrud.guardar(datos);
		attributes.addFlashAttribute("msg","Los datos se agregaron correctamente.");
		return "redirect:/info/index";
	}
	
	
	@GetMapping("/create")
	public String crearDatos(Datos datos) {
		return "formularioAgregar/addForm";
	}
}
