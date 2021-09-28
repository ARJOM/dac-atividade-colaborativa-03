package br.edu.ifpb.core.domain;

import br.edu.ifpb.core.infra.converter.ConverterCPF;
import br.edu.ifpb.core.infra.converter.LocalDateConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Integrante implements Serializable {
    @Id
    private int id;
    private String nome;

    @Temporal(TemporalType.DATE)
    @Convert(converter = LocalDateConverter.class)
    private LocalDate dataDeNascimento;

    @Convert(converter = ConverterCPF.class)
    private final CPF cpf = new CPF("");
}
