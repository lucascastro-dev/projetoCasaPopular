package com.lrinfo.casapopular;

import com.lrinfo.casapopular.dominio.entidade.Familia;
import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.GeradorDeFamiliasAptasACasaPopular;
import com.lrinfo.casapopular.dominio.service.GerenciadorDoPontuador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class GeradorDeFamiliasAptasACasaPopularTest {
    @InjectMocks
    private GeradorDeFamiliasAptasACasaPopular geradorDeListaDePessoasAptas;
    @Mock
    GerenciadorDoPontuador gerenciadorDoPontuador;
    private Pessoa pessoa1 = new Pessoa(450.0, 18);
    private Pessoa pessoa2 = new Pessoa(1800.0, 19);
    private Pessoa pessoa3 = new Pessoa(300.0, 15);
    private Familia familia1;
    private Familia familia2;
    private Familia familia3;
    private List<Familia> familiasParaListas = new ArrayList<>();
    private List<Pessoa> membrosDaFamilia = new ArrayList<>();

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
        geradorDeListaDePessoasAptas = new GeradorDeFamiliasAptasACasaPopular(gerenciadorDoPontuador);
    }

    @Test
    void deveGerarUmaListaDeFamilias() {
        List<Familia> listaGerada = geradorDeListaDePessoasAptas.gerarListaOrdenada(familiasParaListas);

        Assertions.assertNotNull(listaGerada);
    }

    @Test
    void deveChamarOServicoDePontuarFamilia() {
        membrosDaFamilia.add(pessoa1);
        familia1 = new Familia(membrosDaFamilia);
        familiasParaListas.add(familia1);

        geradorDeListaDePessoasAptas.gerarListaOrdenada(familiasParaListas);

        Mockito.verify(gerenciadorDoPontuador, Mockito.times(1)).pontuar(familia1);
    }

    @Test
    void deveGerarUmaListaOrdenadaCom3Familias() {
        membrosDaFamilia.add(pessoa1);
        membrosDaFamilia.add(pessoa2);
        membrosDaFamilia.add(pessoa3);
        familia1 = new Familia(membrosDaFamilia);
        familia2 = new Familia(membrosDaFamilia);
        familia3 = new Familia(membrosDaFamilia);
        familiasParaListas.add(familia1);
        familiasParaListas.add(familia2);
        familiasParaListas.add(familia3);

        List<Familia> listaGerada = geradorDeListaDePessoasAptas.gerarListaOrdenada(familiasParaListas);

        Assertions.assertEquals(3, listaGerada.size());
    }

}
