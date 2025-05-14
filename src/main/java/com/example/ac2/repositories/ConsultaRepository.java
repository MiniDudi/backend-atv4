package com.example.ac2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ac2.models.Consulta;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    
    List<Consulta> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);
    
    List<Consulta> findByAnimalId(Long animalId);
    
    List<Consulta> findByVeterinarioId(Long veterinarioId);
    
    List<Consulta> findByDataHoraGreaterThanEqualAndDataHoraLessThanEqual(
            LocalDateTime inicio, LocalDateTime fim);
}