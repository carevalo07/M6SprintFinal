package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/crearCapacitacion")
    public String crearCapacitacion(Model model) {
    	model.addAttribute("capacitacion", new Capacitaciones());
    	return "crearcapacitacion";
    }
    
    @PostMapping("/agregarCapacitaciones")
    public String agregarCapacitaciones(Capacitaciones capacitaciones) {
    	capacitacionesDAO.save(capacitaciones);
    	return "redirect:/listarCapacitaciones";
    }
    
    @PostMapping("/actualizarCapacitaciones")
    public void actualizarCapacitacion(Capacitaciones capacitaciones) {
    	capacitacionesDAO.save(capacitaciones);
    }
    
	@GetMapping("/listarCapacitaciones")
	public String listarCapacitaciones(Model model) {
	  List<Capacitaciones> listaCapacitaciones =  capacitacionesDAO.findAll();
	  model.addAttribute("listaCapacitaciones", listaCapacitaciones);
      return "listarcapacitaciones";
	}
  
    @GetMapping("/all")    
    public String all( ) {
      return "index";	
    }
 
}
