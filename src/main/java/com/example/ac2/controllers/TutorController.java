package com.example.ac2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.models.Tutor;
import com.example.ac2.services.TutorService;

@RestController
@RequestMapping("/tutores")
public class TutorController {
    
    private final TutorService tutorService;
    
    @Autowired
    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }
    
    @PostMapping
    public Tutor salvar(@RequestBody Tutor tutor) {
        return tutorService.salvar(tutor);
    }
    
    @GetMapping
    public List<Tutor> listarTodos() {
        return tutorService.listarTodos();
    }
    
    @GetMapping("/{id}")
    public Tutor buscarPorId(@PathVariable Long id) {
        return tutorService.buscarPorId(id);
    }
    
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        tutorService.deletar(id);
    }
    
    @GetMapping("/cpf/{cpf}")
    public Tutor buscarPorCpf(@PathVariable String cpf) {
        return tutorService.buscarPorCpf(cpf);
    }
}

