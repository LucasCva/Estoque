package io.lucas.estoque.rest.controller;

import io.lucas.estoque.domain.model.Categoria;
import io.lucas.estoque.exception.RegraNegocioException;
import io.lucas.estoque.rest.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
   public ResponseEntity<Void> deletarCategoria(@PathVariable String nome){
       List<Categoria> categorias = service
               .removeCategoria(nome)
               .orElseThrow(() -> new RegraNegocioException("Não foi possível localizar a categoria"));
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
}
