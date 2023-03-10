package br.com.flaviodev.livros.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoasVindasConreoller {
	
	@GetMapping("/")
	public String BoasVindas() {
		return "<pre>"
				
				+ "Bem vindo a minha API de livros<br/>"
				+ "Endpoints Disponiveis<br/>"
				+ "/livro get<br/>"
				+ "/livros/id por id<br/>";
				
	}
	
	
}
