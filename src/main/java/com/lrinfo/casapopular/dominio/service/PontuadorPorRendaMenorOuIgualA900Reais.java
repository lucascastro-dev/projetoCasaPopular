package com.lrinfo.casapopular.dominio.service;

import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.interfaces.IPontuadorDeFamilia;
import org.springframework.stereotype.Component;

public class PontuadorPorRendaMenorOuIgualA900Reais implements IPontuadorDeFamilia {
    @Override
    public void pontuar(Pessoa pessoa) {
        Integer pontosParaAdicionar = pessoa.getPontos();

        if (pessoa.getRenda().intValue() <= 900)
            pontosParaAdicionar = somarPontos(pessoa.getPontos());

        pessoa.setPontos(pontosParaAdicionar);
    }

    @Override
    public Integer somarPontos(Integer pontos) {
        pontos += 5;
        return pontos;
    }
}
