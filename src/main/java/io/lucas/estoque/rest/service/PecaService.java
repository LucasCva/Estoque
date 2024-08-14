package io.lucas.estoque.rest.service;

import io.lucas.estoque.domain.model.Peca;
import io.lucas.estoque.domain.repository.PecaRepository;
import io.lucas.estoque.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Service
public class PecaService {

    PecaRepository repository;

    // injetando dependecia pelo contrutor
    @Autowired
    public PecaService(PecaRepository repository) {
        this.repository = repository;
    }

    // TODO: CRIAR EXCEPTIONS PARA ERROS!!

    // add item peça
    public Peca addPeca(Peca peca) {
        return repository.save(peca);
    }

    public List<Peca> getAllPecas(){
        return repository.findAll();
    }

    // get item by id
    public Peca getPecaByCodigo(String codigo) {
        Peca peca = repository.findByCodigo(codigo);
        if (peca == null){
            throw new NotFoundException("Peça não encontrada: " + codigo);
        }
        return peca;
    }

    public List<Peca> getPecaByCategoria(String name_categoria){
        return repository.findByCategoria(name_categoria);
    }

    // updates the quantity in stock
    public Peca atualizarQuantidade(String codigo, int quantidade) {
        Peca pecaAtual = repository.findByCodigo(codigo);
        pecaAtual.setQuantidade(quantidade);
        return repository.save(pecaAtual);
    }

    // item delete
    public Peca deletePeca(String codigo) {
        Peca pecaAtual = repository.findByCodigo(codigo);
        repository.delete(pecaAtual);
        return pecaAtual;
    }

    public List<Peca> deletePecaByCategoria(String categoriaNome){
        List<Peca> pecas = repository.findByCategoria(categoriaNome);
        repository.deleteAll(pecas);
        return pecas;
    }
}
