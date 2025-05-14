package com.example.ac2.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "vacinas")
public class Vacina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    private String nome;
    
    private LocalDate dataAplicacao;
    
    private LocalDate proximaDose;
    
    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;
    
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
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public LocalDate getDataAplicacao() { return dataAplicacao; }
    public void setDataAplicacao(LocalDate dataAplicacao) { this.dataAplicacao = dataAplicacao; }
    public LocalDate getProximaDose() { return proximaDose; }
    public void setProximaDose(LocalDate proximaDose) { this.proximaDose = proximaDose; }
    public Animal getAnimal() { return animal; }
    public void setAnimal(Animal animal) { this.animal = animal; }
}