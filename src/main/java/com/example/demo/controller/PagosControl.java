package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.PagosDAO;
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

	@GetMapping("/listarPagos")
	public String listarPagos(Model model) {
	  List<Pagos> listarPagos =  pagosDAO.findAll();
	  model.addAttribute("listarPagos", listarPagos);
      return "listarpagos";
	}
  
    @GetMapping("/all2")    
    public String all( ) {
      return "index";	
    }
 
  
    
}
