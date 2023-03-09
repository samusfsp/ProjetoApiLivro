package br.com.flaviodev.livros.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.flaviodev.livros.model.Livro;
import br.com.flaviodev.livros.repo.LivroRepo;

@RestController
public class LivroController {
	@Autowired
	private LivroRepo repo;

	@GetMapping("/livro")
	public ArrayList<Livro> recuperarTodos() {
		ArrayList<Livro> lista;
		lista = (ArrayList<Livro>) repo.findAll();
		// lista = (ArrayList<Livro>) repo.findByOrderByNome();
		return lista;

	}

	// busacr por codigo
	@GetMapping("/livro/{id}")
	public ResponseEntity<Livro>
	recuperarPorCodigo(@PathVariable int id) {
		Livro l = repo.findById(id).orElse(null);
		if (l != null) {
			return ResponseEntity.ok(l);
		}
		return ResponseEntity.notFound().build();

	}

	@GetMapping("/livro/busca")
	public ResponseEntity<?> buscarPorNome
	(@RequestParam(name = "palavra") String palavra) {
		ArrayList<Livro>
		lista = repo.findByTituloContaining(palavra);
		if (lista.size() > 0) {
			return ResponseEntity.ok(lista);
		}
		return ResponseEntity.notFound().build();

	}

	@PostMapping("/livro")
	public ResponseEntity<?> adicionarLivro
	(@RequestBody Livro novo) {
		Livro res = repo.save(novo);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}

}
