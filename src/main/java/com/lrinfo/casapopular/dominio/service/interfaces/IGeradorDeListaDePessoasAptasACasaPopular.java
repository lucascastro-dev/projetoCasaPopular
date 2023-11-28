package com.lrinfo.casapopular.dominio.service.interfaces;

import com.lrinfo.casapopular.dominio.entidade.Pessoa;

import java.util.List;

public interface IGeradorDeListaDePessoasAptasACasaPopular {
    List<Pessoa> gerarListaOrdenada(List<Pessoa> pessoas);
}
