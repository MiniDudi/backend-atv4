package com.example.ac2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.models.Animal;
import com.example.ac2.models.Prontuario;
import com.example.ac2.repositories.ProntuarioRepository;

import java.util.List;

@Service
public class ProntuarioServiceImpl implements ProntuarioService {

    private final ProntuarioRepository prontuarioRepository;
    private final AnimalService animalService;
    private final ConsultaService consultaService;
    private final VacinaService vacinaService;

    @Autowired
    public ProntuarioServiceImpl(ProntuarioRepository prontuarioRepository,
            AnimalService animalService,
            ConsultaService consultaService,
            VacinaService vacinaService) {
        this.prontuarioRepository = prontuarioRepository;
        this.animalService = animalService;
        this.consultaService = consultaService;
        this.vacinaService = vacinaService;
    }

    @Override
    public Prontuario salvar(Prontuario prontuario) {
        validarProntuario(prontuario);
        return prontuarioRepository.save(prontuario);
    }

    @Override
    public List<Prontuario> listarTodos() {
        return prontuarioRepository.findAll();
    }

    @Override
    public Prontuario buscarPorId(Long id) {
        return prontuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void deletar(Long id) {
        prontuarioRepository.deleteById(id);
    }

    @Override
    public Prontuario buscarPorAnimalId(Long animalId) {
        return prontuarioRepository.findByAnimalId(animalId);
    }

    private void validarProntuario(Prontuario prontuario) {
        if (prontuario.getAnimal() == null || prontuario.getAnimal().getId() == null) {
            throw new IllegalArgumentException("Animal é obrigatório");
        }

        Animal animal = animalService.buscarPorId(prontuario.getAnimal().getId());
        if (animal == null) {
            throw new IllegalArgumentException("Animal não encontrado");
        }

        prontuario.setConsultas(consultaService.listarPorAnimalId(animal.getId()));
        prontuario.setVacinas(vacinaService.listarPorAnimalId(animal.getId()));
    }
}
