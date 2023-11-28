package com.lrinfo.casapopular.dominio.service;

import com.lrinfo.casapopular.dominio.entidade.Familia;
import com.lrinfo.casapopular.dominio.service.interfaces.IGeradorDeFamiliasAptasACasaPopular;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GeradorDeFamiliasAptasACasaPopular implements IGeradorDeFamiliasAptasACasaPopular {
    @Override
    public List<Familia> gerarListaOrdenada(List<Familia> familias) {
        return familias.stream()
                .sorted(Comparator.comparingInt(Familia::getTotalDePontosDaFamilia).reversed())
                .collect(Collectors.toList());
    }
}
