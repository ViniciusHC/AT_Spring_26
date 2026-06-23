package com.DS_Spring.AT.repositories;
import com.DS_Spring.AT.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findById(long id);
}
