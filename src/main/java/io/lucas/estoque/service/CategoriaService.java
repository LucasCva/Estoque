package io.lucas.estoque.service;

import io.lucas.estoque.model.Categoria;
import io.lucas.estoque.repository.CategoriaRepository;
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

    public Categoria removeCategoria(String nome){
        Categoria categoriaAtual = categoriaRepository.findByNome(nome);
        categoriaRepository.delete(categoriaAtual);
        return categoriaAtual;
    }
}
