package com.lrinfo.casapopular;

import com.lrinfo.casapopular.dominio.entidade.Familia;
import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.PontuadorPorDependente1Ou2MenorQue18AnosDeFamilia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PontuadorPorDependente1ou2MenorQue18AnosTest {

    private PontuadorPorDependente1Ou2MenorQue18AnosDeFamilia pontuadorPorDependente1Ou2MenorQue18Anos = new PontuadorPorDependente1Ou2MenorQue18AnosDeFamilia();
    private Familia familia;
    private List<Pessoa> membrosDaFamilia = new ArrayList<>();
    private Pessoa pessoa1;
    private Pessoa pessoa2;

    @Test
    void deveSomar2PontosQuandoTiver1DependenteMenorDeDezoitoAnos() {
        pessoa1 = new Pessoa(500.0, 15);
        membrosDaFamilia.add(pessoa1);
        familia = new Familia(membrosDaFamilia);

        pontuadorPorDependente1Ou2MenorQue18Anos.pontuar(familia);

        Assertions.assertEquals(2, familia.getTotalDePontosDaFamilia());
    }

    @Test
    void deveSomar2PontosQuandoTiver2DependentesMenorQueDezoitoAnos() {
        pessoa1 = new Pessoa(500.0, 15);
        pessoa2 = new Pessoa(300.0, 17);
        membrosDaFamilia.add(pessoa1);
        membrosDaFamilia.add(pessoa2);
        familia = new Familia(membrosDaFamilia);

        pontuadorPorDependente1Ou2MenorQue18Anos.pontuar(familia);

        Assertions.assertEquals(2, familia.getTotalDePontosDaFamilia());
    }

    @Test
    void naoDeveraSomarPontosSeForMembrosSomenteMaiorOuIgualQue18Anos(){
        pessoa1 = new Pessoa(500.0, 18);
        pessoa2 = new Pessoa(300.0, 19);
        membrosDaFamilia.add(pessoa1);
        membrosDaFamilia.add(pessoa2);
        familia = new Familia(membrosDaFamilia);

        pontuadorPorDependente1Ou2MenorQue18Anos.pontuar(familia);

        Assertions.assertEquals(0, familia.getTotalDePontosDaFamilia());
    }
}
