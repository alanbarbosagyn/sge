package br.com.abce.sge.repository;

import br.com.abce.sge.entity.MesaEntity;

import java.util.List;

public interface MesaRepository {

    MesaEntity buscar(final Long idMesa);

    void salvar(final MesaEntity mesa);

    void remover(final Long idMesa);

    List<MesaEntity> listar(final Long idEstabelecimento);

    MesaEntity buscar(final String identMesa);
}
