package com.example.ac2.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ac2.models.Vacina;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long> {
    
    List<Vacina> findByAnimalId(Long animalId);
    
    List<Vacina> findByDataAplicacaoBetween(LocalDate inicio, LocalDate fim);
    
    List<Vacina> findByProximaDoseLessThanEqual(LocalDate data);
}