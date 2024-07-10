package io.lucas.estoque.controller;

import io.lucas.estoque.model.Categoria;
import io.lucas.estoque.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/categoria")
public class CategoriaController {

   private final CategoriaService service;

   @Autowired
   public CategoriaController(CategoriaService service) {
       this.service = service;
   }

   @GetMapping
   public ResponseEntity<List<Categoria>> getAllCategoria(){
       List<Categoria> categorias = service.getAllCategoria();
       return new ResponseEntity<>(categorias, HttpStatus.OK);
   }

   @PostMapping
   public ResponseEntity<Categoria> cadastrarCategoria(@Valid @RequestBody Categoria categoria) {
       Categoria categoriaNova = service.addCategoria(categoria);
        return new ResponseEntity<>(categoriaNova, HttpStatus.CREATED);
   }

   @DeleteMapping("/{nome}")
   public ResponseEntity<Categoria> deletarCategoria(@RequestBody @PathVariable String nome){
       service.removeCategoria(nome);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
}
