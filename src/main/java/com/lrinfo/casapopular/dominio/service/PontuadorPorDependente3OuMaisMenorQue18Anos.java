package com.lrinfo.casapopular.dominio.service;

import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.interfaces.IPontuadorDeFamilia;

public class PontuadorPorDependente3OuMaisMenorQue18Anos implements IPontuadorDeFamilia {
    @Override
    public void pontuar(Pessoa pessoa) {
        Integer pontosParaAdicionar = pessoa.getPontos();

        if (pessoa.getDependentesMenorQue18() >= 3)
            pontosParaAdicionar = somarPontos(pessoa.getPontos());

        pessoa.setPontos(pontosParaAdicionar);
    }

    @Override
    public Integer somarPontos(Integer pontos) {
        pontos += 3;
        return pontos;
    }

}
