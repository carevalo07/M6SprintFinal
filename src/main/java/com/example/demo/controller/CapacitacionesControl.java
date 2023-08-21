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

import com.example.demo.dao.CapacitacionesDAO;
import com.example.demo.model.Capacitaciones;

@Controller
@RequestMapping("/")
public class CapacitacionesControl {
	private final CapacitacionesDAO capacitacionesDAO;
  
    @Autowired	
	public CapacitacionesControl(CapacitacionesDAO capacitacionesDAO) {
		this.capacitacionesDAO = capacitacionesDAO;
	}

    @PostMapping("/add") 
    public String addCapacitaciones(@Validated Capacitaciones capacitaciones) {
       capacitacionesDAO.addCapacitaciones(capacitaciones);	
       return "redirect:/listarCapacitaciones";
    }

    @PutMapping("/update/{id}")
    public long updateCapacitaciones(@Validated @RequestBody Capacitaciones capacitaciones,
    		                         @PathVariable("id") long id) {
     return capacitacionesDAO.updateCapacitaciones(id, capacitaciones);	
    }
    
	@GetMapping("/find/{id}")
	public Capacitaciones findById(@PathVariable ("id") long id) {
		return capacitacionesDAO.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));
	}

	@GetMapping("/listarCapacitaciones")
	public String listarCapacitaciones(Model model) {
	  List<Capacitaciones> listaCapacitaciones =  capacitacionesDAO.ListarCapacitaciones();
	  model.addAttribute("listaCapacitaciones", listaCapacitaciones);
      return "listarcapacitaciones";
	}
   
    @GetMapping("/crearCapacitacion")
	public String crearCapacitaciones(Model model) {
      model.addAttribute("capacitacion", new Capacitaciones());
      return "crearcapacitacion";
	}

    
  
    
}
