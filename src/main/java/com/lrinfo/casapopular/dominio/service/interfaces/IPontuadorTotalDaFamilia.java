package com.lrinfo.casapopular.dominio.service.interfaces;

import com.lrinfo.casapopular.dominio.entidade.Familia;
import com.lrinfo.casapopular.dominio.entidade.Pessoa;

import java.util.List;

public interface IPontuadorTotalDaFamilia {
    Boolean pontuarPorDependentesMenorQueDezoito(List<Pessoa> membrosDaFamilia);

    void pontuar(Familia familia);
}
