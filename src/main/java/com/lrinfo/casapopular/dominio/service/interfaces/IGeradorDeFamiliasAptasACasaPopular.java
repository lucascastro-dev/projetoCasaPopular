package com.lrinfo.casapopular.dominio.service.interfaces;

import com.lrinfo.casapopular.dominio.entidade.Familia;

import java.util.List;

public interface IGeradorDeFamiliasAptasACasaPopular {
    List<Familia> gerarListaOrdenada(List<Familia> pessoas);
}
