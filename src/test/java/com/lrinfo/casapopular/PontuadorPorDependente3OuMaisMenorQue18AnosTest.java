package com.lrinfo.casapopular;

import com.lrinfo.casapopular.dominio.entidade.Familia;
import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.PontuadorPorDependente3OuMaisMenorQue18AnosDeFamilia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PontuadorPorDependente3OuMaisMenorQue18AnosTest {

    private PontuadorPorDependente3OuMaisMenorQue18AnosDeFamilia pontuadorPorDependente3OuMaisMenorQue18Anos = new PontuadorPorDependente3OuMaisMenorQue18AnosDeFamilia();
    private Familia familia;
    private List<Pessoa> membrosDaFamilia = new ArrayList<>();
    private Pessoa pessoa1;
    private Pessoa pessoa2;
    private Pessoa pessoa3;
    private Pessoa pessoa4;

    @Test
    void devePontuar3PontosQuandoTiver3DependentesMenorDeDezoitoAnos() {
        pessoa1 = new Pessoa(500.0, 15);
        pessoa2 = new Pessoa(500.0, 14);
        pessoa3 = new Pessoa(500.0, 16);
        membrosDaFamilia.add(pessoa1);
        membrosDaFamilia.add(pessoa2);
        membrosDaFamilia.add(pessoa3);
        familia = new Familia(membrosDaFamilia);

        pontuadorPorDependente3OuMaisMenorQue18Anos.pontuar(familia);

        Assertions.assertEquals(3, familia.getTotalDePontosDaFamilia());
    }

    @Test
    void deveSomarPontosQuandoTiverMaisDe3DependentesMenorQueDezoitoAnos() {
        pessoa1 = new Pessoa(500.0, 15);
        pessoa2 = new Pessoa(500.0, 14);
        pessoa3 = new Pessoa(500.0, 16);
        pessoa4 = new Pessoa(500.0, 17);
        membrosDaFamilia.add(pessoa1);
        membrosDaFamilia.add(pessoa2);
        membrosDaFamilia.add(pessoa3);
        membrosDaFamilia.add(pessoa4);
        familia = new Familia(membrosDaFamilia);

        pontuadorPorDependente3OuMaisMenorQue18Anos.pontuar(familia);

        Assertions.assertEquals(3, familia.getTotalDePontosDaFamilia());
    }
}
