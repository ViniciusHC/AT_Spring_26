package com.DS_Spring.AT.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String dataConsulta;
    private String observacoes;

    @ManyToOne()
    @JoinColumn (name = "paciente_id")
    @JsonIgnore
    private Paciente paciente;

    @ManyToOne()
    @JoinColumn (name = "medico_id")
    @JsonIgnore
    private Medico medico;

}
