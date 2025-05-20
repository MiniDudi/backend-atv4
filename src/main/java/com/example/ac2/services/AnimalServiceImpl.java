package com.example.ac2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.models.Animal;
import com.example.ac2.models.Tutor;
import com.example.ac2.repositories.AnimalRepository;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;
    private final TutorService tutorService;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository, TutorService tutorService) {
        this.animalRepository = animalRepository;
        this.tutorService = tutorService;
    }

    @Override
    public Animal salvar(Animal animal) {
        validarAnimal(animal);
        return animalRepository.save(animal);
    }

    @Override
    public List<Animal> listarTodos() {
        return animalRepository.findAll();
    }

    @Override
    public Animal buscarPorId(Long id) {
        return animalRepository.findById(id).orElse(null);
    }

    @Override
    public void deletar(Long id) {
        animalRepository.deleteById(id);
    }

    @Override
    public List<Animal> listarPorTutorId(Long tutorId) {
        return animalRepository.findByTutorId(tutorId);
    }

private void validarAnimal(Animal animal) {
    if (animal.getEspecie() == null) {
        throw new IllegalArgumentException("Espécie é obrigatória");
    }

    if (animal.getTutor() == null || animal.getTutor().getId() == null) {
        throw new IllegalArgumentException("Tutor é obrigatório");
    }

    Tutor tutor = tutorService.buscarPorId(animal.getTutor().getId());
    if (tutor == null) {
        throw new IllegalArgumentException("Tutor não encontrado");
    }
}

}
