package com.example.ac2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ac2.models.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
    
    List<Tutor> findByNomeContaining(String nome);
    
    Tutor findByCpf(String cpf);
    
    List<Tutor> findByEnderecoCidade(String cidade);
}