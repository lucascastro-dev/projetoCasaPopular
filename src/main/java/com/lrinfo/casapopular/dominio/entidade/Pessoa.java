package com.lrinfo.casapopular.dominio.entidade;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Pessoa implements IPessoa {
    Integer pontos = 0;
    Double renda = 0.0;
    Integer dependentesMenorQue18 = 0;

    public Pessoa(Double renda, Integer dependentesMenorQue18) {
        this.renda = renda;
        this.dependentesMenorQue18 = dependentesMenorQue18;
    }

    @Override
    public void setPontos(Integer novosPontos) {
        this.pontos = novosPontos;
    }
}
