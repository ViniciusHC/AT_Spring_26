package com.DS_Spring.AT.controllers;

import com.DS_Spring.AT.entities.Consulta;
import com.DS_Spring.AT.services.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping
    public ResponseEntity<Consulta> criarConsulta(@RequestBody Consulta consulta) {
        return ResponseEntity.ok(consultaService.cadastrarConsulta(consulta));
    }
}
