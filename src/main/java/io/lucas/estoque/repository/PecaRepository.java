package io.lucas.estoque.repository;

import io.lucas.estoque.model.Peca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PecaRepository extends JpaRepository<Peca, Long> {
    public Peca findByCodigo(String codigo);

    public List<Peca> findByCategoria(String categoriaNome);
}
