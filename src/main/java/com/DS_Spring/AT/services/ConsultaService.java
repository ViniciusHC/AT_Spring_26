package com.DS_Spring.AT.services;

import com.DS_Spring.AT.entities.Consulta;
import com.DS_Spring.AT.repositories.ConsultaRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public Consulta cadastrarConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

}
