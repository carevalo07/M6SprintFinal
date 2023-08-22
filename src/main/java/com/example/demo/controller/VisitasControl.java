package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.VisitasDAO;
import com.example.demo.model.Capacitaciones;
import com.example.demo.model.Visitas;

@Controller
@RequestMapping("/")
public class VisitasControl {
  private final VisitasDAO visitasDAO;
 
  @Autowired  
  public VisitasControl(VisitasDAO visitasDAO) {
	  this.visitasDAO  = visitasDAO;
  }
  
  @GetMapping("/listarVisitas")
	public String listarVisitas(Model model) {
	  List<Visitas> listarVisitas =  visitasDAO.ListarVisitas();
	  model.addAttribute("listarVisitas", listarVisitas);
    return "listarvisitas";
	} 
  
}
