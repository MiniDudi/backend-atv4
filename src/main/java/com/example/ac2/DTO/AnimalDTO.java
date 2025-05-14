package com.example.ac2.DTO;

import com.example.ac2.enums.Especie;

public class AnimalDTO {
    private Long id;
    private String nome;
    private Especie especie;
    private String raca;
    private String dataNascimento;
    private Long tutorId;
    
    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Especie getEspecie() { return especie; }
    public void setEspecie(Especie especie) { this.especie = especie; }
    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }
    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }
    public Long getTutorId() { return tutorId; }
    public void setTutorId(Long tutorId) { this.tutorId = tutorId; }
}