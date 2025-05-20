package com.example.ac2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.models.Veterinario;
import com.example.ac2.services.VeterinarioService;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {
    
    private final VeterinarioService veterinarioService;
    
    @Autowired
    public VeterinarioController(VeterinarioService veterinarioService) {
        this.veterinarioService = veterinarioService;
    }
    
    @PostMapping
    public ResponseEntity<Veterinario> salvar(@RequestBody Veterinario veterinario) {
        return new ResponseEntity<>(veterinarioService.salvar(veterinario), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Veterinario>> listarTodos() {
        return new ResponseEntity<>(veterinarioService.listarTodos(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Veterinario> buscarPorId(@PathVariable Long id) {
        return new ResponseEntity<>(veterinarioService.buscarPorId(id), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        veterinarioService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/especie/{especie}")
    public ResponseEntity<List<Veterinario>> listarPorEspecie(@PathVariable String especie) {
        return new ResponseEntity<>(veterinarioService.listarPorEspecie(especie), HttpStatus.OK);
    }
}
