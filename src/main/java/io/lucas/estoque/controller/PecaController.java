package io.lucas.estoque.controller;

import io.lucas.estoque.model.Peca;
import io.lucas.estoque.service.PecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pecas")
public class PecaController {

    private final PecaService pecaService;

    @Autowired
    public PecaController(PecaService pecaService) {
        this.pecaService = pecaService;
    }

    @PostMapping
    public ResponseEntity<Peca> addPeca(@RequestBody Peca peca) {
        Peca pecaNova = pecaService.addPeca(peca);
        return new ResponseEntity<>(pecaNova, HttpStatus.CREATED);
    }

    @GetMapping()
    @ResponseBody
    public ResponseEntity<List<Peca>> getAllPecas(){
        List<Peca> pecas = pecaService.getAllPecas();
        return new ResponseEntity<>(pecas, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Peca> getPecaByCodigo(@RequestBody @PathVariable String codigo) {
        Peca peca = pecaService.getPecaByCodigo(codigo);
        return new ResponseEntity<>(peca, HttpStatus.OK);
    }

    @PutMapping("/{codigo}/{quantidade}")
    public ResponseEntity<Peca> updateQuantidadePeca(@RequestBody @PathVariable String codigo, @RequestBody @PathVariable int quantidade) {
        Peca peca = pecaService.atualizarQuantidade(codigo, quantidade);
        return new ResponseEntity<>(peca, HttpStatus.OK);
    }

    @DeleteMapping("/categoria/{nome}")
    public ResponseEntity<List<Peca>> deletePecaByCategoria(@PathVariable String nome){
        List<Peca> pecas = pecaService.deletePecaByCategoria(nome);
        return new ResponseEntity<>(pecas, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Peca> deletePeca(@PathVariable String codigo) {
        Peca peca = pecaService.deletePeca(codigo);
        return new ResponseEntity<>(peca, HttpStatus.NO_CONTENT);
    }
}
