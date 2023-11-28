package com.lrinfo.casapopular.dominio.service;

import com.lrinfo.casapopular.dominio.entidade.Pessoa;
import com.lrinfo.casapopular.dominio.service.interfaces.IGeradorDeListaDePessoasAptasACasaPopular;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GeradorDeListaDePessoasAptasACasaPopular implements IGeradorDeListaDePessoasAptasACasaPopular {
    @Override
    public List<Pessoa> gerarListaOrdenada(List<Pessoa> pessoas) {
        List<Pessoa> pessoasAptas = pessoas.stream()
                .filter(pessoa -> pessoa.getPontos() > 0)
                .sorted(Comparator.comparingInt(Pessoa::getPontos).reversed())
                .collect(Collectors.toList());

        return pessoasAptas;
    }
}
