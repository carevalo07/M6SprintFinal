package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.ContactoDAO;
import com.example.demo.model.Contacto;

@Controller
@RequestMapping("/")
public class ContactoControl {
	private final ContactoDAO contactoDAO;
	
	@Autowired
	public ContactoControl(ContactoDAO contactoDAO) {
		this.contactoDAO = contactoDAO;
	}
	
	@GetMapping("/crearContacto")
	public String crearContacto(Model model) {
		model.addAttribute("contacto", new Contacto());
		return "contacto";
	}
	
    @PostMapping("/agregarContacto")
    public String agregarContacto(Contacto contacto) {
    	contactoDAO.save(contacto);
    	return "redirect:/listarContacto";
    }
    
    @GetMapping("/listarContacto")
	public String listarContacto(Model model) {
	  List<Contacto> listaContacto =  contactoDAO.findAll();
	  model.addAttribute("listaContacto", listaContacto);
      return "listarcontacto";
	}
}
