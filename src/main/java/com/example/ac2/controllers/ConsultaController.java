package com.example.ac2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ac2.DTO.ConsultaDTO;
import com.example.ac2.models.Consulta;
import com.example.ac2.services.ConsultaService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/consultas")
public class ConsultaController {
    
    private final ConsultaService consultaService;
    
    @Autowired
    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }
    
    @PostMapping
    public ResponseEntity<ConsultaDTO> criar(@RequestBody ConsultaDTO dto) {
        Consulta consulta = converterDTOParaEntidade(dto);
        Consulta consultaSalva = consultaService.salvar(consulta);
        return ResponseEntity.status(201).body(converterEntidadeParaDTO(consultaSalva));
    }
    
    @GetMapping
    public ResponseEntity<List<ConsultaDTO>> listarTodos() {
        List<Consulta> consultas = consultaService.listarTodos();
        return ResponseEntity.ok(consultas.stream()
                .map(this::converterEntidadeParaDTO)
                .toList());
    }
    
    @GetMapping("/data")
    public ResponseEntity<List<ConsultaDTO>> listarPorData(
            @RequestParam("inicio") LocalDateTime inicio,
            @RequestParam("fim") LocalDateTime fim) {
        List<Consulta> consultas = consultaService.listarPorData(inicio, fim);
        return ResponseEntity.ok(consultas.stream()
                .map(this::converterEntidadeParaDTO)
                .toList());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> buscarPorId(@PathVariable Long id) {
        Consulta consulta = consultaService.buscarPorId(id);
        if (consulta != null) {
            return ResponseEntity.ok(converterEntidadeParaDTO(consulta));
        }
        return ResponseEntity.notFound().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ConsultaDTO> atualizar(@PathVariable Long id,
                                               @RequestBody ConsultaDTO dto) {
        Consulta consultaExistente = consultaService.buscarPorId(id);
        if (consultaExistente != null) {
            Consulta consultaAtualizada = converterDTOParaEntidade(dto);
            consultaAtualizada.setId(id);
            Consulta consultaSalva = consultaService.salvar(consultaAtualizada);
            return ResponseEntity.ok(converterEntidadeParaDTO(consultaSalva));
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        consultaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    
    private ConsultaDTO converterEntidadeParaDTO(Consulta consulta) {
        ConsultaDTO dto = new ConsultaDTO();
        dto.setId(consulta.getId());
        dto.setDataHora(consulta.getDataHora());
        dto.setObservacoes(consulta.getObservacoes());
        dto.setAnimalId(consulta.getAnimal().getId());
        dto.setVeterinarioId(consulta.getVeterinario().getId());
        return dto;
    }
    
    private Consulta converterDTOParaEntidade(ConsultaDTO dto) {
        Consulta consulta = new Consulta();
        consulta.setDataHora(dto.getDataHora());
        consulta.setObservacoes(dto.getObservacoes());
        return consulta;
    }
}