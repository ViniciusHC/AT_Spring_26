package com.DS_Spring.AT.service;
import com.DS_Spring.AT.entities.Paciente;
import com.DS_Spring.AT.repositories.PacienteRepository;
import com.DS_Spring.AT.services.PacienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PacienteServiceTest {

    @InjectMocks
    private PacienteService pacienteService;

    @Mock
    private PacienteRepository pacienteRepository;

    @Test
    void deveRetornarMensagemPacienteNaoEncontrado() {
        Long idInexistente = 1L;

        when(pacienteRepository.findById(idInexistente))
                .thenReturn(Optional.empty());

        RuntimeException naoEcontrado = assertThrows(RuntimeException.class, () -> {
            pacienteService.buscarPaciente(idInexistente);
        });

        assertEquals("Paciente não encontrado", naoEcontrado.getMessage());
    }
}
