package com.example.ac2.services;

import java.util.List;

import com.example.ac2.models.Tutor;

public interface TutorService {

    Tutor salvar(Tutor tutor);

    List<Tutor> listarTodos();

    Tutor buscarPorId(Long id);

    void deletar(Long id);

    Tutor buscarPorCpf(String cpf);
}
