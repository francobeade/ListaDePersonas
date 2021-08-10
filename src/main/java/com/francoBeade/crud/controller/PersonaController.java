package com.francoBeade.crud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.francoBeade.crud.model.Persona;
import com.francoBeade.crud.repository.PersonaRepository;

@Controller
@RequestMapping("/personas") // http:localhost:8080/autos
public class PersonaController {

	private final Logger logg = LoggerFactory.getLogger(Persona.class);

	@Autowired
	private PersonaRepository personasRepository;

	@GetMapping("")
	public String home(Model model) {

		model.addAttribute("personas", personasRepository.findAll());
		return "home";
	}

	@GetMapping("/crear") // http:localhost:8080/personas/crear
	public String crear() {
		return "crear";
	}

	@PostMapping("/guardar")
	public String guardar(Persona persona) {
		logg.info("Informacion del objeto persona, {}", persona);
		personasRepository.save(persona);
		return "redirect:/personas";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Integer id, Model model) {
		Persona p = personasRepository.getOne(id);
		logg.info("Objeto recuperado {}",p);
		model.addAttribute("persona", p);
		return "editar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Integer id) {
		Persona p = personasRepository.getOne(id);
		logg.info("Objeto eliminado {}",p);
		personasRepository.delete(p);
		return "redirect:/personas";
	}
	
}
