package br.com.abce.sge.repository;

import br.com.abce.sge.entity.EstabelecimentoEntity;

import java.util.List;

public interface EstabelecimentoRepository {

    void salvar(final EstabelecimentoEntity estabelecimentoEntity);

    List<EstabelecimentoEntity> listar();

    void remover(final Long idEstabelecimento);

    EstabelecimentoEntity buscar(final Long idEstabelecimento);
}
