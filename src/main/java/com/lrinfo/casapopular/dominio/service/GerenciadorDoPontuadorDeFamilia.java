package com.lrinfo.casapopular.dominio.service;

import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.interfaces.IGerenciadorDoPontuador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GerenciadorDoPontuadorDeFamilia implements IGerenciadorDoPontuador {
    private final PontuadorPorRendaMenorOuIgualA900Reais pontuadorPorRendaMenorQue900;
    private final PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais;
    private final PontuadorPorDependente1ou2MenorQue18Anos pontuadorPorDependente1ou2MenorQue18Anos;
    private final PontuadorPorDependente3OuMaisMenorQue18Anos pontuadorPorDependente3OuMaisMenorQue18Anos;

    @Autowired
    public GerenciadorDoPontuadorDeFamilia(PontuadorPorRendaMenorOuIgualA900Reais pontuadorPorRendaMenorQue900,
                                           PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais,
                                           PontuadorPorDependente3OuMaisMenorQue18Anos pontuadorPorDependente3OuMaisMenorQue18Anos,
                                           PontuadorPorDependente1ou2MenorQue18Anos pontuadorPorDependente1ou2MenorQue18Anos
    ) {
        this.pontuadorPorRendaMenorQue900 = pontuadorPorRendaMenorQue900;
        this.pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais = pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais;
        this.pontuadorPorDependente1ou2MenorQue18Anos = pontuadorPorDependente1ou2MenorQue18Anos;
        this.pontuadorPorDependente3OuMaisMenorQue18Anos = pontuadorPorDependente3OuMaisMenorQue18Anos;
    }

    @Override
    public void pontuar(Pessoa pessoa) {
        pontuadorPorRendaMenorQue900.pontuar(pessoa);
        pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais.pontuar(pessoa);
        pontuadorPorDependente1ou2MenorQue18Anos.pontuar(pessoa);
        pontuadorPorDependente3OuMaisMenorQue18Anos.pontuar(pessoa);
    }
}
