package com.example.ac2.services;

import java.time.LocalDateTime;
import java.util.List;

import com.example.ac2.models.Consulta;

public interface ConsultaService {

    Consulta salvar(Consulta consulta);

    List<Consulta> listarTodos();

    Consulta buscarPorId(Long id);

    void deletar(Long id);

    List<Consulta> listarPorData(LocalDateTime inicio, LocalDateTime fim);

    List<Consulta> listarPorVeterinarioId(Long veterinarioId);

    public List<Consulta> listarPorAnimalId(Long id);
}
