package com.DS_Spring.AT.repositories;

import com.DS_Spring.AT.entities.Consulta;
import com.DS_Spring.AT.entities.Internacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
