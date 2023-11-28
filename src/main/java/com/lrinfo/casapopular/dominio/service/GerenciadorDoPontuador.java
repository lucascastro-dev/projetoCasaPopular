package com.lrinfo.casapopular.dominio.service;

import com.lrinfo.casapopular.dominio.entidade.Familia;
import com.lrinfo.casapopular.dominio.service.interfaces.IGerenciadorDoPontuador;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GerenciadorDoPontuador implements IGerenciadorDoPontuador {
    private final PontuadorPorRendaMenorOuIgualA900Reais pontuadorPorRendaMenorQue900;
    private final PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais;
    private final PontuadorPorDependente1Ou2MenorQue18AnosDeFamilia pontuadorPorDependente1ou2MenorQue18Anos;
    private final PontuadorPorDependente3OuMaisMenorQue18AnosDeFamilia pontuadorPorDependente3OuMaisMenorQue18Anos;

    @Override
    public void pontuar(Familia familia) {
        pontuadorPorRendaMenorQue900.pontuar(familia);
        pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais.pontuar(familia);
        pontuadorPorDependente1ou2MenorQue18Anos.pontuar(familia);
        pontuadorPorDependente3OuMaisMenorQue18Anos.pontuar(familia);
    }
}
