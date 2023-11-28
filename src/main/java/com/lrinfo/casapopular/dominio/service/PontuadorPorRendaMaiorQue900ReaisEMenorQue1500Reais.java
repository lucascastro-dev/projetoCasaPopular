package com.lrinfo.casapopular.dominio.service;

import com.lrinfo.casapopular.dominio.entidade.Familia;
import com.lrinfo.casapopular.dominio.service.interfaces.IPontuadorDeFamilia;

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
        pontos += 3;
        return pontos;
    }
}
