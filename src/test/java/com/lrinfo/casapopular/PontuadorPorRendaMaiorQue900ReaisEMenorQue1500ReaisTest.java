package com.lrinfo.casapopular;

import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PontuadorPorRendaMaiorQue900ReaisEMenorQue1500ReaisTest {
    private PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais = new PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais();
    private Pessoa pessoa;


    @Test
    void familiaDeveraPontuar3PontosQuandoForMaiorOuIgualA901EMenorQue1500() {
        pessoa = new Pessoa(901.0, 0);

        pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais.pontuar(pessoa);

        Assertions.assertEquals(3, pessoa.getPontos());
    }

    @Test
    void familiaDeveraPontuar3PontosQuandoForIgualA1500EMenorQue1501() {
        pessoa = new Pessoa(901.9, 0);

        pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais.pontuar(pessoa);

        Assertions.assertEquals(3, pessoa.getPontos());
    }
}
