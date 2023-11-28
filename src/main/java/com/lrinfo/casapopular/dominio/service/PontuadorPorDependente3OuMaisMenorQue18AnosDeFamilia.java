package com.lrinfo.casapopular.dominio.service;

import com.lrinfo.casapopular.dominio.entidade.Familia;
import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.interfaces.IPontuadorDeFamilia;

public class PontuadorPorDependente3OuMaisMenorQue18AnosDeFamilia implements IPontuadorDeFamilia {
    @Override
    public void pontuar(Familia familia) {
        Integer totalDeMembrosMenorDeIdade = 0;
        Integer totalDePontosAtual = familia.getTotalDePontosDaFamilia();

        for (Pessoa pessoa : familia.getMembrosDaFamilia()) {
            if (pessoa.getIdade() < 18) {
                totalDeMembrosMenorDeIdade++;
            }
        }

        if (totalDeMembrosMenorDeIdade >= 3)
            familia.setTotalDePontosDaFamilia(somarPontos(totalDePontosAtual));
    }

    @Override
    public Integer somarPontos(Integer pontos) {
        pontos += 3;
        return pontos;
    }

}
