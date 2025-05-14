package com.example.ac2.services;

import java.time.LocalDate;
import java.util.List;

import com.example.ac2.models.Vacina;

public interface VacinaService {

    Vacina salvar(Vacina vacina);

    List<Vacina> listarTodos();

    Vacina buscarPorId(Long id);

    void deletar(Long id);

    List<Vacina> listarPorAnimalId(Long animalId);

    List<Vacina> listarVacinacaoVencida(LocalDate data);
}
