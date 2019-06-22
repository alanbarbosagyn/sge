package br.com.abce.sge.repository;

import br.com.abce.sge.entity.GarcomEntity;

import java.util.List;

public interface GarcomRepository {
    
    void salvar(GarcomEntity entity);

    List<GarcomEntity> listar(Long idEstabelecimento);

    void remover(Long id);

    GarcomEntity buscar(final Long idGarcom);
}
