package com.DS_Spring.AT.controllers;
import com.DS_Spring.AT.entities.Paciente;
import com.DS_Spring.AT.services.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes(){
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPacientePorId(@PathVariable Long id){
        return ResponseEntity.ok(pacienteService.buscarPaciente(id));
    }

    @PostMapping
    public ResponseEntity<Paciente> cadastrarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.criarPaciente(paciente));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarPaciente(@RequestBody Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
