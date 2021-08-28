package com.glauciosantana.bookstore.services;

import com.glauciosantana.bookstore.domain.Categoria;
import com.glauciosantana.bookstore.domain.Livro;
import com.glauciosantana.bookstore.repositories.CategoriaRepository;
import com.glauciosantana.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    LivroRepository livroRepository;

    public void instanciaBaseDeDados() {
        Categoria categoria1 = new Categoria(null, "Informatica", "Livro de TI");
        Categoria categoria2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
        Categoria categoria3 = new Categoria(null, "Biografias", "Livros de Biografia");


        Livro livro1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", categoria1);
        Livro livro2 = new Livro(null, "Engenharia de Software", "Louis V. Gertner", "Lorem Ipsum", categoria1);
        Livro livro3 = new Livro(null, "The Time Machine", "H.G. Wells", "Lorem Ipsum", categoria2);
        Livro livro4 = new Livro(null, "The War of the Worlds", "H.G. Wells", "Lorem Ipsum", categoria2);
        Livro livro5 = new Livro(null, "I, Robot", "Isaac Asmov", "Lorem Ipsum", categoria2);

        categoria1.getLivros().addAll(Arrays.asList(livro1, livro2));
        categoria2.getLivros().addAll(Arrays.asList(livro3, livro4, livro5));

        this.categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3));
        this.livroRepository.saveAll(Arrays.asList(livro1, livro2, livro3, livro4, livro5));
    }
}
