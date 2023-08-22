package com.example.demo.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

	@GetMapping("/all")
	public String allAccess() {
		return "Contenido Publico.";
		
	}
	
	  @GetMapping("/cliente")
	  @PreAuthorize("hasRole('CLIENTE')")
	  public String clienteAccess() {
	    return "User Content.";
	  }
	

	  @GetMapping("/profesional")
	  @PreAuthorize("hasRole('PROFESIONAL')")
	  public String profesionalAccess() {
	    return "Profesional .";
	  }

	  @GetMapping("/administrativo")
	  @PreAuthorize("hasRole('ADMINISTRATIVO')")
	  public String administrativoAccess() {
	    return "Administrativo .";

}
	  
}