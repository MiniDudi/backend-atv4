package com.example.ac2.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.models.Animal;
import com.example.ac2.models.Vacina;
import com.example.ac2.repositories.VacinaRepository;

@Service
public class VacinaServiceImpl implements VacinaService {

    private final VacinaRepository vacinaRepository;
    private final AnimalService animalService;

    @Autowired
    public VacinaServiceImpl(VacinaRepository vacinaRepository, AnimalService animalService) {
        this.vacinaRepository = vacinaRepository;
        this.animalService = animalService;
    }

    @Override
    public Vacina salvar(Vacina vacina) {
        validarVacina(vacina);
        return vacinaRepository.save(vacina);
    }

    @Override
    public List<Vacina> listarTodos() {
        return vacinaRepository.findAll();
    }

    @Override
    public Vacina buscarPorId(Long id) {
        return vacinaRepository.findById(id).orElse(null);
    }

    @Override
    public void deletar(Long id) {
        vacinaRepository.deleteById(id);
    }

    @Override
    public List<Vacina> listarPorAnimalId(Long animalId) {
        return vacinaRepository.findByAnimalId(animalId);
    }

    @Override
    public List<Vacina> listarVacinacaoVencida(LocalDate data) {
        return vacinaRepository.findByProximaDoseLessThanEqual(data);
    }

    private void validarVacina(Vacina vacina) {
        if (vacina.getNome() == null || vacina.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome da vacina é obrigatório");
        }
        if (vacina.getDataAplicacao() == null) {
            throw new IllegalArgumentException("Data de aplicação é obrigatória");
        }
        if (vacina.getAnimal() == null || vacina.getAnimal().getId() == null) {
            throw new IllegalArgumentException("Animal é obrigatório");
        }

        Animal animal = animalService.buscarPorId(vacina.getAnimal().getId());
        if (animal == null) {
            throw new IllegalArgumentException("Animal não encontrado");
        }
    }
}
