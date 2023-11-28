package com.lrinfo.casapopular;

import com.lrinfo.casapopular.dominio.entidade.Familia;
import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.PontuadorPorRendaMenorOuIgualA900Reais;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PontuadorPorRendaMenorOuIgualA900ReaisTest {

    private PontuadorPorRendaMenorOuIgualA900Reais pontuadorPorRendaMenorOuIgualA900Reais = new PontuadorPorRendaMenorOuIgualA900Reais();
    private Familia familia;
    private List<Pessoa> membrosDaFamilia = new ArrayList<>();
    private Pessoa pessoa1;
    private Pessoa pessoa2;

    @Test
    void familiaDeveraTer5PontosQuandoRendaForAte900Reais() {
        pessoa1 = new Pessoa(500.0, 20);
        membrosDaFamilia.add(pessoa1);
        familia = new Familia(membrosDaFamilia);

        pontuadorPorRendaMenorOuIgualA900Reais.pontuar(familia);

        Assertions.assertEquals(5, familia.getTotalDePontosDaFamilia());
    }

    @Test
    void familiaDeveraTer5PontosQuandoRendaForIgualA900Reais() {
        pessoa1 = new Pessoa(500.0, 25);
        pessoa2 = new Pessoa(400.0, 15);
        membrosDaFamilia.add(pessoa1);
        membrosDaFamilia.add(pessoa2);
        familia = new Familia(membrosDaFamilia);

        pontuadorPorRendaMenorOuIgualA900Reais.pontuar(familia);

        Assertions.assertEquals(5, familia.getTotalDePontosDaFamilia());
    }

    @Test
    void familiaDeveraPontuar5PontosQuandoForMaiorQue900ReaisEMenorQue901() {
        pessoa1 = new Pessoa(500.5, 16);
        pessoa2 = new Pessoa(400.0, 6);
        membrosDaFamilia.add(pessoa1);
        membrosDaFamilia.add(pessoa2);
        familia = new Familia(membrosDaFamilia);

        pontuadorPorRendaMenorOuIgualA900Reais.pontuar(familia);

        Assertions.assertEquals(5, familia.getTotalDePontosDaFamilia());
    }
}
