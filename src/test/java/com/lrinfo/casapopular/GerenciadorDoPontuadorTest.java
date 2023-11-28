package com.lrinfo.casapopular;

import com.lrinfo.casapopular.dominio.entidade.Familia;
import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.GerenciadorDoPontuador;
import com.lrinfo.casapopular.dominio.service.PontuadorPorDependente1Ou2MenorQue18AnosDeFamilia;
import com.lrinfo.casapopular.dominio.service.PontuadorPorDependente3OuMaisMenorQue18AnosDeFamilia;
import com.lrinfo.casapopular.dominio.service.PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais;
import com.lrinfo.casapopular.dominio.service.PontuadorPorRendaMenorOuIgualA900Reais;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDoPontuadorTest {
    @InjectMocks
    private GerenciadorDoPontuador gerenciadorDoPontuador;
    @Mock
    private PontuadorPorRendaMenorOuIgualA900Reais pontuadorPorRendaMenorQue900;
    @Mock
    private PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais;
    @Mock
    private PontuadorPorDependente3OuMaisMenorQue18AnosDeFamilia pontuadorPorDependente3OuMaisMenorQue18Anos;
    @Mock
    private PontuadorPorDependente1Ou2MenorQue18AnosDeFamilia pontuadorPorDependente1ou2MenorQue18Anos;
    private List<Pessoa> membrosDaFamilia = new ArrayList<>();
    private Familia familia = new Familia(membrosDaFamilia);

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void deveChamarOServicoDePontuarPorRendaMenorQue900Reais() {
        gerenciadorDoPontuador.pontuar(familia);

        Mockito.verify(pontuadorPorRendaMenorQue900, Mockito.times(1)).pontuar(familia);
    }

    @Test
    void deveChamarOServicoDePontuarPorRendaMaiorQue900ReaisEMenorQue1500Reais() {
        gerenciadorDoPontuador.pontuar(familia);

        Mockito.verify(pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais, Mockito.times(1)).pontuar(familia);
    }

    @Test
    void deveChamarOServicoDePontuarPor3OuMaisDependentesMenorQueDezoito() {
        gerenciadorDoPontuador.pontuar(familia);

        Mockito.verify(pontuadorPorDependente3OuMaisMenorQue18Anos, Mockito.times(1)).pontuar(familia);
    }

    @Test
    void deveChamarOServicoDePontuarPor1ou2DependentesMenorQueDezoito() {
        gerenciadorDoPontuador.pontuar(familia);

        Mockito.verify(pontuadorPorDependente1ou2MenorQue18Anos, Mockito.times(1)).pontuar(familia);
    }
}
