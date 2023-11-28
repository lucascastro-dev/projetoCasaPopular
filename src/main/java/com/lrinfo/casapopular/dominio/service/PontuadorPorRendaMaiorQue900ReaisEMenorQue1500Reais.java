package com.lrinfo.casapopular.dominio.service;

import com.lrinfo.casapopular.dominio.entidade.Familia;
import com.lrinfo.casapopular.dominio.service.interfaces.IPontuadorDeFamilia;
import com.lrinfo.casapopular.dominio.util.Constants;

import java.util.concurrent.atomic.DoubleAdder;

public class PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais implements IPontuadorDeFamilia {
    @Override
    public void pontuar(Familia familia) {
        DoubleAdder rendaTotal = new DoubleAdder();
        Integer totalDePontosAtual = familia.getTotalDePontosDaFamilia();

        familia.getMembrosDaFamilia().forEach(pessoa -> rendaTotal.add(pessoa.getRenda()));

        if (rendaTotal.intValue() >= 901 && rendaTotal.intValue() <= 1500)
            familia.setTotalDePontosDaFamilia(somarPontos(totalDePontosAtual));
    }

    @Override
    public Integer somarPontos(Integer pontos) {
        pontos += Constants.PONTOS_RENDA_MAIOR_QUE_900_MENOR_QUE_1500;
        return pontos;
    }
}
