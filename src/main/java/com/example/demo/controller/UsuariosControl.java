package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.UsuariosDAO;
import com.example.demo.model.Usuarios;

@Controller
@RequestMapping("/")
public class UsuariosControl {
 private final UsuariosDAO usuariosDAO;  
 
 public UsuariosControl(UsuariosDAO usuariosDAO) {
	 this.usuariosDAO = usuariosDAO; 
 }

 	@GetMapping("/listarUsuarios")
	public String listarUsuarios(Model model) {
	  List<Usuarios> listaUsuarios =  usuariosDAO.ListarUsuarios();
	  model.addAttribute("listaUsuarios", listaUsuarios);
      return "listarcapacitaciones";
	}
 
 
 
}
