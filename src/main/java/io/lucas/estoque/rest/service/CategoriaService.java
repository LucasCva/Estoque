package io.lucas.estoque.rest.service;

import io.lucas.estoque.domain.model.Categoria;
import io.lucas.estoque.domain.repository.CategoriaRepository;
import org.hibernate.validator.internal.constraintvalidators.bv.AssertTrueValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> getAllCategoria(){
        return categoriaRepository.findAll();
    }

    public Categoria addCategoria(Categoria categoria){
       return categoriaRepository.save(categoria);
    }

    public Optional<List<Categoria>> removeCategoria(String nome) {
        Optional<List<Categoria>> categorias = categoriaRepository.findAllByNome(nome);
        categorias.ifPresent(categoriaRepository::deleteAll);
        return categorias;
    }
}
