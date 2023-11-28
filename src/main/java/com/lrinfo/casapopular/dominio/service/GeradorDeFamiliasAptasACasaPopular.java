package com.lrinfo.casapopular.dominio.service;

import com.lrinfo.casapopular.dominio.entidade.Familia;
import com.lrinfo.casapopular.dominio.service.interfaces.IGeradorDeFamiliasAptasACasaPopular;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GeradorDeFamiliasAptasACasaPopular implements IGeradorDeFamiliasAptasACasaPopular {
    private final GerenciadorDoPontuador gerenciadorDoPontuador;

    @Override
    public List<Familia> gerarListaOrdenada(List<Familia> familias) {
        List<Familia> familiasEmOrdemPrioritarias = new ArrayList<>();

        if (familias != null) {
            for (Familia familia : familias) {
                gerenciadorDoPontuador.pontuar(familia);
                familiasEmOrdemPrioritarias.add(familia);
            }
        }

        return familiasEmOrdemPrioritarias.stream()
                .sorted(Comparator.comparingInt(Familia::getTotalDePontosDaFamilia).reversed())
                .collect(Collectors.toList());
    }
}
