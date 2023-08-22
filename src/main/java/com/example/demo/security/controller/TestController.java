package com.example.demo.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
@Controller
@RequestMapping("/api/otro")
public class TestController {

	@GetMapping("/all")
	public String allAccess() {
		return "crearcapacitacion";
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