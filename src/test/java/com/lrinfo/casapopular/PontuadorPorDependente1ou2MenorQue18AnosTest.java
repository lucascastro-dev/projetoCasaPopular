package com.lrinfo.casapopular;

import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.PontuadorPorDependente1ou2MenorQue18Anos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PontuadorPorDependente1ou2MenorQue18AnosTest {

    private PontuadorPorDependente1ou2MenorQue18Anos pontuadorPorDependente1Ou2MenorQue18Anos = new PontuadorPorDependente1ou2MenorQue18Anos();
    private Pessoa pessoa;

    @Test
    void deveSomar2PontosQuandoTiver1DependenteMenorDeDezoitoAnos() {
        pessoa = new Pessoa(0.0, 1);

        pontuadorPorDependente1Ou2MenorQue18Anos.pontuar(pessoa);

        Assertions.assertEquals(2, pessoa.getPontos());
    }

    @Test
    void deveSomar2PontosQuandoTiver2DependentesMenorQueDezoitoAnos() {
        pessoa = new Pessoa(0.0, 2);

        pontuadorPorDependente1Ou2MenorQue18Anos.pontuar(pessoa);

        Assertions.assertEquals(2, pessoa.getPontos());
    }
}
