package com.example.ac2.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "prontuarios")
public class Prontuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @OneToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;
    
    @OneToMany(mappedBy = "prontuario", cascade = CascadeType.ALL)
    private List<Consulta> consultas;
    
    @OneToMany(mappedBy = "prontuario", cascade = CascadeType.ALL)
    private List<Vacina> vacinas;
    
    @PrePersist
    void createdAt() {
        this.createdAt = LocalDateTime.now();
    }
    
    @PreUpdate
    void updatedAt() {
        this.updatedAt = LocalDateTime.now();
    }
    
    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public Animal getAnimal() { return animal; }
    public void setAnimal(Animal animal) { this.animal = animal; }
    public List<Consulta> getConsultas() { return consultas; }
    public void setConsultas(List<Consulta> consultas) { this.consultas = consultas; }
    public List<Vacina> getVacinas() { return vacinas; }
    public void setVacinas(List<Vacina> vacinas) { this.vacinas = vacinas; }
}