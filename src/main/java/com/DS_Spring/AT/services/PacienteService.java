package com.DS_Spring.AT.services;
import com.DS_Spring.AT.entities.Paciente;
import com.DS_Spring.AT.repositories.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente criarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente buscarPaciente(Long id) {
        return pacienteRepository.findById(id).orElseThrow(() -> (new RuntimeException("Paciente não encontrado")));
    }

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    public void removerPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

}
