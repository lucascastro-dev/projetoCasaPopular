package com.lrinfo.casapopular;

import com.lrinfo.casapopular.dominio.entidade.Familia;
import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.GeradorDeFamiliasAptasACasaPopular;
import com.lrinfo.casapopular.dominio.service.GerenciadorDoPontuador;
import com.lrinfo.casapopular.dominio.service.PontuadorPorDependente1Ou2MenorQue18AnosDeFamilia;
import com.lrinfo.casapopular.dominio.service.PontuadorPorDependente3OuMaisMenorQue18AnosDeFamilia;
import com.lrinfo.casapopular.dominio.service.PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais;
import com.lrinfo.casapopular.dominio.service.PontuadorPorRendaMenorOuIgualA900Reais;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CasaPopularApplication {

    public static void main(String[] args) {
        PontuadorPorRendaMenorOuIgualA900Reais pontuadorPorRendaMenorQue900 = new PontuadorPorRendaMenorOuIgualA900Reais();
        PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais = new PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais();
        PontuadorPorDependente3OuMaisMenorQue18AnosDeFamilia pontuadorPorDependente3OuMaisMenorQue18Anos = new PontuadorPorDependente3OuMaisMenorQue18AnosDeFamilia();
        PontuadorPorDependente1Ou2MenorQue18AnosDeFamilia pontuadorPorDependente1ou2MenorQue18Ano = new PontuadorPorDependente1Ou2MenorQue18AnosDeFamilia();

        GerenciadorDoPontuador gerenciadorDoPontuador = new GerenciadorDoPontuador(pontuadorPorRendaMenorQue900,
                pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais, pontuadorPorDependente1ou2MenorQue18Ano, pontuadorPorDependente3OuMaisMenorQue18Anos);

        GeradorDeFamiliasAptasACasaPopular geradorDeLista = new GeradorDeFamiliasAptasACasaPopular(gerenciadorDoPontuador);

        List<Pessoa> membrosDaFamilia1 = new ArrayList<>();
        List<Pessoa> membrosDaFamilia2 = new ArrayList<>();
        List<Pessoa> membrosDaFamilia3 = new ArrayList<>();

        Pessoa pessoa1 = new Pessoa(350.0, 19);
        Pessoa pessoa2 = new Pessoa(100.0, 14);
        Pessoa pessoa3 = new Pessoa(25.0, 13);
        membrosDaFamilia1.add(pessoa1);
        membrosDaFamilia1.add(pessoa2);
        membrosDaFamilia1.add(pessoa3);

        Pessoa pessoa4 = new Pessoa(900.0, 25);
        membrosDaFamilia2.add(pessoa4);

        Pessoa pessoa5 = new Pessoa(400.0, 27);
        Pessoa pessoa6 = new Pessoa(100.0, 9);
        Pessoa pessoa7 = new Pessoa(100.0, 5);
        Pessoa pessoa8 = new Pessoa(100.0, 12);
        membrosDaFamilia3.add(pessoa5);
        membrosDaFamilia3.add(pessoa6);
        membrosDaFamilia3.add(pessoa7);
        membrosDaFamilia3.add(pessoa8);

        Familia familia1 = new Familia(membrosDaFamilia1);
        Familia familia2 = new Familia(membrosDaFamilia2);
        Familia familia3 = new Familia(membrosDaFamilia3);

        List<Familia> listaDeFamilias = new ArrayList<>();
        listaDeFamilias.add(familia1);
        listaDeFamilias.add(familia2);
        listaDeFamilias.add(familia3);

        List<Familia> familiasAptas = geradorDeLista.gerarListaOrdenada(listaDeFamilias);

        familiasAptas.forEach(familia -> {
            log.info("Total de pontos da família: " + familia.getTotalDePontosDaFamilia().toString());
        });
    }
}
