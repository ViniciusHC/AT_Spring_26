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
public class Internacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dataEntrada;
    private String dataAlta;
    private Number quarto;

    @ManyToOne()
    @JoinColumn (name = "paciente_id")
    @JsonIgnore
    private Paciente paciente;

}
