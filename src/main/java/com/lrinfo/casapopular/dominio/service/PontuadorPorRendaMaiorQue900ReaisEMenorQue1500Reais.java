package com.lrinfo.casapopular.dominio.service;

import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.interfaces.IPontuadorDeFamilia;

public class PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais implements IPontuadorDeFamilia {
    @Override
    public void pontuar(Pessoa pessoa) {
        Integer pontosParaAdicionar = pessoa.getPontos();

        if (pessoa.getRenda().intValue() >= 901 && pessoa.getRenda().intValue() <= 1500)
            pontosParaAdicionar = somarPontos(pessoa.getPontos());

        pessoa.setPontos(pontosParaAdicionar);
    }

    @Override
    public Integer somarPontos(Integer pontos) {
        pontos += 3;
        return pontos;
    }
}
