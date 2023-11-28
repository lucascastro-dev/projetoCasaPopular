package com.lrinfo.casapopular.dominio.service;

import com.lrinfo.casapopular.dominio.entidade.Familia;
import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.interfaces.IPontuadorDeFamilia;
import com.lrinfo.casapopular.dominio.util.Constants;

public class PontuadorPorDependente1Ou2MenorQue18AnosDeFamilia implements IPontuadorDeFamilia {
    @Override
    public void pontuar(Familia familia) {
        Integer totalDeMembrosMenorDeIdade = 0;
        Integer totalDePontosAtual = familia.getTotalDePontosDaFamilia();

        for (Pessoa pessoa : familia.getMembrosDaFamilia()) {
            if (pessoa.getIdade() < 18) {
                totalDeMembrosMenorDeIdade++;
            }
        }

        if (totalDeMembrosMenorDeIdade == 1 || totalDeMembrosMenorDeIdade == 2)
            familia.setTotalDePontosDaFamilia(somarPontos(totalDePontosAtual));
    }

    @Override
    public Integer somarPontos(Integer pontos) {
        pontos += Constants.PONTOS_POR_1_OU_2_DEPENDENTES_MENOR_QUE_18_ANOS;
        return pontos;
    }
}
