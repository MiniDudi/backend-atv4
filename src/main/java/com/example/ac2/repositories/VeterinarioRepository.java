package com.example.ac2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ac2.models.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
    
    List<Veterinario> findByEspeciesAtendidas(String especie);
    
    Veterinario findByCrmv(String crmv);
    
    List<Veterinario> findByNomeContaining(String nome);
}