package io.lucas.estoque.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PecaDTO {
    private String codigo;
    private String nome;
    private String descricao;
    private String categoria;
    private Integer quantidade;
    private String dot;
}
