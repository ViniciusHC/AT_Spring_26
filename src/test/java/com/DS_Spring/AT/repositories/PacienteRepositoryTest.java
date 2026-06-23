package com.DS_Spring.AT.repositories;
import com.DS_Spring.AT.entities.Paciente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class PacienteRepositoryTest {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Test
    void deveSalvarPacienteComSucesso() {
        Paciente paciente = new Paciente(null, "Vinicius", "000000", "10-11-1994", "999999");
        Paciente pacienteSalvo = pacienteRepository.save(paciente);
        assertNotNull(pacienteSalvo.getId());
    }

    @Test
    void deveBuscarPacienteComSucesso() {
        Paciente paciente = new Paciente(null, "Vinicius", "000000", "10-11-1994", "999999");
        pacienteRepository.save(paciente);
        Optional<Paciente> pacienteBuscado = pacienteRepository.findById(paciente.getId());
        assertTrue(pacienteBuscado.isPresent());
    }

    @Test
    void deveDeletarPacienteComSucesso() {
        Paciente paciente = new Paciente(null, "Vinicius", "000000", "10-11-1994", "999999");
        pacienteRepository.save(paciente);
        pacienteRepository.deleteById(paciente.getId());
        Optional<Paciente> pacienteBuscado = pacienteRepository.findById(paciente.getId());
        assertFalse(pacienteBuscado.isPresent());
    }

}
