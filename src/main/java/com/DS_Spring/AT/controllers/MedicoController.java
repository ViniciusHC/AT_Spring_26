package com.DS_Spring.AT.controllers;

import com.DS_Spring.AT.entities.Medico;
import com.DS_Spring.AT.services.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public ResponseEntity<List<Medico>> listMedicos() {
        return ResponseEntity.ok(medicoService.listarMedicos());
    }

    @PostMapping
    public ResponseEntity<Medico> criarMedico(@RequestBody Medico medico) {
        return ResponseEntity.ok(medicoService.cadastrarMedico(medico));
    }

}
