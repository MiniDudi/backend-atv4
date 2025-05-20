package com.example.ac2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.enums.Especie;
import com.example.ac2.models.Veterinario;
import com.example.ac2.repositories.VeterinarioRepository;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    @Autowired
    public VeterinarioServiceImpl(VeterinarioRepository veterinarioRepository) {
        this.veterinarioRepository = veterinarioRepository;
    }

    @Override
    public Veterinario salvar(Veterinario veterinario) {
        validarVeterinario(veterinario);
        return veterinarioRepository.save(veterinario);
    }

    @Override
    public List<Veterinario> listarTodos() {
        return veterinarioRepository.findAll();
    }

    @Override
    public Veterinario buscarPorId(Long id) {
        return veterinarioRepository.findById(id).orElse(null);
    }

    @Override
    public void deletar(Long id) {
        veterinarioRepository.deleteById(id);
    }

    @Override
    public List<Veterinario> listarPorEspecie(String especieString) {
        Especie especieEnum;
        try {
            especieEnum = Especie.valueOf(especieString.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Espécie inválida: " + especieString);
        }

        return veterinarioRepository.findByEspeciesAtendidas(especieEnum);
    }

    private void validarVeterinario(Veterinario veterinario) {
        if (veterinario.getCrmv() == null || veterinario.getCrmv().isEmpty()) {
            throw new IllegalArgumentException("CRMV é obrigatório");
        }
        if (veterinario.getEspeciesAtendidas() == null || veterinario.getEspeciesAtendidas().isEmpty()) {
            throw new IllegalArgumentException("Pelo menos uma espécie deve ser informada");
        }
    }
}
