package io.lucas.estoque.rest.controller;

import io.lucas.estoque.domain.model.Peca;
import io.lucas.estoque.rest.service.PecaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/pecas/")
public class PecaController {

    private final PecaService pecaService;

    @Autowired
    public PecaController(PecaService pecaService) {
        this.pecaService = pecaService;
    }

    @PostMapping
    public ResponseEntity<Peca> addPeca(@RequestBody @Valid Peca peca) {
        Peca pecaNova = pecaService.addPeca(peca);
        return new ResponseEntity<>(pecaNova, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Peca>> getAllPecas(){
        List<Peca> pecas = pecaService.getAllPecas();
        return new ResponseEntity<>(pecas, HttpStatus.OK);
    }

    @GetMapping("/{categoria_name}")
    public ResponseEntity<List<Peca>> getPecaByCategoria(@PathVariable String categoria_name){
        List<Peca> pecas = pecaService.getPecaByCategoria(categoria_name);
        return new ResponseEntity<>(pecas, HttpStatus.OK);
    }

    @GetMapping("{categoria_name}/categoria/count/")
    public ResponseEntity<Integer> getNumberPecaByCategoria(@PathVariable String categoria_name){
        List<Peca> pecas = pecaService.getPecaByCategoria(categoria_name);
        int quantidade = pecas.size();
        System.out.println(quantidade);
        return new ResponseEntity<>(quantidade, HttpStatus.OK);
    }

    @PutMapping("/{codigo}/{quantidade}")
    public ResponseEntity<Peca> updateQuantidadePeca(@PathVariable String codigo, @PathVariable int quantidade) {
        Peca peca = pecaService.atualizarQuantidade(codigo, quantidade);
        return new ResponseEntity<>(peca, HttpStatus.OK);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Peca> deletePeca(@PathVariable String codigo) {
        Peca peca = pecaService.deletePeca(codigo);
        return new ResponseEntity<>(peca, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/categoria/{nome}")
    public ResponseEntity<List<Peca>> deletePecaByCategoria(@PathVariable String nome){
        List<Peca> pecas = pecaService.deletePecaByCategoria(nome);
        return new ResponseEntity<>(pecas, HttpStatus.NO_CONTENT);
    }

}
