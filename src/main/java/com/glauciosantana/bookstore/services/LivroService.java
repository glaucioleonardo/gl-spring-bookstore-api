package com.glauciosantana.bookstore.services;

import com.glauciosantana.bookstore.domain.Livro;
import com.glauciosantana.bookstore.repositories.LivroRepository;
import com.glauciosantana.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public Livro findById(Integer id) {
        Optional<Livro> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Tipo: " + Livro.class.getName()));
    }
}
