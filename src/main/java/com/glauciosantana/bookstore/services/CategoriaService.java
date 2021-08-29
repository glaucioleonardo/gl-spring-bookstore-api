package com.glauciosantana.bookstore.services;

import com.glauciosantana.bookstore.domain.Categoria;
import com.glauciosantana.bookstore.dtos.CategoriaDTO;
import com.glauciosantana.bookstore.repositories.CategoriaRepository;
import com.glauciosantana.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: " + id + ", Tipo: " + Categoria.class.getName()
        ));
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria create(Categoria obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Integer id, CategoriaDTO ojbDTO) {
        Categoria obj = findById(id);
        obj.setNome(obj.getNome());
        obj.setDescricao(obj.getDescricao());

        return repository.save(obj);
    }
}
