package com.lrinfo.casapopular.dominio.entidade;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Familia implements IFamilia {
    List<Pessoa> membrosDaFamilia;
    Integer dependenteMenorQueDezoitoAnos = 0;
    Integer totalDePontosDaFamilia = 0;
    Double rendaTotal = 0.0;

    public Familia(List<Pessoa> membrosDaFamilia) {
        this.membrosDaFamilia = membrosDaFamilia;
    }

    @Override
    public void setTotalDePontosDaFamilia(Integer novosPontos) {
        this.totalDePontosDaFamilia = novosPontos;
    }
}
