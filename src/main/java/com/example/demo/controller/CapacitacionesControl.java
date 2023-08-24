package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
    
    @GetMapping("/buscarCapa")
    public String buscarCapa() {
    	//model.addAttribute("capacitacion", new Capacitaciones());
    	return "buscarcapacitacion";
    }
    
    @GetMapping("/buscarCapacitacion")
	public String buscarCapacitacion(Long id, Model model) {
    	
	  Optional<Capacitaciones>capacitacion = capacitacionesDAO.findById(id);
	  
	  if(capacitacion.isPresent()) {
		  model.addAttribute("capacitacion", capacitacion.get());
		  return "editarcapacitacion";
	  }else {
		  model.addAttribute("capacitacion", new Capacitaciones());
		  return "editarcapacitacion";
	  }
	}
    
    
    @PostMapping("/actualizarCapacitaciones")
    public String actualizarCapacitacion(Capacitaciones capacitaciones) {
    	    
    	capacitacionesDAO.actualizar(capacitaciones.getNombre(),capacitaciones.getDetalle(),capacitaciones.getId());
    	return "redirect:/listarCapacitaciones";
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
