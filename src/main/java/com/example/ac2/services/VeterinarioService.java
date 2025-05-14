package com.example.ac2.services;

import java.util.List;

import com.example.ac2.models.Veterinario;

public interface VeterinarioService {

    Veterinario salvar(Veterinario veterinario);

    List<Veterinario> listarTodos();

    Veterinario buscarPorId(Long id);

    void deletar(Long id);

    List<Veterinario> listarPorEspecie(String especie);
}
