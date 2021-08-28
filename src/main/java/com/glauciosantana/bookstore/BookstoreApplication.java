package com.glauciosantana.bookstore;

import com.glauciosantana.bookstore.domain.Livro;
import com.glauciosantana.bookstore.domain.Categoria;
import com.glauciosantana.bookstore.repositories.CategoriaRepository;
import com.glauciosantana.bookstore.repositories.LivroRepository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria = new Categoria(null, "Informatica", "Livro de TI");
		Livro livro = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", categoria);

		categoria.getLivros().addAll(Arrays.asList(livro));

		this.categoriaRepository.saveAll(Arrays.asList(categoria));
		this.livroRepository.saveAll(Arrays.asList(livro));
	}
}
