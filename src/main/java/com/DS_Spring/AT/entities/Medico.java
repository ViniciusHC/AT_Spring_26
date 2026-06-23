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
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String CRM;
    private String especialidade;

    @OneToMany (mappedBy = "medico", cascade = CascadeType.ALL)
    private List<Consulta> consultas;


    public Medico(Long id, String nome, String CRM, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.CRM = CRM;
        this.especialidade = especialidade;
    }
}
