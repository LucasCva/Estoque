package io.lucas.estoque.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Peca {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    private String codigo;

    @NotBlank
    private String nome;

    private String descricao;

    @NotBlank
    private String categoria;

    private Integer quantidade;

    private String dot; // Departamento de transporte


}
