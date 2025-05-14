package com.example.ac2.DTO;

import java.time.LocalDateTime;

public class ConsultaDTO {
    private Long id;
    private LocalDateTime dataHora;
    private String observacoes;
    private Long animalId;
    private Long veterinarioId;
    
    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
    public Long getAnimalId() { return animalId; }
    public void setAnimalId(Long animalId) { this.animalId = animalId; }
    public Long getVeterinarioId() { return veterinarioId; }
    public void setVeterinarioId(Long veterinarioId) { this.veterinarioId = veterinarioId; }
}