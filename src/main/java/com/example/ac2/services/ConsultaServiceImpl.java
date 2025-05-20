package com.example.ac2.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.models.Animal;
import com.example.ac2.models.Consulta;
import com.example.ac2.models.Veterinario;
import com.example.ac2.repositories.ConsultaRepository;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final AnimalService animalService;
    private final VeterinarioService veterinarioService;

    @Autowired
    public ConsultaServiceImpl(ConsultaRepository consultaRepository,
            AnimalService animalService,
            VeterinarioService veterinarioService) {
        this.consultaRepository = consultaRepository;
        this.animalService = animalService;
        this.veterinarioService = veterinarioService;
    }

    public Consulta salvar(Consulta consulta) {
        validarConsulta(consulta);
        return consultaRepository.save(consulta);
    }

    public List<Consulta> listarTodos() {
        return consultaRepository.findAll();
    }

    public Consulta buscarPorId(Long id) {
        return consultaRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        consultaRepository.deleteById(id);
    }

    public List<Consulta> listarPorData(LocalDateTime inicio, LocalDateTime fim) {
        return consultaRepository.findByDataHoraBetween(inicio, fim);
    }

    public List<Consulta> listarPorVeterinarioId(Long veterinarioId) {
        return consultaRepository.findByVeterinarioId(veterinarioId);
    }

    private void validarConsulta(Consulta consulta) {
        if (consulta.getDataHora() == null) {
            throw new IllegalArgumentException("Data e hora são obrigatórias");
        }
        if (consulta.getAnimal() == null || consulta.getAnimal().getId() == null) {
            throw new IllegalArgumentException("Animal é obrigatório");
        }
        if (consulta.getVeterinario() == null || consulta.getVeterinario().getId() == null) {
            throw new IllegalArgumentException("Veterinário é obrigatório");
        }

        Animal animal = animalService.buscarPorId(consulta.getAnimal().getId());
        if (animal == null) {
            throw new IllegalArgumentException("Animal não encontrado");
        }

        Veterinario veterinario = veterinarioService.buscarPorId(consulta.getVeterinario().getId());
        if (veterinario == null) {
            throw new IllegalArgumentException("Veterinário não encontrado");
        }

        if (!veterinario.getEspeciesAtendidas().contains(animal.getEspecie())) {
            throw new IllegalArgumentException("Veterinário não está habilitado para esta espécie");
        }

        if (consultaRepository.existsByVeterinarioIdAndDataHora(consulta.getVeterinario().getId(), consulta.getDataHora())) {
            throw new IllegalArgumentException("Veterinário já possui uma consulta marcada neste horário");
        }

    }

    @Override
    public List<Consulta> listarPorAnimalId(Long animalId) {
        return consultaRepository.findByAnimalId(animalId);
    }
}
