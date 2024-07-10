package io.lucas.estoque.service;

import io.lucas.estoque.model.Peca;
import io.lucas.estoque.repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return repository.findByCodigo(codigo);
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
