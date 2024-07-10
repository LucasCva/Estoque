package io.lucas.estoque.repository;

import io.lucas.estoque.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    public Categoria findByNome(String nome);



}
