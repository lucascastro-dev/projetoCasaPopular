package com.lrinfo.casapopular;

import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.GerenciadorDoPontuadorDeFamilia;
import com.lrinfo.casapopular.dominio.service.PontuadorPorDependente1ou2MenorQue18Anos;
import com.lrinfo.casapopular.dominio.service.PontuadorPorDependente3OuMaisMenorQue18Anos;
import com.lrinfo.casapopular.dominio.service.PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais;
import com.lrinfo.casapopular.dominio.service.PontuadorPorRendaMenorOuIgualA900Reais;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class GerenciadorDoPontuadorDeFamiliaTest {
    @InjectMocks
    private GerenciadorDoPontuadorDeFamilia gerenciadorDoPontuadorDeFamilia;
    @Mock
    private PontuadorPorRendaMenorOuIgualA900Reais pontuadorPorRendaMenorQue900;
    @Mock
    private PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais;
    @Mock
    private PontuadorPorDependente3OuMaisMenorQue18Anos pontuadorPorDependente3OuMaisMenorQue18Anos;
    @Mock
    private PontuadorPorDependente1ou2MenorQue18Anos pontuadorPorDependente1ou2MenorQue18Anos;
    private Pessoa pessoa = new Pessoa(0.0, 0);

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void deveChamarOServicoDePontuarPorRendaMenorQue900Reais() {
        gerenciadorDoPontuadorDeFamilia.pontuar(pessoa);

        Mockito.verify(pontuadorPorRendaMenorQue900, Mockito.times(1)).pontuar(pessoa);
    }

    @Test
    void deveChamarOServicoDePontuarPorRendaMaiorQue900ReaisEMenorQue1500Reais() {
        gerenciadorDoPontuadorDeFamilia.pontuar(pessoa);

        Mockito.verify(pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais, Mockito.times(1)).pontuar(pessoa);
    }

    @Test
    void deveChamarOServicoDePontuarPor3OuMaisDependentesMenorQueDezoito() {
        gerenciadorDoPontuadorDeFamilia.pontuar(pessoa);

        Mockito.verify(pontuadorPorDependente3OuMaisMenorQue18Anos, Mockito.times(1)).pontuar(pessoa);
    }

    @Test
    void deveChamarOServicoDePontuarPor1ou2DependentesMenorQueDezoito() {
        gerenciadorDoPontuadorDeFamilia.pontuar(pessoa);

        Mockito.verify(pontuadorPorDependente1ou2MenorQue18Anos, Mockito.times(1)).pontuar(pessoa);
    }
}
