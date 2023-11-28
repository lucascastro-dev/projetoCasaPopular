package com.lrinfo.casapopular;

import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.PontuadorPorDependente3OuMaisMenorQue18Anos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PontuadorPorDependente3OuMaisMenorQue18AnosTest {

    private PontuadorPorDependente3OuMaisMenorQue18Anos pontuadorPorDependente3OuMaisMenorQue18Anos = new PontuadorPorDependente3OuMaisMenorQue18Anos();
    private Pessoa pessoa;

    @Test
    void devePontuar3PontosQuandoTiver3DependentesMenorDeDezoitoAnos() {
        pessoa = new Pessoa(0.0, 3);

        pontuadorPorDependente3OuMaisMenorQue18Anos.pontuar(pessoa);

        Assertions.assertEquals(3, pessoa.getPontos());
    }

    @Test
    void deveSomarPontosQuandoTiverMaisDe3DependentesMenorQueDezoitoAnos() {
        pessoa = new Pessoa(0.0, 5);

        pontuadorPorDependente3OuMaisMenorQue18Anos.pontuar(pessoa);

        Assertions.assertEquals(3, pessoa.getPontos());
    }
}
