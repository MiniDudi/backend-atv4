package com.example.ac2.services;

import java.util.List;

import com.example.ac2.models.Prontuario;

public interface ProntuarioService {

    Prontuario salvar(Prontuario prontuario);

    List<Prontuario> listarTodos();

    Prontuario buscarPorId(Long id);

    void deletar(Long id);

    Prontuario buscarPorAnimalId(Long animalId);
}
