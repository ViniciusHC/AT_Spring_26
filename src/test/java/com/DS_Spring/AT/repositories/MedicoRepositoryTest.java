package com.DS_Spring.AT.repositories;
import com.DS_Spring.AT.entities.Medico;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class MedicoRepositoryTest {

    @Autowired
    private MedicoRepository medicoRepository;

    @Test
    void deveSalvarMedicoComSucesso() {
        Medico medico = new Medico(null, "Dr. João", "CRM123", "Cardiologia");
        Medico medicoSalvo = medicoRepository.save(medico);
        assertNotNull(medicoSalvo.getId());
    }

    @Test
    void deveBuscarMedicoComSucesso() {
        Medico medico = new Medico(null, "Dr. João", "CRM123", "Cardiologia");
        medicoRepository.save(medico);
        Optional<Medico> medicoBuscado = medicoRepository.findById(medico.getId());
        assertTrue(medicoBuscado.isPresent());
    }

    @Test
    void deveDeletarMedicoComSucesso() {
        Medico medico = new Medico(null, "Dr. João", "CRM123", "Cardiologia");
        medicoRepository.save(medico);
        medicoRepository.deleteById(medico.getId());
        Optional<Medico> medicoBuscado = medicoRepository.findById(medico.getId());
        assertFalse(medicoBuscado.isPresent());
    }
}
