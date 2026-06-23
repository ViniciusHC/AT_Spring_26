package com.DS_Spring.AT.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String CPF;
    private String dataNascimento;
    private String telefone;

    @OneToMany (mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Consulta> consultas;


    @OneToMany (mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Internacao> internacoes;

    public Paciente(Long id, String nome, String CPF, String dataNascimento, String telefone) {
        this.id = id;
        this.nome = nome;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

}
