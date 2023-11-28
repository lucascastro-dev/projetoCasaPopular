package com.lrinfo.casapopular.dominio.service;

import com.lrinfo.casapopular.dominio.entidade.Familia;
import com.lrinfo.casapopular.dominio.service.interfaces.IPontuadorDeFamilia;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.DoubleAdder;

public class PontuadorPorRendaMenorOuIgualA900Reais implements IPontuadorDeFamilia {
    @Override
    public void pontuar(Familia familia) {
        DoubleAdder rendaTotal = new DoubleAdder();
        Integer totalDePontosAtual = familia.getTotalDePontosDaFamilia();

        familia.getMembrosDaFamilia().forEach(pessoa -> rendaTotal.add(pessoa.getRenda()));

        if (rendaTotal.intValue() <= 900)
            familia.setTotalDePontosDaFamilia(somarPontos(totalDePontosAtual));
    }

    @Override
    public Integer somarPontos(Integer pontos) {
        pontos += 5;
        return pontos;
    }
}
