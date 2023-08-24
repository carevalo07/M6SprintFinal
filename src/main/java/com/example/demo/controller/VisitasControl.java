package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.VisitasDAO;
import com.example.demo.model.Visitas;

@Controller
@RequestMapping("/")
public class VisitasControl {
	private final VisitasDAO visitasDAO;
  
    @Autowired	
	public VisitasControl(VisitasDAO visitasDAO) {
		this.visitasDAO = visitasDAO;
	}

    @GetMapping("/crearVisita")
    public String crearVisita(Model model) {
    	model.addAttribute("visita", new Visitas());
    	return "crearvisita";
    }
    
    @PostMapping("/agregarVisitas")
    public String agregarVisitas(Visitas visitas) {
    	visitasDAO.save(visitas);
    	return "redirect:/listarVisitas";
    }

	@GetMapping("/listarVisitas")
	public String listarVisitas(Model model) {
	  List<Visitas> listarVisitas =  visitasDAO.findAll();
	  model.addAttribute("listarVisitas", listarVisitas);
      return "listarvisitas";
	}
  
}
