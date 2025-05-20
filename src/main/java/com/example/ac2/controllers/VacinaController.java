package com.example.ac2.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.models.Vacina;
import com.example.ac2.services.VacinaService;

@RestController
public class VacinaController {

    private final VacinaService vacinaService;

    @Autowired
    public VacinaController(VacinaService vacinaService) {
        this.vacinaService = vacinaService;
    }

    @GetMapping("/vacinacao")
    public List<Vacina> listarTodos() {
        return vacinaService.listarTodos();
    }

    @GetMapping("/vacinacao/{id}")
    public Vacina buscarPorId(@PathVariable Long id) {
        return vacinaService.buscarPorId(id);
    }

    @PostMapping("/vacinacao")
    public Vacina salvar(@RequestBody Vacina vacina) {
        return vacinaService.salvar(vacina);
    }

    @DeleteMapping("/vacinacao/{id}")
    public void deletar(@PathVariable Long id) {
        vacinaService.deletar(id);
    }

    @GetMapping("/vacinacao/animal/{animalId}")
    public List<Vacina> listarPorAnimalId(@PathVariable Long animalId) {
        return vacinaService.listarPorAnimalId(animalId);
    }

    @GetMapping("/vacinacao/vencida/{data}")
    public List<Vacina> listarVacinacaoVencida(@PathVariable LocalDate data) {
        return vacinaService.listarVacinacaoVencida(data);
    }
}

