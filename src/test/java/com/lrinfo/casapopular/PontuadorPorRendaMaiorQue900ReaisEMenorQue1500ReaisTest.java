package com.lrinfo.casapopular;

import com.lrinfo.casapopular.dominio.entidade.Familia;
import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PontuadorPorRendaMaiorQue900ReaisEMenorQue1500ReaisTest {
    private PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais = new PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais();
    private Familia familia;
    private List<Pessoa> membrosDaFamilia = new ArrayList<>();
    private Pessoa pessoa1;
    private Pessoa pessoa2;

    @Test
    void familiaDeveraPontuar3PontosQuandoForMaiorOuIgualA901EMenorQue1500() {
        pessoa1 = new Pessoa(901.0, 20);
        membrosDaFamilia.add(pessoa1);
        familia = new Familia(membrosDaFamilia);

        pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais.pontuar(familia);

        Assertions.assertEquals(3, familia.getTotalDePontosDaFamilia());
    }

    @Test
    void familiaDeveraPontuar3PontosQuandoForIgualA1500EMenorQue1501() {
        pessoa1 = new Pessoa(501.9, 25);
        pessoa2 = new Pessoa(400.0, 15);
        membrosDaFamilia.add(pessoa1);
        membrosDaFamilia.add(pessoa2);
        familia = new Familia(membrosDaFamilia);

        pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais.pontuar(familia);

        Assertions.assertEquals(3, familia.getTotalDePontosDaFamilia());
    }
}
