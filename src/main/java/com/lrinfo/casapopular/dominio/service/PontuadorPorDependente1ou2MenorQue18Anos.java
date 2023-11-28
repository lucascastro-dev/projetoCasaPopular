package com.lrinfo.casapopular.dominio.service;

import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.interfaces.IPontuadorDeFamilia;

public class PontuadorPorDependente1ou2MenorQue18Anos implements IPontuadorDeFamilia {
    @Override
    public void pontuar(Pessoa pessoa) {
        Integer pontosParaAdicionar = pessoa.getPontos();

        if (pessoa.getDependentesMenorQue18() == 1 || pessoa.getDependentesMenorQue18() == 2)
            pontosParaAdicionar = somarPontos(pessoa.getPontos());

        pessoa.setPontos(pontosParaAdicionar);
    }

    @Override
    public Integer somarPontos(Integer pontos) {
        pontos += 2;
        return pontos;
    }
}
