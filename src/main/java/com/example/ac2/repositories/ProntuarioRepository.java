package com.example.ac2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ac2.models.Prontuario;

@Repository
public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {
    
    Prontuario findByAnimalId(Long animalId);
    
    List<Prontuario> findByAnimalEspecie(Especie especie);
}