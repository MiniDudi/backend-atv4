package com.example.ac2.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ac2.DTO.AnimalDTO;
import com.example.ac2.models.Animal;
import com.example.ac2.models.Tutor;
import com.example.ac2.services.AnimalService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/animais")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    public ResponseEntity<AnimalDTO> criar(@RequestBody AnimalDTO dto) {
        Animal animal = converterDTOParaEntidade(dto);
        Animal animalSalvo = animalService.salvar(animal);
        return ResponseEntity.status(201).body(converterEntidadeParaDTO(animalSalvo));
    }

    @GetMapping
    public ResponseEntity<List<AnimalDTO>> listarTodos() {
        List<Animal> animais = animalService.listarTodos();
        return ResponseEntity.ok(animais.stream()
                .map(this::converterEntidadeParaDTO)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalDTO> buscarPorId(@PathVariable Long id) {
        Animal animal = animalService.buscarPorId(id);
        if (animal != null) {
            return ResponseEntity.ok(converterEntidadeParaDTO(animal));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalDTO> atualizar(@PathVariable Long id,
            @RequestBody AnimalDTO dto) {
        Animal animalExistente = animalService.buscarPorId(id);
        if (animalExistente != null) {
            Animal animalAtualizado = converterDTOParaEntidade(dto);
            animalAtualizado.setId(id);
            Animal animalSalvo = animalService.salvar(animalAtualizado);
            return ResponseEntity.ok(converterEntidadeParaDTO(animalSalvo));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        animalService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    private AnimalDTO converterEntidadeParaDTO(Animal animal) {
        AnimalDTO dto = new AnimalDTO();
        dto.setId(animal.getId());
        dto.setNome(animal.getNome());
        dto.setEspecie(animal.getEspecie());
        dto.setRaca(animal.getRaca());
        dto.setDataNascimento(animal.getDataNascimento().toString());
        dto.setTutorId(animal.getTutor().getId());
        return dto;
    }

    private Animal converterDTOParaEntidade(AnimalDTO dto) {
        Animal animal = new Animal();
        animal.setNome(dto.getNome());
        animal.setEspecie(dto.getEspecie());
        animal.setRaca(dto.getRaca());
        animal.setDataNascimento(LocalDate.parse(dto.getDataNascimento()));

        Tutor tutor = new Tutor();
        tutor.setId(dto.getTutorId());
        animal.setTutor(tutor);

        return animal;
    }

}
