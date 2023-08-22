package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping("/listarPagos")
	public String listarPagos(Model model) {
	  List<Pagos> listarPagos =  pagosDAO.ListarPagos();
	  model.addAttribute("listarPagos", listarPagos);
      return "listarpagos";
	}
}
