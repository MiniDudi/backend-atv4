package com.example.ac2.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.example.ac2.enums.Especie;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "veterinarios")
public class Veterinario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    private String nome;
    
    @Column(unique = true)
    private String crmv;
    
    @ManyToMany
    @JoinTable(
        name = "veterinarios_especies",
        joinColumns = @JoinColumn(name = "veterinario_id"),
        inverseJoinColumns = @JoinColumn(name = "especie")
    )
    private Set<Especie> especiesAtendidas;
    
    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL)
    private List<Consulta> consultas;
    
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
    public String getCrmv() { return crmv; }
    public void setCrmv(String crmv) { this.crmv = crmv; }
    public Set<Especie> getEspeciesAtendidas() { return especiesAtendidas; }
    public void setEspeciesAtendidas(Set<Especie> especiesAtendidas) { this.especiesAtendidas = especiesAtendidas; }
    public List<Consulta> getConsultas() { return consultas; }
    public void setConsultas(List<Consulta> consultas) { this.consultas = consultas; }
}