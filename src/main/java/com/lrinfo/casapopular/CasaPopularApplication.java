package com.lrinfo.casapopular;

import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.GeradorDeListaDePessoasAptasACasaPopular;
import com.lrinfo.casapopular.dominio.service.GerenciadorDoPontuadorDeFamilia;
import com.lrinfo.casapopular.dominio.service.PontuadorPorDependente1ou2MenorQue18Anos;
import com.lrinfo.casapopular.dominio.service.PontuadorPorDependente3OuMaisMenorQue18Anos;
import com.lrinfo.casapopular.dominio.service.PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais;
import com.lrinfo.casapopular.dominio.service.PontuadorPorRendaMenorOuIgualA900Reais;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CasaPopularApplication {

    public static void main(String[] args) {
        GeradorDeListaDePessoasAptasACasaPopular geradorDeLista = new GeradorDeListaDePessoasAptasACasaPopular();
        List<Pessoa> listaDePessoas = new ArrayList<>();
        PontuadorPorRendaMenorOuIgualA900Reais pontuadorPorRendaMenorQue900 = new PontuadorPorRendaMenorOuIgualA900Reais();
        PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais = new PontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais();
        PontuadorPorDependente3OuMaisMenorQue18Anos pontuadorPorDependente3OuMaisMenorQue18Anos = new PontuadorPorDependente3OuMaisMenorQue18Anos();
        PontuadorPorDependente1ou2MenorQue18Anos pontuadorPorDependente1ou2MenorQue18Ano = new PontuadorPorDependente1ou2MenorQue18Anos();

        GerenciadorDoPontuadorDeFamilia gerenciadorDoPontuadorDeFamilia = new GerenciadorDoPontuadorDeFamilia(pontuadorPorRendaMenorQue900,
                pontuadorPorRendaMaiorQue900ReaisEMenorQue1500Reais, pontuadorPorDependente3OuMaisMenorQue18Anos, pontuadorPorDependente1ou2MenorQue18Ano
        );

        Pessoa pessoa1 = new Pessoa(600.0, 4);
        Pessoa pessoa2 = new Pessoa(1700.0, 6);
        Pessoa pessoa3 = new Pessoa(2500.0, 0);
        Pessoa pessoa4 = new Pessoa(1500.0, 1);

        gerenciadorDoPontuadorDeFamilia.pontuar(pessoa1);
        gerenciadorDoPontuadorDeFamilia.pontuar(pessoa2);
        gerenciadorDoPontuadorDeFamilia.pontuar(pessoa3);
        gerenciadorDoPontuadorDeFamilia.pontuar(pessoa4);

        listaDePessoas.add(pessoa1);
        listaDePessoas.add(pessoa2);
        listaDePessoas.add(pessoa3);
        listaDePessoas.add(pessoa4);

        List<Pessoa> pessoasAptas = geradorDeLista.gerarListaOrdenada(listaDePessoas);
        ;

        pessoasAptas.forEach(pessoa -> {
            log.info(pessoa.toString());
        });
    }
}
