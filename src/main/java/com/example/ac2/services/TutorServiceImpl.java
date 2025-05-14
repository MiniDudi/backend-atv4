package com.example.ac2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.models.Tutor;
import com.example.ac2.repositories.TutorRepository;

@Service
public class TutorServiceImpl implements TutorService {

    private final TutorRepository tutorRepository;

    @Autowired
    public TutorServiceImpl(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @Override
    public Tutor salvar(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    @Override
    public List<Tutor> listarTodos() {
        return tutorRepository.findAll();
    }

    @Override
    public Tutor buscarPorId(Long id) {
        return tutorRepository.findById(id).orElse(null);
    }

    @Override
    public void deletar(Long id) {
        tutorRepository.deleteById(id);
    }

    @Override
    public Tutor buscarPorCpf(String cpf) {
        return tutorRepository.findByCpf(cpf);
    }
}
