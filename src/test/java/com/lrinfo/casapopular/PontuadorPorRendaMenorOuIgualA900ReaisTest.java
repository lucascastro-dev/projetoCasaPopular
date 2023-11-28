package com.lrinfo.casapopular;

import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.PontuadorPorRendaMenorOuIgualA900Reais;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PontuadorPorRendaMenorOuIgualA900ReaisTest {

    private PontuadorPorRendaMenorOuIgualA900Reais pontuadorPorRendaMenorOuIgualA900Reais = new PontuadorPorRendaMenorOuIgualA900Reais();
    private Pessoa pessoa;

    @Test
    void familiaDeveraTer5PontosQuandoRendaForAte900Reais() {
        pessoa = new Pessoa(800.0, 0);

        pontuadorPorRendaMenorOuIgualA900Reais.pontuar(pessoa);

        Assertions.assertEquals(5, pessoa.getPontos());
    }

    @Test
    void familiaDeveraTer5PontosQuandoRendaForIgualA900Reais() {
        pessoa = new Pessoa(900.0, 0);

        pontuadorPorRendaMenorOuIgualA900Reais.pontuar(pessoa);

        Assertions.assertEquals(5, pessoa.getPontos());
    }

    @Test
    void familiaDeveraPontuar5PontosQuandoForMaiorQue900ReaisEMenorQue901() {
        pessoa = new Pessoa(900.5, 0);

        pontuadorPorRendaMenorOuIgualA900Reais.pontuar(pessoa);

        Assertions.assertEquals(5, pessoa.getPontos());
    }
}
