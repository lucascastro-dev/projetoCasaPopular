package com.lrinfo.casapopular.dominio.service;

import com.lrinfo.casapopular.dominio.entidade.Familia;
import com.lrinfo.casapopular.dominio.service.interfaces.IGeradorDeListaDeFamiliasAptasACasaPopular;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GeradorDeListaDeFamiliasAptasACasaPopular implements IGeradorDeListaDeFamiliasAptasACasaPopular {
    @Override
    public List<Familia> gerarListaOrdenada(List<Familia> familias) {
        List<Familia> pessoasAptas = familias.stream()
                .sorted(Comparator.comparingInt(Familia::getTotalDePontosDaFamilia).reversed())
                .collect(Collectors.toList());

        return pessoasAptas;
    }
}
