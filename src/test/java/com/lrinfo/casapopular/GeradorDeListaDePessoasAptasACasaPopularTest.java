package com.lrinfo.casapopular;

import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.GeradorDeListaDePessoasAptasACasaPopular;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GeradorDeListaDePessoasAptasACasaPopularTest {
    private GeradorDeListaDePessoasAptasACasaPopular geradorDeListaDePessoasAptas = new GeradorDeListaDePessoasAptasACasaPopular();
    private Pessoa pessoa1 = new Pessoa(0.0, 0);
    private Pessoa pessoa2 = new Pessoa(0.0, 0);
    private Pessoa pessoa3 = new Pessoa(0.0, 0);
    private List<Pessoa> pessoasParaListar = new ArrayList<>();

    @Test
    void deveGerarUmaListaDePessoas() {
        List<Pessoa> listaGerada = geradorDeListaDePessoasAptas.gerarListaOrdenada(pessoasParaListar);

        Assertions.assertNotNull(listaGerada);
    }

    @Test
    void deveGerarUmaListaOrdenadaCom3Pessoas() {
        pessoa1.setPontos(5);
        pessoa2.setPontos(3);
        pessoa3.setPontos(1);
        pessoasParaListar.add(pessoa1);
        pessoasParaListar.add(pessoa2);
        pessoasParaListar.add(pessoa3);

        List<Pessoa> listaGerada = geradorDeListaDePessoasAptas.gerarListaOrdenada(pessoasParaListar);

        Assertions.assertEquals(3, listaGerada.size());
    }

    @Test
    void deveGerarUmaListaOrdenadaCom2Pessoas() {
        pessoa1.setPontos(5);
        pessoa2.setPontos(0);
        pessoa3.setPontos(1);
        pessoasParaListar.add(pessoa1);
        pessoasParaListar.add(pessoa2);
        pessoasParaListar.add(pessoa3);

        List<Pessoa> listaGerada = geradorDeListaDePessoasAptas.gerarListaOrdenada(pessoasParaListar);

        Assertions.assertEquals(2, listaGerada.size());
    }

    @Test
    void aPessoa2DeveEstarNaPrimeiraPosicaoPorTerMaisPontos() {
        pessoa1.setPontos(5);
        pessoa2.setPontos(8);
        pessoa3.setPontos(1);
        pessoasParaListar.add(pessoa1);
        pessoasParaListar.add(pessoa2);
        pessoasParaListar.add(pessoa3);

        List<Pessoa> listaGerada = geradorDeListaDePessoasAptas.gerarListaOrdenada(pessoasParaListar);

        Assertions.assertEquals(pessoa2, listaGerada.get(0));
    }
}
