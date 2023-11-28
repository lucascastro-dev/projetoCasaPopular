package com.lrinfo.casapopular.dominio.service.interfaces;

import com.lrinfo.casapopular.dominio.entidade.Familia;

import java.util.List;

public interface IGeradorDeListaDeFamiliasAptasACasaPopular {
    List<Familia> gerarListaOrdenada(List<Familia> pessoas);
}
