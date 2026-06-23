package com.DS_Spring.AT.services;
import com.DS_Spring.AT.entities.Medico;
import com.DS_Spring.AT.repositories.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public Medico cadastrarMedico(Medico medico){
        return medicoRepository.save(medico);
    }

    public List<Medico> listarMedicos(){
        return medicoRepository.findAll();
    }
}
