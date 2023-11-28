package com.lrinfo.casapopular.dominio.entidade;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Pessoa {
    Double renda = 0.0;
    Integer idade = 0;

    public Pessoa(Double renda, Integer idade) {
        this.renda = renda;
        this.idade = idade;
    }
}
