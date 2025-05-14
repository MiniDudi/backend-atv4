package com.example.ac2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ac2.models.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    
    List<Animal> findByTutorCpf(String cpf);
    
    List<Animal> findByEspecie(Especie especie);
    
    List<Animal> findByNomeContainingAndEspecie(String nome, Especie especie);

    public List<Animal> findByTutorId(Long tutorId);
}