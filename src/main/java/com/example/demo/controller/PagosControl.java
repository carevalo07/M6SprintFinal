package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.PagosDAO;
import com.example.demo.model.Capacitaciones;
import com.example.demo.model.Pagos;

@Controller
@RequestMapping("/")
public class PagosControl {
	private final PagosDAO pagosDAO;  
  
    @Autowired	
	public PagosControl(PagosDAO pagosDAO) {   
		this.pagosDAO = pagosDAO; 
	}

    @GetMapping("/crearPagos")
    public String crearPagos(Model model) {
    	model.addAttribute("pagos", new Pagos());
    	return "crearpago";
    }
    
    @PostMapping("/agregarPagos")
    public String agregarPagos(Pagos pagos) {
    	pagosDAO.save(pagos);
    	return "redirect:/listarPagos";
    }
    
    @GetMapping("/buscarPag")
    public String buscarPag() {
    	return "buscarpago";
    }
    
    @GetMapping("/buscarPago")
	public String buscarPago(Long id, Model model) {
    	
	  Optional<Pagos>pago = pagosDAO.findById(id);
	  
	  if(pago.isPresent()) {
		  model.addAttribute("pago", pago.get());
		  return "editarpago";
	  }else {
		  model.addAttribute("pago", new Pagos());
		  return "editarpago";
	  }
	}
    
    
    @PostMapping("/actualizarPagos")
    public String actualizarPagos(Pagos pagos) {
    	    
    	pagosDAO.actualizar(pagos.getCliente_id(),pagos.getMonto(),pagos.getFecha_pago(), pagos.getId());
    	return "redirect:/listarPagos";
    }

	@GetMapping("/listarPagos")
	public String listarPagos(Model model) {
	  List<Pagos> listarPagos =  pagosDAO.findAll();
	  model.addAttribute("listarPagos", listarPagos);
      return "listarpagos";
	}
  
 
  
    
}
