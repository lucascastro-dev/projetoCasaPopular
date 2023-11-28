package com.lrinfo.casapopular.dominio.service;

import com.lrinfo.casapopular.dominio.entidade.Familia;
import com.lrinfo.casapopular.dominio.service.interfaces.IGerenciadorDoPontuador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GerenciadorDoPontuador implements IGerenciadorDoPontuador {
    private final PontuadorPorRendaMenorOuIgualA900Reais pontuadorPorRendaMenorQue900;
    private final PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais;
    private final PontuadorPorDependente1Ou2MenorQue18AnosDeFamilia pontuadorPorDependente1ou2MenorQue18Anos;
    private final PontuadorPorDependente3OuMaisMenorQue18AnosDeFamilia pontuadorPorDependente3OuMaisMenorQue18Anos;

    @Autowired
    public GerenciadorDoPontuador(PontuadorPorRendaMenorOuIgualA900Reais pontuadorPorRendaMenorQue900,
                                  PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais,
                                  PontuadorPorDependente3OuMaisMenorQue18AnosDeFamilia pontuadorPorDependente3OuMaisMenorQue18Anos,
                                  PontuadorPorDependente1Ou2MenorQue18AnosDeFamilia pontuadorPorDependente1ou2MenorQue18Anos
    ) {
        this.pontuadorPorRendaMenorQue900 = pontuadorPorRendaMenorQue900;
        this.pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais = pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais;
        this.pontuadorPorDependente1ou2MenorQue18Anos = pontuadorPorDependente1ou2MenorQue18Anos;
        this.pontuadorPorDependente3OuMaisMenorQue18Anos = pontuadorPorDependente3OuMaisMenorQue18Anos;
    }

    @Override
    public void pontuar(Familia familia) {
        pontuadorPorRendaMenorQue900.pontuar(familia);
        pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais.pontuar(familia);
        pontuadorPorDependente1ou2MenorQue18Anos.pontuar(familia);
        pontuadorPorDependente3OuMaisMenorQue18Anos.pontuar(familia);
    }
}
