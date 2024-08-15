package io.lucas.estoque.domain.repository;

import io.lucas.estoque.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    public Optional<List<Categoria>> findByNome(String nome);

    public Optional<List<Categoria>> findAllByNome(String nome);


}
