package br.com.flaviodev.livros.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.flaviodev.livros.model.Livro;




public interface LivroRepo extends CrudRepository<Livro,Integer>{
	
	public ArrayList<Livro> findByOrderByTitulo();

	public ArrayList<Livro> findByTituloContaining(String titulo);


}
