package com.example.ac2.services;

import java.util.List;

import com.example.ac2.models.Animal;

public interface AnimalService {

    Animal salvar(Animal animal);

    List<Animal> listarTodos();

    Animal buscarPorId(Long id);

    void deletar(Long id);

    List<Animal> listarPorTutorId(Long tutorId);
}
